package com.shimizu.hutool;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

/**
 * @author Shimizu
 * @description
 * @date 2021-01-11 10:59
 */
@ExtendWith(SpringExtension.class)
public class RestTemplateTest {

    private static RestTemplate restTemplate;

    @BeforeAll
    static void init() {
        restTemplate = new RestTemplate();
    }

    @Test
    void notNull() {
        Assertions.assertNotNull(restTemplate);
    }

    @Test
    void testUse() {
        String url = "http://192.168.1.39:8016/warehouse";
        String api = "/upload-plat/equip-arg";
        url = url + api;
//        ResponseEntity<JSONObject> forEntity = restTemplate.getForEntity(url, JSONObject.class);
//        String s = forEntity.getBody().toString();
//        System.out.println(s);
//        JSONObject content = JSONObject.parseObject(s);
//        JSONArray jsonArray = content.getJSONArray("content");
//        for (int i = 0; i < jsonArray.size(); i++) {
//            JSONObject jsonObject = jsonArray.getJSONObject(i);
//            System.out.println(jsonObject.get("name"));
//        }
         restTemplate.getForObject(url, JSONArray.class);

//        content.getJSONArray()
//        for (int i=0;i<content.)
    }
    class Data{
        private String name;
    }
}
