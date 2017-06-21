package com.lan.thread.threadManage;

/**
 * Created by Administrator on 2017/6/21.
 * 线程的中断
 */
public class Main4 {

    public static void main(String[] args) {

        Thread task = new PrimeGenertor();
        task.start();

        //线程执行5秒，中断PrimeGenerator线程
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        task.interrupt();
    }
}
