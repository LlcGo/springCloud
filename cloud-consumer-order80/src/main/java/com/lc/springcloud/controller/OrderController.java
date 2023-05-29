package com.lc.springcloud.controller;

import com.lc.springcloud.domain.CommResult;
import com.lc.springcloud.domain.Payment;
import com.lc.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Author Lc
 * @Date 2023/5/24
 * @Description
 */
@RestController
@Slf4j
public class OrderController {
//    private  static final String PAYMENT_URL = "http://localhost:8001";
    private  static final String PAYMENT_URL = "http://CLOUD-PROVIDER-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    //这里发送出去的是json数据
    @GetMapping("/consumer/payment/add")
    public CommResult<?> add(Payment payment){
//        return restTemplate.postForObject(PAYMENT_URL+"/payment/insert",payment,CommResult.class);
        return restTemplate.postForEntity(PAYMENT_URL+"/payment/insert",payment,CommResult.class).getBody();
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommResult<?> get(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/" + id,CommResult.class);
    }

    @GetMapping("/consumer/payment/lb")
    public String getServer(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        if(instances == null || instances.size() <= 0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        log.info("uri={}",uri);
        return restTemplate.getForObject(uri +"/consumer/lb",String.class);
    }



}
