package com.lan.thread.threadSync;

/**
 * Created by Administrator on 2017/6/30.
 */
public class Producer8 implements Runnable{

    private FileMock mock;
    private Buffer buffer;

    public Producer8(FileMock mock, Buffer buffer) {
        this.mock = mock;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.setPendingLines(true);
        while (mock.hasMoreLines()){
            String line = mock.getLine();
            buffer.insert(line);
        }
        buffer.setPendingLines(false);
    }
}
