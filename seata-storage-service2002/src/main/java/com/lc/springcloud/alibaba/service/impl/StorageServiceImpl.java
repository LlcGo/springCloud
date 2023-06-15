package com.lc.springcloud.alibaba.service.impl;

import com.lc.springcloud.alibaba.dao.StorageDao;
import com.lc.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Lc
 * @Date 2023/6/15
 * @Description
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void update(Long productId, Integer count) {
      log.info("storage service 修改库存开始");
      storageDao.update(productId,count);
      log.info("storage service 修改库存成功结束");
    }
}
