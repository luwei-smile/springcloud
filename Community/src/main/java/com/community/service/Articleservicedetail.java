package com.community.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.community.pojo.Article;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月15日下午8:34:20
 * 
 * @Todo: 文章细节修改
 */
@Service
public interface Articleservicedetail {

	// @Todo:修改浏览次数
	void viewcount(Integer id);

	// @Todo:根据标签进行相关文章推荐
	List<Article> RecommendBytag(String tags, int articleid);

	// @Todo:根据文章id查询文章名字
	String getnameByarticleid(int articleid);

}
