package com.lan.thread.threadSync;

/**
 * Created by Administrator on 2017/6/29.
 * 生产者
 */
public class Producer implements Runnable {

    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            storage.set();
        }
    }
}
