package com.lc.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Lc
 * @Date 2023/6/5
 * @Description
 */

@RestController
@RefreshScope
public class ReadConfigController {
    @Value("${config.info}")
    private String configInfo;

    @Value("{server.port}")
    private String serverPort;

    @GetMapping("/configInfo")
    public String getConfigInfo()
    {
        return serverPort +"\t\t"+ configInfo;
    }
}
