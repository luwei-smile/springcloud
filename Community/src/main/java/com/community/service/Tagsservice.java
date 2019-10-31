package com.community.service;

import java.util.List;

import com.community.pojo.Tags;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月22日上午9:58:46
 * 
 * @Todo: TODO
 */
public interface Tagsservice {

	// @Todo:显示全部类型的标签
	List<Tags> gettagsBytype(String tagstype);

}
