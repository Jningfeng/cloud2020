package com.jnf.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")

     public String testA(){

         return "---testA";
     }

    @GetMapping("/testB")
    public String testB(){
        log.info(Thread.currentThread().getName()+"\t"+"...testB");
        return "---testB";
    }

    @GetMapping("/testD")
    public String testD(){
         //暂停几秒
         try {TimeUnit.SECONDS.sleep(1);}catch (InterruptedException e){e.printStackTrace();}
        log.info("testD 测试RT");
        return "---testD";
    }

    @GetMapping("/testE")
    public String testE(){

        log.info("testE 测试异常数");
        int age  = 10/0 ;
        return "---testE";
    }

    @GetMapping("/testHotkey")
    @SentinelResource(value = "testHotkey" ,blockHandler = "deal_testHotKey")
    public String testHotkey(@RequestParam(value = "p1",required = false)String p1,
                              @RequestParam(value = "p1",required = false)String p2){
          return "--------testHotkey";
    }

    public String deal_testHotKey(String p1 , String p2 , BlockException e){
        return "--------deal_testHotKey,/(ㄒoㄒ)/~~";
    }
}
