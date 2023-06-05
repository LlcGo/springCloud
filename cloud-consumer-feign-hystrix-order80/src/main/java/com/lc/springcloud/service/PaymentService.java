package com.lc.springcloud.service;

import com.lc.springcloud.service.impl.PaymentServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value ="CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback= PaymentServiceImpl.class)
public interface PaymentService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_Ok(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/err/{id}")
    String TimeOut(@PathVariable("id") Integer id);
}
