package com.community.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.community.compont.Paging;
import com.community.pojo.Article;
import com.community.service.Articleservice;
import com.community.service.Readerservice;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月9日下午1:56:12
 * 
 * @Todo: TODO
 */
@Controller
public class Articlecontroller {

	@Autowired
	Articleservice articleservice;

	@Autowired
	Readerservice readerservice;

	// @Todo:TODO
	@RequestMapping("/")
	public String index(Model model) {
		List<Article> articles = articleservice.getall_article(1);
		Paging paging = articleservice.getPaging();
		model.addAttribute("articles", articles);
		model.addAttribute("paging", paging);
		return "index";
	}

	// @Todo:来到添加文章页面
	@GetMapping("/toaddarticle")
	private String toaddarticle() {
		return "publish";
	}

	// @Todo:添加文章
	@PostMapping("/check/addarticle")
	public String addarticle(Article article, HttpSession session) {
		if (article.getId() == null) {

			// 查询session中登录用户，根据登录用户id给文章creator赋值
			String readerid = readerservice.selectreaderid();
			article.setCreator(readerid);
			article.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			articleservice.addarticle(article);
		} else {
			articleservice.updatearticle(article);
		}
		return "redirect:/";
	}

	// @Todo:点击分页页码，进行分析查询,跳转页面
	@GetMapping("/pages{index}")
	private String pagesindex(@RequestParam(value = "page") int page, Model model) {
		List<Article> articles = articleservice.getall_article(page);
		Paging paging = articleservice.getPaging();
		model.addAttribute("articles", articles);
		model.addAttribute("paging", paging);
		return "index";
	}
}
