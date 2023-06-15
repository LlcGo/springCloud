package com.lc.springcloud.alibaba.controller;

import com.lc.springcloud.alibaba.domain.CommonResult;
import com.lc.springcloud.alibaba.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Lc
 * @Date 2023/6/15
 * @Description
 */
@RestController
public class StroageController {

    @Resource
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    public CommonResult decrease(@RequestParam("productId")Long productId, @RequestParam("count")Integer count){
        storageService.update(productId,count);
        return new CommonResult(200,"ok");
    }
}
