package com.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * TODO
 *
 * @author 张庆福
 * @date 2021/4/12
 */
@SpringBootApplication(scanBasePackages = "com.example")
@EnableFeignClients(basePackages = {"com.example"})
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}