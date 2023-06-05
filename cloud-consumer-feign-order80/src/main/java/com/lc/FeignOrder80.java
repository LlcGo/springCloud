package com.lc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author Lc
 * @Date 2023/5/31
 * @Description
 */
@SpringBootApplication
@EnableFeignClients
public class FeignOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrder80.class,args);
    }
}
