package com.lan.thread.threadSync;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Administrator on 2017/6/30.
 * 使用读写锁实现同步数据访问
 */
public class PricesInfo {

    private double price1;
    private double price2;

    private ReadWriteLock lock;

    public PricesInfo() {
        this.price1 = 1.0;
        this.price2 = 2.0;
        lock = new ReentrantReadWriteLock();
    }

    public double getPrice1() {
        lock.readLock().lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double value = price1;
        lock.readLock().unlock();
        return value;
    }

    public double getPrice2() {
        lock.readLock().lock();
        double value = price2;
        lock.readLock().unlock();
        return value;
    }

    public void setPrices(double price1,double price2) {
        lock.writeLock().lock();
        System.out.println("进入方法");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.price1 = price1;
        this.price2 = price2;
        System.out.println("结束方法");
        lock.writeLock().unlock();
    }


    public static void main(String[] args) {
        final PricesInfo pricesInfo = new PricesInfo();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                pricesInfo.setPrices(20,10);
                System.out.println(pricesInfo.getPrice1());
            }
        });
        thread.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                pricesInfo.setPrices(40,30);
                System.out.println(pricesInfo.getPrice1());
            }
        });
        thread2.start();
    }

}
