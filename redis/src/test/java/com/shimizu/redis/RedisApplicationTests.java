package com.shimizu.redis;


import com.shimizu.redis.config.RedisConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
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

    @Test
    void testTimeStamp() throws ParseException {
//        long l = System.currentTimeMillis()+1L;
//        System.out.println(Long.toHexString(l));

//        String value="201901";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
//
//        Long beginUseTime = sdf.parse(value).getTime();
//        System.out.println(beginUseTime);
        System.out.println((int)(Math.random()*10000));
        System.out.println((int)(Math.random()*10000));
        for (int i=0 ;i<10;i++){
            System.out.println(Math.random()*1000);
        }
        String rfid = getRfid();
        HashSet<String> set = new HashSet<>();
        while (set.contains(rfid)) {
            rfid = getRfid();
        }
        System.out.println(rfid);
    }
    private String getRfid() {
        return Long.toHexString(System.currentTimeMillis() + (long) (Math.random() * 10000) +
                (long) (Math.random() * 10000) +
                (long) (Math.random() * 10000) +
                +(long) (Math.random() * 10000));
    }


}
