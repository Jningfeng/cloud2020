package com.jnf.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id; //订单ID

    private Long userId; //用户ID

    private Long productId; //产品ID

    private Integer count; //数量

    private BigDecimal money;//金额

    private Integer status; //订单状态0- 创建， 1-完成
}
