package com.community.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.community.compont.Paging;
import com.community.pojo.Reply;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月22日下午1:54:09
 * 
 * @Todo: 我的最新回复
 */
@Service
public interface Newreplyservice {

	// @Todo:查看我的最新回复
	List<Reply> getreplys();

	// @Todo:得到分页对象
	Paging getPaging(int page);

	// @Todo:设置通知已读
	void setMarkRead(int replyid);

}
