package com.example.accessingdatamysql.lambda;

public class MathRandom {

    public static int createRandomInt(int num1,int num2)
    {
        int n=num1+(int)(Math.random()*(num2-num1));
        return n;
    }

    public static char getRandomChar(char ch1,char ch2)
    {
        char ch=(char) (ch1+ Math.random()*(ch2-ch1+1));
        return ch;
    }

    public static void main(String args[])
    {
        System.out.println(MathRandom.createRandomInt(1,7)); //产生的随机数包括1，不包括7
        System.out.println(MathRandom.getRandomChar('a','b'));//a和b都包括
    }
}
