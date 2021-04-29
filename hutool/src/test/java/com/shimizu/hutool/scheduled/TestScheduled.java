package com.shimizu.hutool.scheduled;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.management.timer.Timer;

/**
 * @author Shimizu
 * @description
 * @date 2021-01-22 13:16
 */
@ExtendWith(SpringExtension.class)
@EnableScheduling
public class TestScheduled {

    private static final Logger log = LoggerFactory.getLogger(TestScheduled.class);

    @Test
    void test() {
        while (true) {

        }
    }

    @Scheduled(initialDelayString = "4000", fixedRate = Timer.ONE_SECOND * 4)
    public void Scheduled1() throws Exception {
        log.info(Thread.currentThread().getName() + "定时任务启动一启动失败");
        throw new Exception("启动任务失败");
    }

    @Scheduled(initialDelayString = "2000", fixedRateString = "2000")
    public void Scheduled2() {
        log.info(Thread.currentThread().getName() + "定时任务二启动成功~");
    }
}
