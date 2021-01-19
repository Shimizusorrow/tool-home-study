package com.shimizu.hutool.lock;

public class Count {
    Lock lock = new Lock();

    public void print() throws InterruptedException {
        lock.lock();
        doAdd();
        lock.unlock();
    }

    public void doAdd() throws InterruptedException {
        lock.lock();
        //do something
        lock.unlock();
    }
}