package com.lc.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface AccountDao {
       void update(@Param("userId")Long id, @Param("money") BigDecimal money);
}
