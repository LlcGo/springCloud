package com.lc.springcloud.controller;

import com.lc.springcloud.service.SendMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Lc
 * @Date 2023/6/7
 * @Description
 */
@RestController
public class SendMessageController {
    @Resource
    private SendMessage sendMessage;

    @GetMapping("/sendMessage")
    public void sendMessage(){
        sendMessage.send();
    }
}
