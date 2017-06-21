package com.lan.thread.threadManage;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/21.
 * 等待线程的终止
 */
public class Main7 {

    public static void main(String[] args) {
        DataSourcesLoader dataSourcesLoader = new DataSourcesLoader();
        Thread thread1 = new Thread(dataSourcesLoader,"DataSourceThread");
        NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
        Thread thread2 = new Thread(ncLoader,"NetworkConnectionLoader");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: Configuration has been loaded: %s\n",new Date());
    }
}
