package com.lc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author Lc
 * @Date 2023/6/1
 * @Description
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class FeignHystrix80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignHystrix80.class,args);
    }
}
