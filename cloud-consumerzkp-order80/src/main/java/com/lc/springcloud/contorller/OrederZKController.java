package com.lc.springcloud.contorller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author Lc
 * @Date 2023/5/28
 * @Description
 */
@RestController
@Slf4j
public class OrederZKController {
     public static final String INVOKE_URL = "http://cloud-provider-payment";

     @Resource
     private RestTemplate restTemplate;

     @GetMapping(value = "/consumer/payment/zk")
     public String paymenInfo(){
          String result = restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
          return result;
     }

}
