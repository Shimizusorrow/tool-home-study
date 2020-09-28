package com.shimizu.redis;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created Date : 2020/09/28
 *
 * @author zzk
 */
@ExtendWith(SpringExtension.class)
@DataRedisTest
public class StringRedisTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private ValueOperations<String, String> valueOperations;

    @BeforeEach
    void setUp() {
        valueOperations = redisTemplate.opsForValue();
        valueOperations.setIfAbsent("age", 0 + "");
    }

    @AfterEach
    void afterUp() {
        redisTemplate.delete("age");
    }


    @Test
    void nutNull() {
        assertThat(redisTemplate);
    }

    @Test
    void incrValue() {
        valueOperations.increment("age");
        String age = valueOperations.get("age");
        assertThat(age).isEqualTo("1");
    }

}
