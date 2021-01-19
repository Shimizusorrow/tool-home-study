package com.shimizu.hutool;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.management.timer.Timer;


@ExtendWith(SpringExtension.class)
public class ForCycleTest {
    /**
     * for循环 每隔几秒执行
     */
    @Test
    void forTest() throws Exception {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<1000;i++){
            sb.append(i+",");
        }
        System.out.println(sb.toString());
    }
}
