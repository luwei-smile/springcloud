package com.community.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.community.compont.Paging;
import com.community.pojo.Comment;
import com.community.pojo.Reader;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月18日下午4:36:14
 * 
 * @Todo: 评论操作服务层接口
 */
@Service
public interface Commentservice {

	// @Todo:根据文章ID分页查询
	public List<Comment> comment_pages(int page, Integer articleid);

	// @Todo:获取文章评论总数
	public int comment_count(int articleid);

	// @Todo:添加一条评论
	public void send_comment(String commentcontent, int articleid, String id);

	public Paging getPaging();

	// @Todo:根据comment_parent拿到全部二级评论
	public List<Comment> Secondary_comment(String comment_parent, String articleid);

	// @Todo:根据Id查询用户
	public Reader selectreaders(String commentator);

	// @Todo:二级级评论回复一级评论
	public void send_secondary_comment(String commentcontent, int comment_parent, String selectreaderid,
			int articleid);

}
