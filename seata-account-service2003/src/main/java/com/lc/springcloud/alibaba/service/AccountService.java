package com.lc.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;


public interface AccountService {

    /**
     * 下单成功后扣减用户余额
     * @param userId 用户id
     * @param money 购买商品的价格
     */
    void decrease(Long userId, BigDecimal money);
}
