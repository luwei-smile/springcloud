package com.microserivers;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther 卢伟
 * 
 * @Time 2020年3月10日下午4:35:41
 * 
 * @Todo: TODO
 */
@SpringBootApplication
@MapperScan(value = "com.microserivers.mapper")
@EnableEurekaClient // 启动服务后自动注册进入Eureka服务中
public class MicroseriversApp {

	//@Todo:TODO
	public static void main(String[] args) {
		SpringApplication.run(MicroseriversApp.class, args);

	}

}
