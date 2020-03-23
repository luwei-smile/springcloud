package com.microserivers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


/**
 * @Auther 卢伟
 * 
 * @Time 2020年3月10日下午4:35:41
 * 
 * @Todo: TODO
 */
@SpringBootApplication
@EnableHystrixDashboard
public class Microserivers_clidashdoard {

	public static void main(String[] args) {
		SpringApplication.run(Microserivers_clidashdoard.class, args);
	}

}
