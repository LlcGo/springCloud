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
public class consulproviderMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(consulproviderMain8006.class,args);
    }
}
