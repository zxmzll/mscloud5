package com.atguigu.cloud.config;


import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FegnConfig {

    //开启重试配置,fegin默认是不开启重试功能
    @Bean
    public Retryer myRetrter(){
        //最大请求次数3，初始间隔为100ms，重试间最大间隔为1s
        return new Retryer.Default(100,1,3);

    }


    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.BASIC;
    }
}
