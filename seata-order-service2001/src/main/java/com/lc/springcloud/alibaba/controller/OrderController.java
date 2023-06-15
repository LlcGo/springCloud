package com.lc.springcloud.alibaba.controller;

import com.lc.springcloud.alibaba.domain.CommonResult;
import com.lc.springcloud.alibaba.domain.Order;
import com.lc.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Lc
 * @Date 2023/6/15
 * @Description
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.createOrder(order);
        return new CommonResult(200,"ok");
    }

}
