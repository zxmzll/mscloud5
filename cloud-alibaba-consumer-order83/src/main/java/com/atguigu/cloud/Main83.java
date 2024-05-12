package com.atguigu.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients//用于激活Fegin功能
@EnableDiscoveryClient //用于向consul注册服务
public class Main83 {
    public static void main(String[] args) {
        SpringApplication.run(Main83.class);
    }
}