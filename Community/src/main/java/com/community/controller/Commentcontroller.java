package com.community.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.community.pojo.Comment;
import com.community.pojo.Reader;
import com.community.service.Commentservice;
import com.community.service.Readerservice;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月17日下午2:10:05
 * 
 * @Todo: 发表评论控制器
 */
@Controller
public class Commentcontroller {

	@Autowired
	Commentservice commentservice;

	@Autowired
	Readerservice readerservice;

	// @Todo:发表一级评论
	@Transactional
	@ResponseBody
	@PostMapping("/send_comment")
	private String send_comment(String commentcontent, int articleid) {
		// 根据登录用户的用户名来查询用户ID作为参数来出入评论表
		commentservice.send_comment(commentcontent, articleid, readerservice.selectreaderid());
		return "success";
	}

	// @Todo:二级级评论回复一级评论
	@Transactional
	@ResponseBody
	@PostMapping("/send_secondary_comment")
	private String send_secondary_comment(String commentcontent, int comment_parent, int articleid) {
		commentservice.send_secondary_comment(commentcontent, comment_parent, readerservice.selectreaderid(),
				articleid);
		return "success";
	}

	// @Todo:加载二级评论
	@ResponseBody
	@PostMapping("/secondary_comment")
	private List<Comment> Secondary_comment(String comment_parent, String articleid, Model model) {
		List<Comment> secondary_comments = commentservice.Secondary_comment(comment_parent, articleid);
		for (Comment comment : secondary_comments) {
			Reader reader = commentservice.selectreaders(comment.getCommentator());
			comment.setReader(reader);
		}
		return secondary_comments;
	}
}
