package com.jnf.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface StorageDao {

    //扣减库存
       void decrease(@Param("productId") Long productId , @Param("count") Integer count);

}
