package com.lan.thread.threadManage;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/6/21.
 */
public class Main5 {

    public static void main(String[] args) {
        FileSerarch serarch = new FileSerarch("C:\\","autoexec.bat");
        Thread thread = new Thread(serarch);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
