package com.example.accessingdatamysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.Instant;

@EnableRedisHttpSession
@SpringBootApplication
@EnableScheduling
public class AccessingDataMysqlApplication {
    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(AccessingDataMysqlApplication.class, args);

    }
    @Scheduled(cron = "0/2 * * * * ?")
    public void schedule1(){
        try {
            System.out.println(Thread.currentThread().getName()+", 1 "+Instant.now());
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName()+" 1 end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}