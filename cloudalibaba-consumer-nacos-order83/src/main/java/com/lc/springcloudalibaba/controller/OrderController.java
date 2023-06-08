package com.lc.springcloudalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author Lc
 * @Date 2023/6/8
 * @Description
 */
@RestController
public class OrderController {

    @Value("${service-url.nacos-user-service}")
    private  String PAYMENT_URL;


    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/nacos/{id}")
    public String getPayMent(@PathVariable("id")Integer id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/nacos/"+id,String.class);
    }
}
