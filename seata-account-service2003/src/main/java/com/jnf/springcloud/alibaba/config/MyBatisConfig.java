package com.jnf.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.jnf.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
