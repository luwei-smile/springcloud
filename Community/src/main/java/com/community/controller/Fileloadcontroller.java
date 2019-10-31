package com.community.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.community.pojo.Fileload;
import com.community.service.Fileloadingserive;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月23日上午9:14:00
 * 
 * @Todo: 图片上传
 */
@Controller
public class Fileloadcontroller {

	@Autowired
	Fileloadingserive fileloadingserive;

	// @Todo:返回图片上传的json格式的数据
	@RequestMapping("/pic/upload")
	@ResponseBody
	private Fileload picload(HttpServletRequest request) {
		return fileloadingserive.picload(request);
	}
}
