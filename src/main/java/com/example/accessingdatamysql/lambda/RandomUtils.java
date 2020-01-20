package com.example.accessingdatamysql.lambda;

import java.util.Random;

public class RandomUtils {
    //范围内随机数，>=num1 ,<num2
    public static int createInt(int num1,int num2)
    {
        return num1+(int)(Math.random()*(num2-num1));
    }
    //范围内随机数， >=num1 ,<num2m ，*1000 线程中用
    public static int createMilliSecond(int num1,int num2)
    {

        return (num1+(int)(Math.random()*(num2-num1)))*1000;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
//            System.out.println(new Random().nextDouble());  // 0-1之间的随机double数
//            System.out.println(Math.random()); // 0-1之间的随机double数
            System.out.println(createInt(1,1));
        }
    }
}
