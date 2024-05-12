package com.atguigu.cloud.controller;

import com.atguigu.cloud.Service.PayServiceImpl;
import com.atguigu.cloud.entities.pay;
import com.atguigu.cloud.resp.ResultData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

;

@Slf4j
@RestController
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {

    @Autowired
    private PayServiceImpl payService1;

    @PostMapping("/pay/add")
    @Operation(summary = "插入",description = "增加方法")
    public ResultData add(@RequestBody pay pay){
        System.out.printf(pay.toString());
        int add = payService1.add(pay);
        return ResultData.success("增加成功值："+add);
    }

    @GetMapping("/pay/get/{id}")
    @Operation(summary = "获取",description = "获取方法")
    public ResultData getBYID(@PathVariable("id") Integer id){
        System.out.printf("这是8002");
        return ResultData.success(payService1.getByid(id));
//        return "查询成功";
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/pay/get/info")
    public String getinfoByConsul(@Value("${atguigu.info}") String atguigu){
        System.out.printf("这是8002");
        return "atguiguinfo:" + atguigu+"\t"+port;
    }
}
