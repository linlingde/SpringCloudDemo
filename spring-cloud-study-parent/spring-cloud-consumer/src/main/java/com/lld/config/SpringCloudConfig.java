package com.lld.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author linlingde
 * @version 1.0
 * @className SpringCloudConfig
 * @description
 * @date 2022/7/27 15:10
 **/

@Configuration
public class SpringCloudConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


}
