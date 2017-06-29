package com.lan.thread.threadSync;

/**
 * Created by Administrator on 2017/6/29.
 * 消费者
 */
public class Consumer implements Runnable{

    private EventStorage storage;

    public Consumer(EventStorage eventStorage) {
        this.storage = eventStorage;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            storage.get();
        }
    }
}
