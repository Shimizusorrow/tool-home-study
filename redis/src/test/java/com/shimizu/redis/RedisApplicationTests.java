package com.shimizu.redis;


import com.shimizu.redis.config.RedisConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;


import java.util.Objects;
import java.util.UnknownFormatConversionException;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataRedisTest
class RedisApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void notNull() {
        assertNotNull(redisTemplate);
    }

    String key;
    String value;

    @BeforeEach
    void markValue() {
        key = "1";
        value = "2";
    }

    @Test
    void testRedisSetValue() {
        redisTemplate.opsForValue().set(key, value);
    }

    @Test
    void testRedisgetValue() {
        System.out.println(redisTemplate.opsForValue().get(key));
    }

    @Test
    void testGetNull() {
        Object xxx = redisTemplate.opsForValue().get("xxx");
        if (Objects.isNull(xxx)) {
            System.out.println("xxx is null");
        }
        System.out.println(redisTemplate.opsForValue().get("xxx"));
    }


    @Test
    void contextLoads() {
        String s = String.format("%03d", 15);
        System.out.println(s);
    }

}
