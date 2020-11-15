package com.shimizu.redis;

import com.alibaba.fastjson.JSON;
import com.shimizu.redis.config.Dcs;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.useRepresentation;

/**
 * Created Date : 2020/09/28
 *
 * @author zzk
 */
@ExtendWith(SpringExtension.class)
@DataRedisTest
public class MapRedisTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private ValueOperations<String, String> valueOperations;

    @BeforeEach
    void setUp() {
//        valueOperations = redisTemplate.opsForValue();
//        valueOperations.setIfAbsent("age", 0 + "");
    }

    @AfterEach
    void afterUp() {
//        redisTemplate.delete("age");
    }


    @Test
    void nutNull() {
        assertThat(redisTemplate);
    }

    @Test
    void incrValue() {
//        valueOperations.increment("age");
//        String age = valueOperations.get("age");
//        assertThat(age).isEqualTo("1");
    }

    private final String KEY = "user_key";

    @Test
    void map() {

//        ArrayList<Dcs> dcs = new ArrayList<>(Arrays.asList(
//                new Dcs("1", "张三", "男"),
//                new Dcs("2", "李四", "女")
//        ));
//        Map<String, Dcs> userMap = dcs.stream().collect(Collectors.toMap(Dcs::getId, it -> it));

//        redisTemplate.opsForValue().set(KEY, JSON.toJSONString(userMap));
//        redisTemplate.opsForValue().set(KEY, JSON.toJSONString(dcs));
//        redisTemplate.opsForHash().put(KEY, "1123", "123");
        Dcs dcs1 = new Dcs("1", "张三", "男");
        redisTemplate.opsForHash().put(KEY, dcs1.getId(), JSON.toJSONString(dcs1));


//        redisTemplate.opsForHash().get();
    }

    @Test
    void mapOut() {
//        String s = redisTemplate.opsForValue().get(KEY);
//        List dcs = JSON.parseObject(s, List.class);
//        List<Dcs> ss = (List<Dcs>) dcs.stream().map(it -> JSON.parseObject(JSON.toJSONString(it), Dcs.class)).collect(Collectors.toList());
//        ss.forEach(it -> System.out.println(it.toString()));
        Dcs dcs = JSON.parseObject((String) redisTemplate.opsForHash().get(KEY, "1"), Dcs.class);
//        Dcs dcs = (Dcs) redisTemplate.opsForHash().get(KEY, "1");
        System.out.println(dcs.toString());
    }


}
