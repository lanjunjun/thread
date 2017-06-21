package com.lan.thread.threadManage;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/6/21.
 * 等待线程的终止
 * Thread类的join方法。当一个线程对象的join()方法被调用时。调用它的线程将被挂起
 * 直到这个线程对象完成它的任务
 */
public class DataSourcesLoader implements Runnable {

    @Override
    public void run() {
        System.out.printf("Beginning data sources loading: %s\n",new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Data sources loading has finished: %s\n",new Date());
    }
}
