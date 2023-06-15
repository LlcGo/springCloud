package com.lc.springcloud.alibaba.service.impl;

import com.lc.springcloud.alibaba.dao.OrderDao;
import com.lc.springcloud.alibaba.domain.Order;
import com.lc.springcloud.alibaba.service.AccountService;
import com.lc.springcloud.alibaba.service.OrderService;
import com.lc.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Lc
 * @Date 2023/6/15
 * @Description
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "6666",rollbackFor = Exception.class)
    public void createOrder(Order order) {

        log.info("创建订单......");
        orderDao.create(order);
        log.info("创建订单......完成");

        log.info("微服务订单开始调用库存 修改库存......");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("微服务订单开始调用库存 完成");

        log.info("微服务订单开始调用账户 修改用户金额......");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("微服务订单开始调用账户 完成");

        log.info("修改订单状态");
        orderDao.update(order.getUserId(),0);
        log.info("修改订单完成");

        log.info("下单结束");
    }
}
