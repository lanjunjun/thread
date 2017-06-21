package com.lan.thread.threadManage;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/6/21.
 * 线程的休眠和恢复
 */
public class FileClock implements Runnable {


    @Override
    public void run() {

        for(int i=0;i<10;i++){
            System.out.printf("%s\n",new Date());
            try {
                TimeUnit.SECONDS.sleep(1);  //如果休眠中线程被中断，该方法就会立即抛出InterruptedException异常，而不需要等待到线程休眠时间结束
            } catch (InterruptedException e) {  //当线程被中断时，释放或关闭线程正在使用的资源
                e.printStackTrace();
                System.out.printf("The FileClock has been interrupted");
            }
        }

    }


    public static void main(String[] args) {
        FileClock clock = new FileClock();
        Thread thread = new Thread(clock);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
