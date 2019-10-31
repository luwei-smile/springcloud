package com.community.controller.persional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.community.compont.Paging;
import com.community.mapper.Readermapper;
import com.community.pojo.Article;
import com.community.pojo.Comment;
import com.community.pojo.Reader;
import com.community.service.Articleservice;
import com.community.service.Articleservicedetail;
import com.community.service.Commentservice;
import com.community.service.Newreplyservice;
import com.community.service.Readerservice;
import com.community.service.Tagsservice;

/**
 * 
 * @Auther 卢伟
 * 
 * @Time 2019年10月13日下午3:07:10
 * 
 * @Todo: 个人中心控制器
 */
@Controller
public class Personal {

	@Autowired
	Articleservice articleservice;

	@Autowired
	Readermapper readermapper;

	@Autowired
	Articleservicedetail articleservicedetail;

	@Autowired
	Commentservice commentservice;

	@Autowired
	Tagsservice tagsservice;

	@Autowired
	Readerservice readerservice;

	@Autowired
	Newreplyservice newreplyservice;

	// @Todo:来到个人中心页面，点击分页页码，进行分析查询,跳转页面
	@GetMapping("/persional")
	private String pagesindex(@RequestParam(value = "page") int page, Model model) {
		String readerid = readerservice.selectreaderid();
		List<Article> articles = articleservice.persion_article(new Integer(readerid), page);
		Paging paging = articleservice.getPaging();
		model.addAttribute("articles", articles);
		model.addAttribute("paging", paging);
		// 根据状态显示个人中心的左上角的标题
		String status = "最新状态";
		model.addAttribute("profiltype", status);
		return "persional";
	}
	
	// @Todo:根据id查看文章具体详情
	@GetMapping("/detail")
	private String details(@RequestParam(value = "articleid") int articleid,
			@RequestParam(value = "replyid", defaultValue = "0") int replyid,
			@RequestParam(value = "page") int pageNumber, Model model) {
		// 查询文章和作者
		Article article = articleservice.getArticleById(articleid);
		Reader reader = readermapper.selectreaders(article.getCreator());
		// 阅读数 + 1
		article.setViewcount(article.getViewcount() + 1);
		articleservicedetail.viewcount(articleid);
		// 加载文章的评论,分页展示
		commentservice.comment_count(articleid);
		List<Comment> comment_pages = commentservice.comment_pages(pageNumber, articleid);
		for (Comment comment : comment_pages) {
			// 根据文章评论热id查询用户,并设置Comment中的Reader对象
			comment.setReader(readermapper.selectreaders(comment.getCommentator()));
		}
		
		// 根据标签进行相关文章推荐
		List<Article> Recommends = articleservicedetail.RecommendBytag(article.getTag(), articleid);

		// 设置通知已读
		newreplyservice.setMarkRead(replyid);

		Paging paging = commentservice.getPaging();

		model.addAttribute("Recommends", Recommends);
		model.addAttribute("article", article);
		model.addAttribute("reader", reader);
		model.addAttribute("paging", paging);
		model.addAttribute("comment_pages", comment_pages);
		return "detail";
	}

}
