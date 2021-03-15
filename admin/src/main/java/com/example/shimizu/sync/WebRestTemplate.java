package com.example.shimizu.sync;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Shimizu
 * @description
 * @date 2021-03-10 10:07
 */
@Component
@EnableConfigurationProperties(WebConfig.class)
@AllArgsConstructor
public class WebRestTemplate {
    private WebConfig webConfig;
    public static RestTemplate REST_TEMPLATE;

    static {
        RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(10000).setConnectTimeout(10000).setSocketTimeout(30000).build();
        HttpClientBuilder builder = HttpClientBuilder.create().setDefaultRequestConfig(config).setRetryHandler(new DefaultHttpRequestRetryHandler(3, false));
        HttpClient httpClient = builder.build();
        ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        REST_TEMPLATE = new RestTemplate(requestFactory);
    }

    //    public static final String XX_URL = "/equip/the-scrap";
    public static final String XX_URL = "/test/test";

    public Datas xx(String id, int page, int size) throws Exception {
        List<WebConfig.WebInfo> webInfos = webConfig.getHouses().stream()
                .filter(it -> id.equals(it.getId()))
                .collect(Collectors.toList());

        if (webInfos.isEmpty()) {
            throw new Exception("找不到指定的库房信息");
        }
        WebConfig.WebInfo info = webInfos.get(0);

        //设置访问参数
        HashMap<String, Object> params = new HashMap<>();
        params.put("page", page);
        params.put("size", size);

        // sign = md5 (appId + secret + currentTime)
        long ts = System.currentTimeMillis();
        String sign = info.getAppId() + info.getSecret() + ts;

        //设置Http的Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("appId", info.getAppId());
        headers.add("sign", DigestUtils.md5DigestAsHex(sign.getBytes()));
        headers.add("ts", String.valueOf(ts));

        HttpEntity entity = new HttpEntity(params, headers);
        final String url = info.getAddress() + XX_URL;

        ResponseEntity<Datas> exchange;
        try {
            exchange = REST_TEMPLATE.exchange(url, HttpMethod.GET, entity, Datas.class);
        } catch (RuntimeException e) {
            throw new Exception(String.format("无法连接到[%s]的服务器", info.getName()));
        }
        return exchange.getBody();
    }

    @Data
    public static class Datas {
        private String a;
        private String b;
    }
}
