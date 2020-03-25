package com.jnf.springcloud.alibaba.service;


import com.jnf.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderService {

    void create(Order order);

}
