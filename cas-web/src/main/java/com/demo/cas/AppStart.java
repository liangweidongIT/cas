package com.demo.cas;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableAsync
@EnableScheduling
@Slf4j
public class AppStart {
	public static void main(String[] args) {
		SpringApplication.run(AppStart.class);
		log.info("程序启动！！！");
		log.info("可以");
		System.out.println("hello git");
		System.out.println("update from git");
		log.info("udate from local");
		log.info("update from git 1111111");
		log.info("update from loca11111");
	}

}
