package com.lan.thread.threadSync;

/**
 * Created by Administrator on 2017/6/29.
 */
public class Main4 {

    public static void main(String[] args) {
        EventStorage storage = new EventStorage();
        Producer producer = new Producer(storage);
        Thread thread1 = new Thread(producer);
        Consumer consumer = new Consumer(storage);
        Thread thread2 = new Thread(consumer);
        thread2.start();
        thread1.start();
    }
}
