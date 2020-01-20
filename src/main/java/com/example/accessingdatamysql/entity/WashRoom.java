package com.example.accessingdatamysql.entity;

import com.example.accessingdatamysql.lambda.RandomUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
public class WashRoom implements Runnable {
    private int n; // 用来记录第几个人
    @Override
    public void run() {
        try {
            log.info(n+" 开始");
            int milliSecond = RandomUtils.createMilliSecond(1, 4); // 这里只要是随机秒数就行
            Thread.sleep(milliSecond);
            log.info(n +"结束，用时： "+milliSecond);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WashRoom(int n){
        this.n=n;
    }

    public static void main(String[] args) {



    }
}
