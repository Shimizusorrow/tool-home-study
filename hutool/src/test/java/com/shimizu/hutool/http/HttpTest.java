package com.shimizu.hutool.http;

import cn.hutool.http.HttpUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-29 08:27
 */
@ExtendWith(SpringExtension.class)
public class HttpTest {
    @Test
    void get() {
        String url="http://192.168.1.137:8010/warehouse/images/1505d6a84e97463a87599e3a9041a08d.jpg";
        String s = HttpUtil.get(url);
        System.out.println(s);
    }
}
