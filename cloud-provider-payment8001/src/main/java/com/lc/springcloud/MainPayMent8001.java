package com.lc.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @Author Lc
 * @Date 2023/5/22
 * @Description
 */

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class MainPayMent8001 {
    public static void main(String[] args) {
        SpringApplication.run(MainPayMent8001.class,args);
    }

}
