package com.app.properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.pojo.Dog;

/**
 * 配置类向ioc容器中添加组件
 * 
 * @author lw
 *
 */
@Configuration
public class Dog_properties {

	@Bean
	public Dog adog() {// 配件id默认为方法名
		return new Dog();
	}
}
