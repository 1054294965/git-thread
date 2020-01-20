package com.example.accessingdatamysql.entity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Father {
    public void chinese(){
        System.out.println("汉语");
    }

    public static void main(String[] args) {
        new Son().chinese();

        Father father=new Son();
    }

}
class Son extends Father{
    public void english(){
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();




    }
}
