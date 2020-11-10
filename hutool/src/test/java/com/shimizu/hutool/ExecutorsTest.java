package com.shimizu.hutool;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ExtendWith(SpringExtension.class)
public class ExecutorsTest {
    /**
     * 测试线程池
     */
    @Test
    void test() {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                try {
                    Thread.sleep(new Random().nextInt(5000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " done.");
            });
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            // pass
        }
        System.out.println("all tasks have been done in " + (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * 测试静态变量 静态方法获取线程
     */
    private final static ExecutorService es = Executors.newFixedThreadPool(8);

    @Test
    void testStatistic() {
        long time = System.currentTimeMillis();
//39556
        StaticTask staticTask = new StaticTask();
        for (int i = 0; i < 20000000; i++) {
            staticTask.id = i + "";
            es.submit(staticTask);
        }
        // 关闭线程池:
        es.shutdown();
        while (!es.isTerminated()) {

        }
        System.out.println(String.format("耗时: %d 毫秒", (System.currentTimeMillis() - time) ));
    }

    @Test
    void testNormal() {
//        43529 36659
        long time = System.currentTimeMillis();
        for (int i = 0; i < 20000000; i++) {
            es.submit(new NormalTask(i + ""));
        }
        // 关闭线程池:
        es.shutdown();
        while (!es.isTerminated()) {

        }
        System.out.println(String.format("耗时: %d 豪秒", (System.currentTimeMillis() - time) ));
    }

    private final static Set<String> SET = new HashSet<>();

    @Data
    private static class StaticTask implements Runnable {
        private String id;

        @Override
        public void run() {
//            System.out.println(id);
//            System.out.println(generateNoRepeatString());
        }
    }

    @Data
    private class NormalTask implements Runnable {

        private String id;

        public NormalTask(String id) {
            this.id = id;
        }

        @Override
        public void run() {
//            System.out.println(id);
        }
    }

    private static String generateNoRepeatString() {
        String temp = getString();
        while (SET.contains(temp)) {
            temp = getString();
        }
        SET.add(temp);
        return temp;
    }

    private static String getString() {
        return String.format("%06x", (int) (Math.random() * 999999));
    }
}
