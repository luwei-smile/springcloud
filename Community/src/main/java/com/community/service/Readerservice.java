package com.community.service;

import org.springframework.stereotype.Service;

import com.community.pojo.Reader;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月10日上午9:34:24
 * 
 * @Todo: 处理文章业务层
 */
@Service
public interface Readerservice {

	// @Todo:用户注册
	void register(Reader reader);

	// @Todo:根据用户名查询用户ID
	String selectreaderid();

	// @Todo:根据用户名查询用户ID
	String selectreadername();

	// @Todo:根据回复id查询用户名称
	String getrepliername(int replierid);
}
