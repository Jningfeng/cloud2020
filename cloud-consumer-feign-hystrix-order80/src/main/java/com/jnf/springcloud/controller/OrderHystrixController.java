package com.jnf.springcloud.controller;

import com.jnf.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paumnt_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService ;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public  String paymentInfo_OK(@PathVariable("id") Integer id){
        String paymentInfo_ok = paymentHystrixService.paymentInfo_OK(id);
        return paymentInfo_ok ;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    /*@HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds",value = "1500" )
    })*/
    @HystrixCommand
    public  String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String paymentInfo_timeOut = paymentHystrixService.paymentInfo_TimeOut(id);
        return paymentInfo_timeOut;
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,/(ㄒoㄒ)/~~";
    }

    //下面是全局的fallback方法
    public  String paumnt_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试/(ㄒoㄒ)/~~";
    }
}
