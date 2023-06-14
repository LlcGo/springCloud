package com.lc.springcloud.service;

import com.lc.springcloud.domain.CommResult;
import com.lc.springcloud.domain.Payment;
import com.lc.springcloud.service.impl.PaymentFallBack;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallBack.class)
public interface PaymentService {
    @GetMapping(value = "/paymentSQL/{id}")
    CommResult<Payment> paymentSql(@PathVariable("id")Long id);
}
