package com.shimizu.hutool.abstracts;

import java.time.Duration;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 单号生成器
 *
 * @author Shimizu
 * @description
 * @date 2021-04-28 10:49
 */
public class NumberGenerateUtils {
    /**
     * 线程安全的存储容器
     */
    private static final Set<String> NUMBER_CONTAINER = Collections.synchronizedSet(new HashSet<>());

    /**
     * 最后一次生成单号的时间
     */
    private static long lastAddTime = 0L;

    /**
     * 清空缓存的时间
     */
    private static final long CLEAR_TIME = Duration.ofMinutes(10).toMillis();

    /**
     * 锁
     */
    private static Lock lock = new ReentrantLock();

    private NumberGenerateUtils() {

    }

    public static String generate() {
        clearAll();
        return generateNumber();
    }

    private static String generateNumber() {
        String number;
        lock.lock();
        try {
            long now = System.currentTimeMillis();
            number = randNumber(now);
            while (NUMBER_CONTAINER.contains(number)) {
                number = randNumber(now);
            }
            addNumber(number, now);
        } finally {
            lock.unlock();
        }
        return number;
    }

    private static void addNumber(String number, long lastAddTime) {
        NUMBER_CONTAINER.add(number);
        NumberGenerateUtils.lastAddTime = lastAddTime;
    }

    private static void clearAll() {
        if (NumberGenerateUtils.lastAddTime != 0L && NumberGenerateUtils.lastAddTime + CLEAR_TIME < System.currentTimeMillis()) {
            NUMBER_CONTAINER.clear();
            NumberGenerateUtils.lastAddTime = 0L;
        }
    }

    private static String randNumber(long currentTime) {
        int salt = (int) (Math.random() * 9999);
        return String.format("%04X", salt) + currentTime;
    }
}
