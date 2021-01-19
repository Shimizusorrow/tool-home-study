package com.shimizu.hutool.lock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Shimizu
 * @description
 * @date 2021-01-19 08:17
 */
@ExtendWith(SpringExtension.class)
public class LockTest {

    @Test
    void test() throws InterruptedException {
        Count count = new Count();
        count.print();
    }

    @Test
    void test1() {
        ReentrantLock reentrantLock = new ReentrantLock();
    }

    @Test
    void test3() {
        for (int i = 0; i < 1000; i++) {
            synchronized (String.valueOf(i).intern()) {
                System.out.println(i);
            }
        }
    }

    @Test
    void test4() {
        for (int i = 0; i < 1000; i++) {
            sync(String.valueOf(i));
        }
    }

    private synchronized void sync(String string) {
        System.out.println(string);
    }
}
