package com.community.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.compont.Paging;
import com.community.mapper.Articlemapper;
import com.community.mapper.Readermapper;
import com.community.pojo.Article;
import com.community.service.Articleservice;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月10日上午9:37:00
 * 
 * @Todo: 操作文章
 */
@Service
public class Articleservice_imp implements Articleservice {

	@Autowired
	Articlemapper articlemapper;

	@Autowired
	Readermapper readermapper;

	private Paging paging;

	// TODO:发表文章
	public void addarticle(Article article) {
		articlemapper.addarticle(article);
	}

	// @Todo:根据文章id查询
	public Article getArticleById(Integer id) {
		Article article = articlemapper.getArticleById(id);
		return article;
	}

	// TODO:查询所有文章发布到主页上
	public List<Article> getall_article(int pageNumber) {
		int count = articlemapper.count();
		paging = new Paging(count, pageNumber);
		// 分页 当第一次访问页面时 默认当前页是1
		List<Article> list = articlemapper.article_pages(paging.getLimit() * (pageNumber - 1), paging.getLimit());
		for (Article article : list) {
			article.setReader(readermapper.selectreaders(article.getCreator()));
		}
		return list;
	}

	// TODO:获取用户发布的文章
	public List<Article> persion_article(Integer creator, Integer pageNumber) {
		int count = articlemapper.persioncount(creator);

		// 每个页面创建自己的分页页面
		paging = new Paging(count, pageNumber);
		// 分页 当第一次访问页面时 默认当前页是1
		List<Article> list = articlemapper.persional_pages(paging.getLimit() * (paging.getPageNumber() - 1),
				paging.getLimit(), creator);
		for (Article article : list) {
			article.setReader(readermapper.selectreaders(article.getCreator()));
		}
		return list;
	}

	// TODO:修改文章
	public void updatearticle(Article article) {
		articlemapper.updatearticle(article);
	}

	// 等到分页对象
	public Paging getPaging() {
		return paging;
	}

}
