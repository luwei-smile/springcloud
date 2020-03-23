package com.microserivers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Auther 卢伟
 * 
 * @Time 2020年3月10日下午4:35:41
 * 
 * @Todo: TODO
 */
@SpringBootApplication
@EnableZuulProxy
public class Microserivers_zuul {

	//@Todo:TODO
	public static void main(String[] args) {
		SpringApplication.run(Microserivers_zuul.class, args);

	}

}
