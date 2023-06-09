package com.lc.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author Lc
 * @Date 2023/6/15
 * @Description
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源的自动创建
@EnableFeignClients
@EnableDiscoveryClient
public class StorageServiceMain2002 {
    public static void main(String[] args) {
        SpringApplication.run(StorageServiceMain2002.class,args);
    }
}
