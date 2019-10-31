package com.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.community.pojo.Article;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月9日下午9:15:17
 * 
 * @Todo: 操作文章映射文件
 */

public interface Articlemapper {

	// @Todo:插入一篇文章
	@Insert("INSERT INTO `hibernate`.`article` (`title`, `description`, `tag`, `gmt_creat`, `gmt_modified`,`creator`,`create_time`) "
			+ "VALUES (#{article.title},#{article.description},#{article.tag},#{article.gmt_creat},#{article.gmt_modified},"
			+ "#{article.creator},#{article.create_time})")
	void addarticle(@Param("article") Article article);

	// @Todo:查询所有的文章
	@Select("SELECT * FROM hibernate.article")
	List<Article> getall_article();

	// @Todo:分页查询
	@Select("SELECT * FROM hibernate.article order by id desc limit #{begin},#{number}")
	List<Article> article_pages(@Param("begin") int begin, @Param("number") int number);

	// @Todo:查询记录总数
	@Select("SELECT count(1) FROM hibernate.article")
	int count();

	// @Todo:查询根据用户分记录总数
	@Select("SELECT count(1) FROM hibernate.article where creator = #{creator}")
	int persioncount(@Param("creator") Integer creator);

	// @Todo:根据用户分页查询
	@Select("SELECT * FROM hibernate.article where creator = #{creator} order by id desc limit #{begin},#{number}")
	List<Article> persional_pages(@Param("begin") int begin, @Param("number") int number,
			@Param("creator") Integer creator);

	// @Todo:根据文章id查询
	@Select("SELECT * FROM hibernate.article where id = #{id}")
	Article getArticleById(@Param("id") Integer id);

	// @Todo:修改文章
	@Update("UPDATE `hibernate`.`article` SET `title` = #{article.title}, `description` = #{article.description}, `tag` = #{article.tag} WHERE `id` = #{article.id}")
	void updatearticle(@Param("article")Article article);
}
