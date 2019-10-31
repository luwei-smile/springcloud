package com.community.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.community.pojo.Fileload;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月23日下午12:28:02
 * 
 * @Todo: 图片文件上传
 */
@Service
public interface Fileloadingserive {

	// @Todo:图片上传
	Fileload picload(HttpServletRequest request);
}
