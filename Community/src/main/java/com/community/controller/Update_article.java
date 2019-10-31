package com.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.community.mapper.Articlemapper;
import com.community.pojo.Article;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月15日下午6:53:32
 * 
 * @Todo: 文章的修改
 */
@Controller
public class Update_article {

	@Autowired
	Articlemapper articlemapper;

	// @Todo:根据ID查询进行页面回显
	@GetMapping("/updatearticle")
	public String update(@RequestParam("articleid") Integer articleid, Model model) {
		Article article = articlemapper.getArticleById(articleid);
		model.addAttribute("article", article);
		return "publish";

	}
}
