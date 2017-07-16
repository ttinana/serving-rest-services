package com.tijana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

//@SpringBootApplication
@Slf4j
@Configuration
@SpringBootApplication(scanBasePackages = "com.tijana")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
