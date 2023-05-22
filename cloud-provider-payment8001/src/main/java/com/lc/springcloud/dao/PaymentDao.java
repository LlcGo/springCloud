package com.lc.springcloud.dao;

import com.lc.springcloud.domain.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    int add(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
