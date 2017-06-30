package com.lan.thread.threadSync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/6/29.
 *
 */
public class PrintQueue {

    private final Lock queueLock = new ReentrantLock();

    /**
     * 使用锁创建一个临界区，并且保证同一时间只有一个执行线程访问这个临界区时
     * 必须创建ReentrantLock对象。在这个临界区的开始，必须通过lock()方法获取对锁的控制。
     * 当线程A访问这个方法时，如果没有其他线程获取对这个锁的控制。lock()方法将让线程A获得锁
     * 并且允许它立刻执行临界区代码。否则，如果其他线程B正在执行这个锁的保护的临界区代码，lock()方法
     * 将让线程A休眠直到线程B执行完临界区的代码
     * @param document
     */
    public void printJob(Object document){
        queueLock.lock();
        try {
            Long duration = (long)(Math.random()*10000);
            System.out.println(Thread.currentThread().getName()+":PrintQueue: Printing a Job during "+(duration/1000)+" seconds");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            queueLock.unlock();
        }

    }
}
