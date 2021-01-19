package com.shimizu.hutool.lock;

/**
 * 不可重入锁
 *
 * @author Shimizu
 * @description
 * @date 2021-01-19 08:16
 */
public class Lock {
    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}
