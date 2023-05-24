package com.lc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author Lc
 * @Date 2023/5/22
 * @Description
 */

@SpringBootApplication
@EnableEurekaClient
public class MainPayMent8001 {
    public static void main(String[] args) {
        SpringApplication.run(MainPayMent8001.class,args);
    }
}
