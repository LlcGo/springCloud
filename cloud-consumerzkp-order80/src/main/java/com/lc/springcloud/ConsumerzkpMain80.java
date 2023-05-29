package com.lc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Lc
 * @Date 2023/5/28
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerzkpMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerzkpMain80.class,args);
    }
}
