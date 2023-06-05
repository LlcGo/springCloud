package com.lc.controller;

import com.lc.service.PaymentService;
import com.lc.springcloud.domain.CommResult;
import com.lc.springcloud.domain.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Lc
 * @Date 2023/5/31
 * @Description
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    CommResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/consumer/produce/timeout")
    public String timeOut() {
        return paymentService.timeOut();
    }
}
