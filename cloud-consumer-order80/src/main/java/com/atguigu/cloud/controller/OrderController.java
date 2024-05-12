package com.atguigu.cloud.controller;

import com.atguigu.cloud.entitier.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

;

@RestController
public class OrderController {

    public static final String Paymentsr_url = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO){
        return restTemplate.postForObject(Paymentsr_url + "/pay/add", payDTO, ResultData.class);
    }

    @GetMapping(value = "/consumer/pay/get/{id}")
    public ResultData getPayinfo(@PathVariable("id") Integer id){
        System.out.printf(Paymentsr_url+"/pay/get/"+id);
        return restTemplate.getForObject(Paymentsr_url + "/pay/get/"+id, ResultData.class, id);
    }

    @GetMapping(value = "/consumer/pay/get/info")
    public ResultData getConsulinfo(@Value("${atguigu.info}") String atguigu){
        System.out.printf(Paymentsr_url+"/pay/get/");
        return restTemplate.getForObject(Paymentsr_url + "/pay/get/info", ResultData.class, atguigu);
    }

}
