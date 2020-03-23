package com.microserivers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Auther 卢伟
 * 
 * @Time 2020年3月10日下午4:35:41
 * 
 * @Todo: TODO
 */
@SpringBootApplication
@EnableEurekaServer
public class Microserivers_eureka_seriver {

	//@Todo:TODO
	public static void main(String[] args) {
		SpringApplication.run(Microserivers_eureka_seriver.class, args);

	}

}
