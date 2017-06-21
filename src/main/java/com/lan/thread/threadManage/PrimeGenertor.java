package com.lan.thread.threadManage;

/**
 * Created by Administrator on 2017/6/21.
 * 线程的中断
 * Thread 类的静态方法interrupted(),用来检查当前执行的线程是否被中断
 * isInterrupted()的interrupted方法有一个很大的区别，isInterrupted不能改变
 * interrupted属性的值，但是后者能设置interrupted属性为false.因为interrupted()
 * 是一个静态方法，更推荐使用isInterrupted（）方法
 *
 * 线程中断仅仅是置线程的中断状态位，不会停止线程。需要用户自己去监视线程的状态为并做处理。
 *
 */
public class PrimeGenertor extends Thread{

    @Override
    public void run() {
        long number = 1;
        while (true){
            if(isPrime(number)){
                System.out.printf("Number %d is Prime\n",number);
            }
            if(isInterrupted()){
                System.out.printf("The Prime Generator has benen Interrupted");
                return;
            }
            number++;
        }
    }

    /**
     * 如果接收到的参数是一个质数就返回true,否则返回false
     * @param number
     * @return
     */
    private boolean isPrime(long number) {
        if(number<=2){
            return true;
        }
        for(long i=2;i<number;i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
}
