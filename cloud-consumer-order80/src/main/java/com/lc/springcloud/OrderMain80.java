package com.lc.springcloud;

import com.lc.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author Lc
 * @Date 2023/5/24
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
//更改使用自定义的负载均衡     注意这个类要写在springboot所扫描不到的地方
//@RibbonClient(name = "CLOUD-PROVIDER-SERVICE",configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
