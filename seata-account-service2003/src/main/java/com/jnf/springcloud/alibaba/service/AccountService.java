package com.jnf.springcloud.alibaba.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

public interface AccountService {

    /**
     * 扣减账号余额
     * @param userId  用户Id
     * @param money   金额
     */
   void decrease(@RequestParam("userId") Long userId , @RequestParam("money") BigDecimal money);
}
