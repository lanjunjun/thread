package com.lan.thread.threadManage;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/6/29.
 */
public class Task13 implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
