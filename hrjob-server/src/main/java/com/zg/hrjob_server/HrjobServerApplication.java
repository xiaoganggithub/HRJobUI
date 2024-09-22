package com.zg.hrjob_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zg.hrjob_server.mapper")
public class HrjobServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrjobServerApplication.class, args);
	}

}
