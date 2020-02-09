package com.example.accessingdatamysql.entity;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * 3个线程去做任务，每个线程10条，每条可能成功也可能失败
 * 最后总计计成功多少条
 */
public class CallableDemo implements Callable<Integer> {

    @Override
    public Integer call() {
        System.out.println(Thread.currentThread().getName()+"开始做任务");
        int s=0; // s 统计成功的数量
        for (int i = 0; i < 10; i++) {
            int n=0+(int)(Math.random()*(2-0)); //随机生成0或1  1表示成功  0表示失败
//            System.out.println(Thread.currentThread().getName()+"生成数字"+n); // 如果要追踪生成了多少个0或1 取消注释即可
            s+=n;
        }
        // 模拟线程等待  1到4秒
        try {
            int ms=(1+(int)(Math.random()*(5-1)))*1000;
            Thread.sleep(ms);
            System.out.println(Thread.currentThread().getName()+"用时"+ms+",完成条数"+s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"大家开始做任务吧");
        ExecutorService pool = Executors.newFixedThreadPool(3);
        ArrayList<Future<Integer>> list = new ArrayList<>(); // 用来装线程的future
        int sum=0;
        // 3个线程
        for (int i = 0; i < 3; i++) {
            Future<Integer> submit = pool.submit(new CallableDemo());
            list.add(submit);
        }
        //等到都做完任务后，一起统计
        for (Future<Integer> future: list) {
            try {
                Integer integer = future.get(); // 注: future.get()不是异步的，只有等所有线程都执行完毕，future.get()才能获取到结果
                sum+=integer;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"总计完成"+sum);
        pool.shutdown();
    }
}
