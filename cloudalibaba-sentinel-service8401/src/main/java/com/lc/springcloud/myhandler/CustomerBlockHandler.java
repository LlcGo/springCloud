package com.lc.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lc.springcloud.domain.CommResult;

/**
 * @Author Lc
 * @Date 2023/6/12
 * @Description
 */
public class CustomerBlockHandler {
    public static CommResult handleException(BlockException e){
        return new CommResult(2020,"自定义限流处理------>方式2");
    }

    public static CommResult handleException2(BlockException e){
        return new CommResult(2020,"自定义限流处理----->方式2");
    }
}
