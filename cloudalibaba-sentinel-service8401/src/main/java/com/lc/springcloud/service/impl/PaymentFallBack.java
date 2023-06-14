package com.lc.springcloud.service.impl;

import com.lc.springcloud.domain.CommResult;
import com.lc.springcloud.domain.Payment;
import com.lc.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @Author Lc
 * @Date 2023/6/14
 * @Description
 */
@Component
public class PaymentFallBack implements PaymentService {
    @Override
    public CommResult<Payment> paymentSql(Long id) {
        return new CommResult<Payment>(4444,"error",null);
    }
}
