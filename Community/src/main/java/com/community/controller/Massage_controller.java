package com.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月13日下午3:03:41
 * 
 * @Todo: 消息中心控制器
 */
@Controller
public class Massage_controller {

	// @Todo:来到个人中心
	@RequestMapping("/massage")
	public String persional() {

		return "massage";

	}
}
