package com.lan.thread.threadManage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/6/21.
 * 线程信息的获取和设置
 */
public class Main3 {

    public static void main(String[] args) {

        //创建一个容量为10的线程数组，以用来存储线程
        Thread threads[] = new Thread[10];
        //创建一个容量为10的Thread.State数组，以用来存放这10个线程运行时的状态
        Thread.State status[] = new Thread.State[10];

        //创建一个容量为10的Calculator对象数组，为每个对象都设置不同的名字，然后使用它们作为
        //Thread的构造器参数来创建10个线程对象。并且将其中5个线程的优先级设置为最高，另外5个
        //线程优先级设置为最低
        for(int i=0;i<10;i++){
            threads[i] = new Thread(new Calculator(i));
            if((i%2)==0){
                threads[i].setPriority(Thread.MAX_PRIORITY);
            }else{
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread "+i);
        }

        //创建一个PrintWriter对象，用来把线程的状态演变写入到文件中
        try (FileWriter file = new FileWriter(".\\log.txt"); PrintWriter pw = new PrintWriter(file);){
            for(int i=0;i<10;i++){
                pw.println("Main : Status of Thread "+i+" : "+threads[i].getState());
                status[i] = threads[i].getState();
            }
            for(int i=0;i<10;i++){
                threads[i].start();
            }
            boolean finish = false;
            while (!finish){
                for(int i=0;i<10;i++){
                    if(threads[i].getState()!=status[i]){
                        writeThreadInfo(pw,threads[i],status[i]);
                        status[i] = threads[i].getState();
                    }
                }
                finish = true;
                for(int i=0;i<10;i++){
                    finish = finish && (threads[i].getState()== Thread.State.TERMINATED);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State status) {
        pw.printf("Main : Id %d - %s\n",thread.getId(),thread.getName());
        pw.printf("Main : Priority: %d\n",thread.getPriority());
        pw.printf("Main : Old State: %s\n",status);
        pw.printf("Main : New State: %s\n",thread.getState());
        pw.printf("Main : ************************************\n");
    }
}
