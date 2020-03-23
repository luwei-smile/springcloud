package com.microserivers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microserivers.entity.Dept;

/**
 * @Auther 卢伟
 * 
 * @Time 2020年3月11日下午3:27:43
 * 
 * @Todo: TODO
 */
@RestController
public class Clinetcontroller {
	// private final String CLI_URL = "http://localhost:8001";
	private final String CLI_URL = "http://MicroseriversApp";

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/cli/deptall")
	public List<Dept> cli_deptall() {
		System.out.println("cli");
		return restTemplate.getForObject(CLI_URL + "/alldept", List.class);
	}

	@RequestMapping("/cli/tagall")
	public List<Dept> cli_Tagall() {
		return restTemplate.getForObject(CLI_URL + "/alltag", List.class);
	}
}
