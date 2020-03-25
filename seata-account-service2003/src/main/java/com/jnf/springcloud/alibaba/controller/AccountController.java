package com.jnf.springcloud.alibaba.controller;

import com.jnf.springcloud.alibaba.domain.CommonResult;
import com.jnf.springcloud.alibaba.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class AccountController {

    @Resource
    AccountService accountService ;

    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId , @RequestParam("money") BigDecimal money){
        accountService.decrease(userId,money);
        return new CommonResult(200,"扣减账号余额成功");
    }
}
