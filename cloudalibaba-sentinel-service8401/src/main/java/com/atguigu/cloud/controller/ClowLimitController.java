package com.atguigu.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.cloud.service.FlowLimitService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ClowLimitController {

    @GetMapping("/testA")
    public String testA()
    {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        return "------testB";
    }

    @Resource
    private FlowLimitService flowLimitService;


    @GetMapping("/testC")
    public String testC()
    {
        flowLimitService.common();
        return "------testC";
    }

//如果访问量触发了Sentnel配置的流控，那么进入自定义流控方法，如果是是程序抛出JVM错误，那么返回自定义降级方法。两者可以共存
    @GetMapping("/testD/{id}")
    @SentinelResource(value = "byRS",blockHandler = "handerBack",fallback = "backll")
    public String testD(@PathVariable("id") Integer id)
    {
//        flowLimitService.common();
        if (id == 0){
            throw new RuntimeException("id不能为0");
        }
        return "------testD";
    }

    public String backll(@PathVariable("id") Integer id,Throwable e){
        System.out.printf("");
        return "这是fallback"+e.getMessage();
    }

    public String handerBack(@PathVariable("id") Integer id,BlockException blockException){
        return "这是handerBack";
    }








    //热点参数


    @GetMapping("/testF")
    @SentinelResource(value = "byRS",blockHandler = "handerBack2")
    public String testF(@RequestParam(value = "x1",required = false)String x1,
                        @RequestParam(value = "x2",required = false)String x2)
    {
//        flowLimitService.common();
        return "------testC";
    }

    public String handerBack2(@RequestParam(value = "x1",required = false)String x1,
                              @RequestParam(value = "x2",required = false)String x2,BlockException blockException){
        return "限流handerBack2";
    }

    /**
     * 热点参数限流
     * @param p1
     * @param p2
     * @return
     */
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "dealHandler_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "------testHotKey";
    }
    public String dealHandler_testHotKey(String p1,String p2,BlockException exception)
    {
        return "-----dealHandler_testHotKey";
    }
}
