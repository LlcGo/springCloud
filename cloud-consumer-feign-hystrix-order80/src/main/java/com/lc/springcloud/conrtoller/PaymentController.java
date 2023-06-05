package com.lc.springcloud.conrtoller;


import com.lc.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
@DefaultProperties(defaultFallback = "TimeOutError")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_Ok(id);
    }

    @GetMapping("/consumer/payment/hystrix/err/{id}")
    @HystrixCommand
//            (fallbackMethod = "TimeOutError",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    public String TimeOut(@PathVariable("id") Integer id){
        return paymentService.TimeOut(id);
    }

    public String TimeOutError(){
        return "80客户端的服务降级";
    }



}
