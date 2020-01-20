package com.example.accessingdatamysql.controller;

import com.alibaba.fastjson.JSON;
//import com.example.accessingdatamysql.Example;
import com.example.accessingdatamysql.entity.Foo;

import com.example.accessingdatamysql.web.CacheServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


@RestController
@RequestMapping("")
@Slf4j
public class LoginController {
    @Autowired
    private CacheServiceImpl cacheService;

    @Value("${com.mangogo.test1}")
    private Collection list;
    @RequestMapping("/login")
    public String login(){
        System.out.println(list);
            return "success";
    }
}
