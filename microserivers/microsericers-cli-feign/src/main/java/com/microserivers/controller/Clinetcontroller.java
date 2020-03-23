package com.microserivers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microserivers.entity.Dept;
import com.microserivers.service.Deptservice_feign;

/**
 * @Auther 卢伟
 * 
 * @Time 2020年3月11日下午3:27:43
 * 
 * @Todo: TODO
 */
@RestController
public class Clinetcontroller {

	@Autowired
	Deptservice_feign deptservice_feign;

	@RequestMapping("/alldept")
	public List<Dept> cli_deptall() {
		System.out.println("=========");
		return deptservice_feign.All_Dept();
	}
}
