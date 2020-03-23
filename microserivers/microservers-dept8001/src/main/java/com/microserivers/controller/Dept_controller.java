package com.microserivers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microserivers.entity.Dept;
import com.microserivers.serivers.Dept_serivers;

/**
 * @Auther 卢伟
 * 
 * @Time 2020年3月10日下午5:30:12
 * 
 * @Todo: TODO
 */
@RestController
public class Dept_controller {

	@Autowired
	Dept_serivers dept_serivers;

	// @Todo:TODO
	@RequestMapping("/alldept")
	private List<Dept> All_dept() {
		System.out.println("8001");
		return dept_serivers.All_dept();
	}
}
