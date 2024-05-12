package com.atguigu.cloud;

//条件过滤器

import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Component
public class MyGatewayFilterFactory extends AbstractGatewayFilterFactory<MyGatewayFilterFactory.Config> {


    public MyGatewayFilterFactory() {
        super(MyGatewayFilterFactory.Config.class);
    }

    @Override
    public GatewayFilter apply(MyGatewayFilterFactory.Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                ServerHttpRequest request = exchange.getRequest();
                ServerHttpResponse response = exchange.getResponse();
                System.out.printf("进入了自定义过滤器MyGatewayFilterFactory，status值等于:"+config.getStatus());
                if (request.getQueryParams().containsKey("atguigu")){
                    return chain.filter(exchange);//放行
                }else {
                    exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
                }
                return exchange.getResponse().setComplete();
            }
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("status");
    }

    public static class Config{
        @Getter@Setter
        private String status;//设置状态值，匹配后才可以访问
    }
}
