package com.lc.springcloud.controller;

import com.lc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Lc
 * @Date 2023/6/1
 * @Description
 */
@RestController
@Slf4j
public class PayMentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_Ok(id);
    }

    @GetMapping("/payment/hystrix/err/{id}")
    public String TimeOut(@PathVariable("id") Integer id){
        return paymentService.TimeOut(id);
    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreak(id);
        log.info("*****result:" + result);
        return result;
    }
}
