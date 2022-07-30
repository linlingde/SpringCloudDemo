package com.lld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author linlingde
 * @version 1.0
 * @className AtguiguMainType
 * @description
 * @date 2022/7/27 14:41
 **/

@EnableHystrix
@SpringBootApplication
public class ProviderMainType {

    public static void main(String[] args) {
        SpringApplication.run(ProviderMainType.class, args);

    }
}
