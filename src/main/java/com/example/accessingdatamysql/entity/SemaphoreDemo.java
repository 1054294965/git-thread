package com.example.accessingdatamysql.entity;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 模拟停车厂停车，用完释放，其他车才能使用
 */
public class SemaphoreDemo {

    private static Semaphore s = new Semaphore(2); // 2个停车位

    static class ParkTask implements Runnable {

        @Override
        public void run() {

            try {
                s.acquire(); // 占用停车位
                long l =(2+(int)(Math.random()*(5-2)))*1000;
                System.out.println(Thread.currentThread().getName() + "停车用时"+ l );
                TimeUnit.MILLISECONDS.sleep(l); // 比Thread.sleep()更人性化吧
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release(); // 释放停车位
            }
        }

        public static void main(String[] args) {
            System.out.println("最多只有2个车位，停车开始...");
            ExecutorService pool = Executors.newCachedThreadPool();


            pool.submit(new ParkTask());
            pool.submit(new ParkTask());
            pool.submit(new ParkTask());
            pool.submit(new ParkTask());
            pool.submit(new ParkTask());
            pool.submit(new ParkTask());
            pool.shutdown();
        }
    }
}

