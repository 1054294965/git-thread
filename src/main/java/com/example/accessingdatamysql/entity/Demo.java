package com.example.accessingdatamysql.entity;

import java.util.Objects;
import java.util.concurrent.*;

/**
 * throw e和e.printStackTrace的区别
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(1);
        String s = printName();
        System.out.println(s.length());
    }

    public static String printName(){
        try {
            System.out.println(0/0);
        }catch(Exception e){
            throw e;
        }
        return "success";
    }
}