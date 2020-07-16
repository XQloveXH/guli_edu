package com.zxq.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * @Author zxq
 * @Date 2020/6/15 13:00
 * @Version 1.0
 */

@SpringBootApplication
@ComponentScan(basePackages = "com.zxq")
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class,args);
    }
}
