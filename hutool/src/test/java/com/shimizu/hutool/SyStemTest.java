package com.shimizu.hutool;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class SyStemTest {
    @Test
    void testGet() {
        System.getProperties().forEach((key, v) -> {
            System.out.println(String.format("key:[%s] -> v:[%s]", key, v));
        });
    }

    @Test
    void test(){
        String format = String.format("%04x", 65535);
        System.out.println(format);
    }
}
