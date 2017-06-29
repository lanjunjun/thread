package com.lan.thread.threadManage;

import java.util.Random;

/**
 * Created by Administrator on 2017/6/29.
 */
public class Task implements Runnable {

    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());
        while (true){
            result = 1000/(int)(random.nextDouble()*1000);
            System.out.printf("%s : %d\n",Thread.currentThread().getId(),result);
            if(Thread.currentThread().isInterrupted()){
                System.out.printf("%d : Interrupted\n",Thread.currentThread().getId());
                return;
            }
        }
    }
}
