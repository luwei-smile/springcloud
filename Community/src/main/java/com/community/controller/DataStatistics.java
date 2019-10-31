package com.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月29日下午7:53:01
 * 
 * @Todo: 网站数据统计
 */
@Controller
public class DataStatistics {

	@GetMapping("/Statistics")
	public String Statistics() {
		return "statistics/DataStatistics";
	}
}
