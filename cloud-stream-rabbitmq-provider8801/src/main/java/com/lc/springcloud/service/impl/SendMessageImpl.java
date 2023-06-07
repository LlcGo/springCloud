package com.lc.springcloud.service.impl;

import com.lc.springcloud.service.SendMessage;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author Lc
 * @Date 2023/6/7
 * @Description
 */
@EnableBinding(Source.class)  //source 发送方
public class SendMessageImpl implements SendMessage {

    //out channel
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String searial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(searial).build());
        System.out.println("******serial: " + searial);
        return null;
    }
}
