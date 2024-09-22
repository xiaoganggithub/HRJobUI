package com.example.hrjob;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.hrjob.mapper")
public class HrJobApplication {
    public static void main(String[] args) {
        SpringApplication.run(HrJobApplication.class, args);
    }
}