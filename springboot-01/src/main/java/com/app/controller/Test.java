package com.app.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {

	@RequestMapping("order")
	public String hello(Map<String, Object> map) {
		map.put("value", "<h1>Value</h1>");
		map.put("users", Arrays.asList("zhangsan", "lishi"));
		return "order";
	}
}
