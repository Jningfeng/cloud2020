package com.jnf.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jnf.springcloud.entities.CommonResult;
import com.jnf.springcloud.entities.Payment;

public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException e){
        return new CommonResult(444,"按客户自定义,global handlerException---1");
    }

    public static CommonResult handlerException2(BlockException e){
        return new CommonResult(444,"按客户自定义,global handlerException---2");
    }
}
