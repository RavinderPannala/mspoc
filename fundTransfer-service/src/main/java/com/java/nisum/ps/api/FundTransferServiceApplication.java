package com.java.nisum.ps.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;


@SpringBootApplication
@EnableEurekaClient
public class FundTransferServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(FundTransferServiceApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
