package com.example.accessingdatamysql.entity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 预定旅店的例子
 * 一个旅店只有10个房间，有10起预定的请求，每个请求随机订2-5间
 */
public class SemaphoreHotel {

    private static Semaphore s = new Semaphore(10); // 旅店有10个房间
    static class HotelTask implements Runnable {

        @Override
        public void run() {
            int n = (2 + (int) (Math.random() * (5- 2))) ;  //2-5间
            try {
                Semaphore s = new Semaphore(10);
//                s.drainPermits(); // 清空所有可用，相当于来了个大boss，说我把剩下的房间全包了
                s.getQueueLength(); // 获取队列中线程数量
                s.acquire(n); // 预定n个房间，别人就不能预定了
                Thread.sleep(10);
                System.out.println(s.getQueueLength());  // 获取队列中线程数量
                System.out.println(Thread.currentThread().getName() + "占用房间数" + n+",可用房间数"+s.availablePermits());
                long l = (2 + (int) (Math.random() * (5 - 2))) * 1000;
                System.out.println(Thread.currentThread().getName() + "占用时长" + l);
                TimeUnit.MILLISECONDS.sleep(l); // 比Thread.sleep()更人性化吧

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release(n); // 释放3个房间
                System.out.println(Thread.currentThread().getName() + "释放房间数" + n+",可用房间数"+s.availablePermits());
            }
        }
    }
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            pool.execute(new HotelTask());
        }
        pool.shutdown();
    }
}
