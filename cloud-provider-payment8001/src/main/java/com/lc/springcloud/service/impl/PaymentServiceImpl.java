package com.lc.springcloud.service.impl;

import com.lc.springcloud.dao.PaymentDao;
import com.lc.springcloud.domain.Payment;
import com.lc.springcloud.service.PaymentService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Lc
 * @Date 2023/5/22
 * @Description
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;


    @Override
    public int add(Payment payment) {
        return paymentDao.add(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
