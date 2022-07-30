package com.lld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author linlingde
 * @version 1.0
 * @className AtguiguMainType
 * @description
 * @date 2022/7/27 15:08
 **/
@EnableFeignClients
@SpringBootApplication
public class ConsumerMainType {


    public static void main(String[] args) {
        SpringApplication.run(ConsumerMainType.class, args);
    }
}
