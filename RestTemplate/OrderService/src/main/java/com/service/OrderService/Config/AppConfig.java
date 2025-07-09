package com.service.OrderService.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.Proxy;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate getRestTemplate(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(500);
        factory.setReadTimeout(100);
        factory.setProxy(Proxy.NO_PROXY);
        return new RestTemplate(factory);
    }
}
