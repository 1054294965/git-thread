package com.example.accessingdatamysql.entity;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 这里用春游的例子来举例
 * 例如3个人一起去春游，路上的时间不同，要都集合了才能去春游
 */
public class CountDownLatchDemo implements Runnable{
    private CountDownLatch latch;
    public CountDownLatchDemo(CountDownLatch latch){
        this.latch = latch;
    }
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+"已出发");
            Thread.sleep((1+(int)(Math.random()*(5-1)))*1000); // 路途中的时间 1到5秒
            latch.countDown();
            System.out.println(latch.getCount());
            System.out.println(Thread.currentThread().getName()+"已到达");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        System.out.println(Thread.currentThread().getName()+"起床啦，今天要春游");
        for (int i=0;i<3;i++){
            new Thread(new CountDownLatchDemo(latch),"同学"+i).start();
        }
        try {
            latch.await();
            System.out.println(Thread.currentThread().getName()+":大家都到达了，走起");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
