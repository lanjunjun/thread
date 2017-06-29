package com.lan.thread.threadManage;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * Created by Administrator on 2017/6/29.
 * 使用工厂类创建线程
 */
public class MyThreadFactory implements ThreadFactory{

    private int counter;

    private String name;

    private List<String> stats;

    public MyThreadFactory(String name) {
        this.counter = 0;
        this.name = name;
        this.stats = new ArrayList<>();
    }



    @Override
    public Thread newThread(Runnable r) {

        Thread t = new Thread(r,name+"-Thread_"+counter);
        counter++;
        stats.add(String.format("Created thread %d with name %s on %s\n",t.getId(),t.getName(),new Date()));
        return t;
    }

    public String getStats(){
        StringBuffer buffer = new StringBuffer();
        Iterator<String> it = stats.iterator();
        while (it.hasNext()) {
            buffer.append(it.next());
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
