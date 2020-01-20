package com.example.accessingdatamysql.entity;

import javax.sound.midi.Soundbank;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConsumerThread<psvm> implements  Runnable {
    private BlockingQueue<Integer> blockingQueue;
    private static int element = 0;

    public ConsumerThread(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                System.out.println(Thread.activeCount());
                System.out.println("取出来的元素是："+blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(3,true);
        StickThread stick = new StickThread(blockingQueue);
        ConsumerThread consumer = new ConsumerThread<Integer>(blockingQueue);

//        ProducerOffer producerOffer = new ProducerOffer(blockingQueue);

        new Thread(stick).start();

        new Thread(consumer).start();

    }
}
