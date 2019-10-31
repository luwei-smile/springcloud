package com.community;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月9日下午1:59:41
 * 
 * @Todo: 项目启动类
 */
@SpringBootApplication
@MapperScan(value = "com.community.mapper")
public class Community {

	public static void main(String[] args) {
		SpringApplication.run(Community.class, args);
	}

}
