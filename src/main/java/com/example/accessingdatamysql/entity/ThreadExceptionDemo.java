package com.example.accessingdatamysql.entity;

public class ThreadExceptionDemo implements Runnable{
    @Override
    public void run() {
        System.out.println(0/0);
    }


    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadExceptionDemo());
        //自定义未捕获异常处理器
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("线程异常了！");
            }
        });
        thread.start();
    }
}
