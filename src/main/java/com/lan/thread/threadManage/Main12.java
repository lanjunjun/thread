package com.lan.thread.threadManage;

/**
 * Created by Administrator on 2017/6/29.
 * 线程组中不可控异常的处理
 */
public class Main12 {

    public static void main(String[] args) {
        MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");
        Task task = new Task();
        for(int i=0;i<2;i++){
            Thread t = new Thread(threadGroup,task);
            t.start();
        }
    }
}
