package com.lc.springcloud.controller;

import com.lc.springcloud.domain.CommResult;
import com.lc.springcloud.domain.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author Lc
 * @Date 2023/5/24
 * @Description
 */
@RestController
@Slf4j
public class OrderController {
    private  static final String PAYMENT_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    //这里发送出去的是json数据
    @GetMapping("/consumer/payment/add")
    public CommResult<?> add(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/insert",payment,CommResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommResult<?> get(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/" + id,CommResult.class);
    }
}
