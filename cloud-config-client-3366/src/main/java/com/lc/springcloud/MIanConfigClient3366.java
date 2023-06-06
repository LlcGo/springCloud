package com.lc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author Lc
 * @Date 2023/6/6
 * @Description
 */
@EnableEurekaClient
@SpringBootApplication
public class MIanConfigClient3366 {
    public static void main(String[] args) {
        SpringApplication.run(MIanConfigClient3366.class,args);
    }
}
