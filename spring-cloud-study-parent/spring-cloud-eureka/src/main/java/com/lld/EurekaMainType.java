package com.lld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author linlingde
 * @version 1.0
 * @className EurakeMainType
 * @description
 * @date 2022/7/27 16:36
 **/


@SpringBootApplication
@EnableEurekaServer
public class EurekaMainType {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMainType.class, args);
    }
}
