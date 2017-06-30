package com.lan.thread.threadSync;

import java.util.Random;

/**
 * Created by Administrator on 2017/6/30.
 */
public class Consumer8 implements Runnable {
    private Buffer buffer;

    public Consumer8(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (buffer.hasPendingLines()){
            String line = buffer.get();
            processLine(line);
        }
    }

    private void processLine(String line) {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
