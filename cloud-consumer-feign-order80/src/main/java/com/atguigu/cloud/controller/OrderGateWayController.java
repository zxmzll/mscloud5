package com.atguigu.cloud.controller;

import com.atguigu.cloud.apis.PayFegnApi;

import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther zzyy
 * @create 2023-12-29 19:00
 */
@RestController
public class OrderGateWayController
{
    @Resource
    private PayFegnApi payFeignApi;

    @GetMapping(value = "/feign/pay/gateway/get/{id}")
    public ResultData getById(@PathVariable("id") Integer id)
    {
        return payFeignApi.getById(id);
    }

    @GetMapping(value = "/feign/pay/gateway/info")
    public ResultData<String> getGatewayInfo()
    {
        return payFeignApi.getGatewayInfo();
    }

    @GetMapping(value = "/feign/pay/gateway/show")
    public ResultData<String> getGatewayshow()
    {
        return payFeignApi.getGatewayShow();
    }
}
