package com.lc.springcloud.controller;

import com.lc.springcloud.domain.CommResult;
import com.lc.springcloud.domain.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author Lc
 * @Date 2023/6/14
 * @Description
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L,new Payment(1L,"21321213215465"));
        hashMap.put(2L,new Payment(2L,"2222222215465"));
        hashMap.put(3L,new Payment(3L,"333333333215465"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommResult<Payment> paymentSql(@PathVariable("id")Long id){
        Payment payment = hashMap.get(id);
        return new CommResult<>(200,"from,mysql,serverPort: "+ serverPort,payment);
    }
}
