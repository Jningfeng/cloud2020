package com.jnf.springcloud.service;

import com.jnf.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


public interface PaymentService {
    int create(Payment payment) ;
    Payment getPaymentById(@Param("id") Long id) ;
}
