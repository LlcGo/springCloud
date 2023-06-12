package com.lc.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lc.springcloud.domain.CommResult;
import com.lc.springcloud.domain.Payment;
import com.lc.springcloud.myhandler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


/**
 * @Author Lc
 * @Date 2023/6/11
 * @Description
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() throws InterruptedException {
        log.info("处理请求");
        return  "-------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return  "-------testB";
    }

    @GetMapping("/testD")
    public String testD(){
        //暂停几秒钟线程
//        try {
//            TimeUnit.SECONDS.sleep(1);

//            log.info("testD 测试RT");
            log.info("testD 测试异常比例");
            int age = 10/0;
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "--------testD";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false)String p1,
                             @RequestParam(value = "p2",required = false)String p2){
        return "----testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException e){
        return "----deal_testHotKey,降级";
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handleException2")
    public CommResult customerBlockHandler(){
        return new CommResult(200,"按客户自定义",new Payment(2020L,"serial003"));
    }
}

