package com.lc.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Lc
 * @Date 2023/5/24
 * @Description
 */
@Configuration
public class ApplicationContext{

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
