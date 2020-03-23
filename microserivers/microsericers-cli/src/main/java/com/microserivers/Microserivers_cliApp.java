package com.microserivers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import myuilts.MyselfRule;

/**
 * @Auther 卢伟
 * 
 * @Time 2020年3月10日下午4:35:41
 * 
 * @Todo: TODO
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MICROSERIVERSAPP", configuration = MyselfRule.class)
public class Microserivers_cliApp {

	//@Todo:TODO
	public static void main(String[] args) {
		SpringApplication.run(Microserivers_cliApp.class, args);
	}

}
