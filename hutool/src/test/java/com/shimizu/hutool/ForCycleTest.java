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

        for (int i=0;i<10;i++){
            System.out.println(i);
            Thread.sleep(Timer.ONE_SECOND*3);
        }
        System.out.println("done------");
    }
}
