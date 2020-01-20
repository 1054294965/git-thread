package com.example.accessingdatamysql.entity;

import java.util.concurrent.BlockingQueue;

public class StickThread implements Runnable{

    private BlockingQueue<Integer> blockingQueue;
    private static int element = 0;

    public StickThread(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while(element < 50) {
            System.out.println("将要放进去的元素是："+element);
            try {
                Thread.sleep(1000);
                blockingQueue.put(element++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
