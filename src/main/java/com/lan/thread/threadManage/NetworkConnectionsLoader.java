package com.lan.thread.threadManage;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/6/21.
 */
public class NetworkConnectionsLoader implements Runnable {


    @Override
    public void run() {
        System.out.printf("Beginning network loading: %s\n",new Date());
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("network loading has finished: %s\n",new Date());
    }
}
