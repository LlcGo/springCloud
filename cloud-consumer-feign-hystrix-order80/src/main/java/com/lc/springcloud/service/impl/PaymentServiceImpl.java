package com.lc.springcloud.service.impl;

import com.lc.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @Author Lc
 * @Date 2023/6/2
 * @Description
 */
@Component
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfo_Ok(Integer id) {
        return "PaymentServiceImpl-paymentInfo_Ok-----8001好像宕机了";
    }

    @Override
    public String TimeOut(Integer id) {
        return "PaymentServiceImpl-TimeOut-----8001好像宕机了";
    }
}
