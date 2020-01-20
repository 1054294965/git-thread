package com.example.accessingdatamysql.entity;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TicketSell4 {
    private static Queue<String> tickets = new ConcurrentLinkedQueue();

    static {
        for(int i=0; i<10000; i++){
            tickets.add("这是第" + i + "张票");
        }
    }

    private static class BuyTicket extends Thread{

        @Override
        public void run(){
            while(true){
                String string = tickets.poll();
                if(string == null) break;
                System.out.println("买到了--->" + string);
            }
        }
    }

    public static void main(String[] args) {
        for(int i=0; i<10; i++){
            new BuyTicket().start();
        }
    }
}