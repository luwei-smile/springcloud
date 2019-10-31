package com.community.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.community.pojo.Tags;
import com.community.service.Tagsservice;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月22日上午9:56:41
 * 
 * @Todo: TODO
 */
@Controller
public class Tagsconntroller {
	@Autowired
	Tagsservice tagsservice;

	// @Todo:显示全部类型的标签
	@GetMapping("/showtags")
	@ResponseBody
	private List<Tags> showtags(String tagstype) {
		return tagsservice.gettagsBytype(tagstype);

	}
}
