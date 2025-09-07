package com.support.service.support_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SupportServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupportServiceApplication.class, args);

        //to define custom application.properties file
//        new SpringApplicationBuilder(SupportServiceApplication.class)
//                .properties("spring.config.name=custom-config")
//                .run(args);
    }

}
