package com.example.accessingdatamysql.entity;

import lombok.extern.slf4j.Slf4j;

import java.io.PrintStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Slf4j
public class Father {
    public static void main(String[] args) {
        System.out.println(dd());

    }
    public static String print(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "33";
    }
    public static String dd(){
        System.out.println("start");

        log.info(print());
        System.out.println("end");
        return "success";
    }


}

