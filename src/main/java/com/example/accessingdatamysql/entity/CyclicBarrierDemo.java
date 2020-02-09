package com.example.accessingdatamysql.entity;

import com.sun.javafx.binding.SelectBinding;

import java.nio.file.attribute.BasicFileAttributes;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *  够3个人才可以斗地主
 *  每到一个人，就执行await()，相当于qq斗地主的准备状态
 *  3个人都到后，主线程开始执行  表示开了一桌斗地主
 */
public class CyclicBarrierDemo implements Runnable{
    private CyclicBarrier barrier;
    public CyclicBarrierDemo(CyclicBarrier barrier){
        this.barrier = barrier;
    }
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+"从家里出发");
            Thread.sleep((1+(int)(Math.random()*(5-1)))*1000);
            System.out.println(Thread.currentThread().getName()+"到达棋牌室");
            barrier.await(); // 相当于qq斗地主里面的准备状态
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch ( BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        // 斗地主3人即可开局
        int N = 3;
        CyclicBarrier barrier = new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+":人够了，开战");
            }
        });

        // 叫人叫人
        System.out.println(Thread.currentThread().getName()+"大家来斗地主啊");
        for (int i=0;i<3;i++){
            new Thread(new CyclicBarrierDemo(barrier),"线程"+i).start();
        }
        // 等会人够了再开一桌(CyclicBarrier是可以复用的,到达计数后，会自动清零，或者手动reset也可以)
        Thread.sleep(6000);
        for (int i=3;i<6;i++){
            new Thread(new CyclicBarrierDemo(barrier),"线程"+i).start();
        }
    }
}
