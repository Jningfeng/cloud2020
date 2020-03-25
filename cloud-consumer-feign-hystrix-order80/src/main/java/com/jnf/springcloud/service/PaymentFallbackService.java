package com.jnf.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements  PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "---------PaymentFallbackService fall back-paymentInfo_OK,O(∩_∩)O";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "---------PaymentFallbackService fall back-paymentInfo_TimeOut,O(∩_∩)O";
    }
}
