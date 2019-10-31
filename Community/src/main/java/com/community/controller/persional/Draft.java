package com.community.controller.persional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.community.compont.Paging;
import com.community.pojo.Article;
import com.community.service.Articleservice;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月15日下午2:39:06
 * 
 * @Todo: 我的草稿
 */
public class Draft {

	@Autowired
	Articleservice articleservice;

	// @Todo:根据点击的侧边栏不同显示不同的页面
	@GetMapping("/draft")
	private String profil(@RequestParam(value = "page") int page, Model model) {
		List<Article> articles = articleservice.persion_article(5, page);
		Paging paging = articleservice.getPaging();
		model.addAttribute("articles", articles);
		model.addAttribute("paging", paging);
		model.addAttribute("profiltype", "我的草稿");

		return "persional";

	}
}
