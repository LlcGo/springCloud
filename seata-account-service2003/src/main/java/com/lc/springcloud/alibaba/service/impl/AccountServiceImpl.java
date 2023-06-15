package com.lc.springcloud.alibaba.service.impl;

import com.lc.springcloud.alibaba.dao.AccountDao;
import com.lc.springcloud.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @Author Lc
 * @Date 2023/6/15
 * @Description
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("account-service 中扣账户余额开始");
          accountDao.update(userId,money);
          log.info("account-service 中扣账户余额结束");
    }
}
