package com.lc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author Lc
 * @Date 2023/6/5
 * @Description
 */
@SpringBootApplication
@EnableConfigServer
public class MainConfig334 {
    public static void main(String[] args) {
        SpringApplication.run(MainConfig334.class,args);
    }
}
