package com.lc.springcloud.controller;

import com.lc.springcloud.domain.CommResult;
import com.lc.springcloud.domain.Payment;
import com.lc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author Lc
 * @Date 2023/5/22
 * @Description
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/insert")
    public CommResult<?> insert(@RequestBody Payment payment){
        int result = paymentService.add(payment);
        long id = payment.getId();
        log.info("插入的结果是{},id是{}",result,id);
        if(result < 0){
            return new CommResult<>(4444,"插入数据失败",null);
        }
        return new CommResult<>(200,"插入数据成功 + serverPort:" + serverPort,result);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询的结果是{}",payment);
        if(payment == null){
            return new CommResult<>(4444,"没有关于它的记录,查询id:"+ id,null);
        }
        return new CommResult<>(200,"查询成功 + serverPort:" + serverPort,payment);
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        services.forEach(s -> {
            log.info("****elemt:"+ s);
        });
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        instances.forEach(s -> {
            log.info("主机名称"+ s.getHost() + "服务uri"
                    + s.getUri() + "主机端口" + s.getPort());
        });
        return this.discoveryClient;
    }

    @GetMapping("/consumer/lb")
    public String getServer(){
        return serverPort;
    }

    //模拟业务超时
    @GetMapping("/produce/timeout")
    public String timeOut() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
