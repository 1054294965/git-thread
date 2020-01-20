package com.example.accessingdatamysql.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 不使用任何辅助的时候高并发会出现线程不安全的漏洞
 * 线程容器List 不是同步的
 * 同时 判断跟递减之间没有原子性
 * Created by 阿杜 on 2017/12/9.
 */
public class TicketSell1 {
    private static List<String> tickets = new ArrayList();

    static{
        for(int i=0; i<100; i++){
            tickets.add("这是第" + i + "张票");
        }
    }

    private static class BuySocket extends Thread{

        @Override
        public void run(){
            // 此处 线程不存在原子性 所以是不安全的
            while(tickets.size() > 0){
//                try {
//                    Thread.sleep( (1+(int)(Math.random()*(3-1)))*1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("销售了--->" + tickets.remove(0));
            }
        }
    }
    public static void main(String[] args) {
        for(int i=0; i<100; i++){
            new BuySocket().start();
        }
    }
}
