package com.example.accessingdatamysql.entity;

import lombok.Data;

import java.util.function.Consumer;
@Data
public class Person {
    private String name;

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("zhangsan");
        Consumer<Person> consumer=(s)->{
            s.setName("lisi");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(s.getName());
        };

        Consumer<Person> consumer2=(s)-> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(s.getName());
        };

        //这说明consumer可以修改传入对象的内部值，以便于后续继续操作
        consumer.andThen(consumer2); // lisi lisi

    }
}


