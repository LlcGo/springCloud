package com.lc.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sun.javafx.geom.transform.Identity;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author Lc
 * @Date 2023/6/1
 * @Description
 */
@Service
public class PaymentService {
    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_Ok(Integer id){
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_Ok,id:" + id;
    }

    @HystrixCommand(fallbackMethod = "TimeOutError",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String TimeOut(Integer id){
//        int a = 10/0;
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_Ok,id:" + id + "失败耗时" + time + "秒";
    }

    public String TimeOutError(Integer id){
        return "8001服务端兜底方案:id=" + id;
    }



    //=====>   服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreak_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreak(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("*********id 不能是负数");
        }
//        String ID = UUID.randomUUID().toString();
        String ID = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功 流水好" + ID;
    }

    public String paymentCircuitBreak_fallback(@PathVariable("id")Integer id){
        return "id 不能为负数强稍后再试  id: " + id;
    }
}
