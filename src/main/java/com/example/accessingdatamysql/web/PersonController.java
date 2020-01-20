package com.example.accessingdatamysql.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;

@Controller
public class PersonController {
    @Autowired
    private EntityManager entityManager;

    @ResponseBody
    @RequestMapping("/test")
    @Transactional
    public String t1() {

//        Person reference = entityManager.getReference(Person.class, 1L);
//        System.out.println(reference);
//        entityManager.flush();
        return "success";
    }
}