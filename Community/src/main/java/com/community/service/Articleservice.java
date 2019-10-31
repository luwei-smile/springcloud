package com.community.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.community.compont.Paging;
import com.community.pojo.Article;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月10日上午9:34:24
 * 
 * @Todo: 处理文章业务层
 */
@Service
public interface Articleservice {

	// @Todo:添加文章
	void addarticle(Article article);

	// @Todo:分页查询
	List<Article> getall_article(int pageNumber);

	// @Todo:得到分页对象
	Paging getPaging();

	// @Todo:获取用户发布的文章
	List<Article> persion_article(Integer name, Integer pageNumber);

	// @Todo:根据文章id查询
	Article getArticleById(Integer id);

	// @Todo:修改文章
	void updatearticle(Article article);
}
