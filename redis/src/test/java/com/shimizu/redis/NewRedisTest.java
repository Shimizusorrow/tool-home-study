package com.shimizu.redis;

import com.shimizu.redis.config.JsonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Shimizu
 * @description
 * @date 2021-03-22 10:16
 */
@ExtendWith(SpringExtension.class)
@DataRedisTest
public class NewRedisTest {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private final String EQUIP_KEY = "equip_key";

    @Test
    void notNull() {
        Assertions.assertNotNull(redisTemplate);
    }

    @Test
    void get() {
        Object o = redisTemplate.opsForHash().get(EQUIP_KEY, "33030029301011001e320000");
        System.out.println((String) o);
    }

    @Test
    void test() {
        List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3"));
        System.out.println(list.stream().map(it -> null).collect(Collectors.toList()).size());
    }

    @Test
    void test2() {
        System.out.println(JsonUtils.writeValueAsString(null));
    }

    @Test
    void test3() {
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("1", "2", "3"));
        Map<String, Object> collect = strings.stream().collect(Collectors.toMap(
                it -> it,
                it -> ""
        ));
        collect.forEach((k, v) -> {
            System.out.println("key:" + k + "value:" + v);
        });
    }
}
