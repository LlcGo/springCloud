package com.lc.springcloud.alibaba.service;

import org.springframework.web.bind.annotation.RequestParam;

public interface StorageService {
    void update(@RequestParam("productId")Long productId, @RequestParam("count")Integer count);
}
