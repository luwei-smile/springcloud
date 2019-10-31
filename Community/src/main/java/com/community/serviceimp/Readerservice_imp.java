package com.community.serviceimp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.mapper.Readermapper;
import com.community.pojo.Reader;
import com.community.service.Readerservice;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月10日下午1:27:19
 * 
 * @Todo: TODO
 */
@Service
public class Readerservice_imp implements Readerservice {

	@Autowired
	Readermapper readermapper;

	@Autowired
	HttpSession session;

	// TODO:用户注册
	public void register(Reader reader) {
		readermapper.register(reader);

	}

	// TODO:得到登录用户id
	public String selectreaderid() {
		Reader reader = (Reader) session.getAttribute("reader");
		return readermapper.selectreaderid(reader.getName());
	}

	// TODO:得到登录用户name
	public String selectreadername() {
		Reader reader = (Reader) session.getAttribute("reader");
		return reader.getName();
	}

	// TODO:得到评论用户name
	public String getrepliername(int replierid) {
		return readermapper.gettitleByreplierid(replierid);
	}

}
