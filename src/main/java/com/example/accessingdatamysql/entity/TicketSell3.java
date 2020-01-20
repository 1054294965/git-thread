package com.example.accessingdatamysql.entity;

import java.util.LinkedList;
import java.util.List;

public class TicketSell3 {
    private static List<String> tickets = new LinkedList();

    static {
        for(int i=0; i<10000; i++){
            tickets.add("这是第" + i + "张票");
        }
    }

    private static class BuyTicket extends Thread{

        @Override
        public void run(){
            while(true){

                synchronized(tickets){

                    if(tickets.size() <= 0) break;

/*                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/

                    System.out.println("买到了--->" + tickets.remove(0));
                }
            }
        }
    }

    public static void main(String[] args) {
        for(int i=0; i<10; i++){
            new BuyTicket().start();
        }
    }
}