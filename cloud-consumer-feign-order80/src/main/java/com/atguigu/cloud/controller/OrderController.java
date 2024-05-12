package com.atguigu.cloud.controller;

import com.atguigu.cloud.apis.PayFegnApi;

import com.atguigu.cloud.apis.PayFenApi1;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

;

//@Slf4j
@RestController
public class OrderController {

    @Resource
    private PayFegnApi payFegnApi;

    @Resource
    private PayFenApi1 payFegnApi1;

    @PostMapping("/feign/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO){
        System.out.printf("增加订单");
        ResultData resultData=payFegnApi.addPay(payDTO);
        return resultData;
    }

    @GetMapping("/feign/pay/get/{id}")
    public ResultData getInfo(@PathVariable("id") Integer id){
        System.out.printf("查询");
        ResultData info = payFegnApi.getInfo(id);
        return info;

    }
    @GetMapping("/feign/pay1/get/{id}")
    public ResultData getInfo1(@PathVariable("id") Integer id){
        System.out.printf("查询");
        ResultData info = payFegnApi1.getInfo(id);
        return info;

    }
//
//    public static final String Paymentsr_url = "http://cloud-payment-service";
//
//    @Resource
//    private RestTemplate restTemplate;
//
//    @GetMapping(value = "/consumer/pay/add")
//    public ResultData addOrder(PayDTO payDTO){
//        return restTemplate.postForObject(Paymentsr_url + "/pay/add", payDTO, ResultData.class);
//    }
//
//    @GetMapping(value = "/consumer/pay/get/{id}")
//    public ResultData getPayinfo(@PathVariable("id") Integer id){
//        System.out.printf(Paymentsr_url+"/pay/get/"+id);
//        return restTemplate.getForObject(Paymentsr_url + "/pay/get/"+id, ResultData.class, id);
//    }
//
//    @GetMapping(value = "/consumer/pay/get/info")
//    public ResultData getConsulinfo(@Value("${atguigu.info}") String atguigu){
//        System.out.printf(Paymentsr_url+"/pay/get/");
//        return restTemplate.getForObject(Paymentsr_url + "/pay/get/info", ResultData.class, atguigu);
//    }

}
