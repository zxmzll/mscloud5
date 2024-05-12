package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


//EnableFeignClients是openfigen启动类必须要有的注解标签：启用feign客户端，定义服务+绑定接口，以声明式的方法优雅地简单的实现服务调用
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient //用于向consul注册服务
public class MainOpenFegin80 {
    public static void main(String[] args) {
        SpringApplication.run(MainOpenFegin80.class);
    }
}