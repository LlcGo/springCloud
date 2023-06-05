package com.lc.service;

import com.lc.springcloud.domain.CommResult;
import com.lc.springcloud.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "CLOUD-PROVIDER-SERVICE") //寻找服务名
public interface PaymentService {
    //上面服务里的方法
    @GetMapping(value = "/payment/get/{id}")
    CommResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/produce/timeout")
    String timeOut();
}
