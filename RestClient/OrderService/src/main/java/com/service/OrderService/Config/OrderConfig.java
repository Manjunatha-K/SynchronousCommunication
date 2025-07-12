package com.service.OrderService.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClient;

@Configuration
public class OrderConfig {

    @Bean
    public RestClient getRestClient() {
        return RestClient.create();
    }
}
