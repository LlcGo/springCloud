package com.lc.springcloud.alibaba.controller;

import com.lc.springcloud.alibaba.service.AccountService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author Lc
 * @Date 2023/6/15
 * @Description
 */
@RestController
public class AccountController {
    @Resource
    private AccountService accountService;

    @RequestMapping("/account/decrease")
    public void decrease(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal money){
        accountService.decrease(userId,money);
    }

}
