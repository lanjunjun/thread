package com.lan.thread.threadSync;

/**
 * Created by Administrator on 2017/6/29.
 * 使用非依赖属性实现同步
 * 用synchronized关键字保护代码块时，我们使用对象作为它的传入值。
 * JVM保证同一时间只有一个线程能够访问这个对象的代码块。
 */
public class Cinema {

    private long vacanciesCinema1;
    private long vacanciesCinema2;

    private final Object controlCinema1,controlCinema2;

    public Cinema() {
        this.controlCinema1 = new Object();
        this.controlCinema2 = new Object();
        vacanciesCinema1 = 20;
        vacanciesCinema2 = 20;
    }

    public boolean sellTickets1(int number){
        synchronized (controlCinema1){
            if(number<vacanciesCinema1){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                vacanciesCinema1-=number;
                return true;
            }else{
                return false;
            }
        }
    }

    public boolean sellTickets2(int number){
        synchronized (controlCinema2){
            if(number<vacanciesCinema2){
                vacanciesCinema2-=number;
                return true;
            }else{
                return false;
            }
        }
    }

    public boolean returnTickets1(int number){
        synchronized (controlCinema1){
            vacanciesCinema1+=number;
            return true;
        }
    }

    public boolean returnTickets2(int number){
        synchronized (controlCinema2){
            vacanciesCinema2+=number;
            return true;
        }
    }

    public long getVacanciesCinema1() {
        return vacanciesCinema1;
    }

    public long getVacanciesCinema2() {
        return vacanciesCinema2;
    }
}
