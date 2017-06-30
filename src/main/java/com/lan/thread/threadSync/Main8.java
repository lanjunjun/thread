package com.lan.thread.threadSync;

/**
 * Created by Administrator on 2017/6/30.
 */
public class Main8 {

    public static void main(String[] args) {
        FileMock mock = new FileMock(100,10);
        Buffer buffer = new Buffer(20);
        Producer8 producer = new Producer8(mock,buffer);

        Thread threadProducer = new Thread(producer,"Producer");

        Consumer8 consumer8[] = new Consumer8[3];
        Thread threadConsumers[] = new Thread[3];

        for(int i=0;i<3;i++){
            consumer8[i] = new Consumer8(buffer);
        }
    }
}
