package com.lc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author Lc
 * @Date 2023/6/5
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class WorkConfig3355 {
    public static void main(String[] args) {
        SpringApplication.run(WorkConfig3355.class,args);
    }
}
