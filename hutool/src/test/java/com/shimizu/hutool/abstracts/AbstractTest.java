package com.shimizu.hutool.abstracts;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.beans.Transient;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-28 10:06
 */
@ExtendWith(SpringExtension.class)
public class AbstractTest {
    @Test
    void test() {
        DefaultNumberGenerate.addString("1");
        DefaultNumberGenerate.print();
        RecordNumberGenerate.print();
    }

    @Test
    void testNumberGenerate() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(NumberGenerateUtils.generate());
        }
        Thread.sleep(Duration.ofSeconds(11).toMillis());
        System.out.println(NumberGenerateUtils.generate());
    }

    @Test
    void sout() {
        System.out.println(String.format("%04X", 4163));
        System.out.println(String.format("%04X", 4635));
    }

    private static ExecutorService executorService = Executors.newFixedThreadPool(20);

    @SneakyThrows
    @Test
    void test2() {
        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        int len = 100000;
        CountDownLatch countDownLatch = new CountDownLatch(len);
        for (int i = 0; i < len; i++) {
//            executorService.execute(() -> set.add(NumberGenerateUtils.generate()));
            executorService.submit(() -> {
                try {
                    set.add(NumberGenerateUtils.generate());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
//        Thread.sleep(Duration.ofSeconds(2).toMillis());
        try {
            countDownLatch.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(100000, set.size());
        long l = String.valueOf(System.currentTimeMillis()).length();
        set.forEach(it -> {
            assertEquals(l+4, it.length(),it);
        });
    }

}
