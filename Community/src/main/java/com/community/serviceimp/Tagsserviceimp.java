package com.community.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.mapper.Tagsmapper;
import com.community.pojo.Tags;
import com.community.service.Tagsservice;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月22日上午9:59:13
 * 
 * @Todo: 标签服务层
 */
@Service
public class Tagsserviceimp implements Tagsservice {

	@Autowired
	Tagsmapper tagsmapper;

	// TODO:显示相同类型的标签
	public List<Tags> gettagsBytype(String tagstype) {
		return tagsmapper.tagsBytype(tagstype);
	}

}
