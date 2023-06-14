package com.lc.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.lc.springcloud.domain.CommResult;
import com.lc.springcloud.domain.Payment;
import com.lc.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author Lc
 * @Date 2023/6/14
 * @Description
 */
@RestController
public class SentinelController {
     public static final String SERVICE_URL = "http://nacos-payment-provider";

     @Resource
     private RestTemplate restTemplate;

     @Resource
     private PaymentService paymentService;

     @RequestMapping("/consumer/fallback/{id}")
     @SentinelResource(value = "fallback",fallback = "RuntimeError",
     blockHandler = "SentinelError")
     public CommResult<Payment> fallback(@PathVariable("id")Long id){
         CommResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommResult.class, id);
         if(id == 4){
             throw  new IllegalArgumentException("IllegalArgumentException ERROR");
         }else if(result.getData() == null){
             throw new NullPointerException("NullPointerException ERROR");
         }
         return  result;
     }

     public CommResult<Payment> RuntimeError(@PathVariable Long id,Throwable throwable){
         Payment aNull = new Payment(id, "null");
         return new CommResult<>(444,"兜底异常内容："+throwable.getMessage(),aNull);
     }

     public String SentinelError(@PathVariable Long id){
         return "SentinelError";
     }

     //=====> OpenFeign
    @GetMapping("/test/openfeign/{id}")
    public CommResult<Payment> test(@PathVariable Long id){
         return paymentService.paymentSql(id);
    }
}
