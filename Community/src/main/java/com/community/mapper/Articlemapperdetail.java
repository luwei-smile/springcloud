package com.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.community.pojo.Article;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月15日下午8:29:57
 * 
 * @Todo: 文章细节修改
 */
public interface Articlemapperdetail {

	// @Todo:修改浏览次数
	@Update("UPDATE `hibernate`.`article` SET `viewcount` = viewcount + 1 WHERE `id` = #{id}")
	void viewcount(@Param("id") Integer id);

	// @Todo:修改回复次数
	@Update("UPDATE `hibernate`.`article` SET `commentcount` = commentcount + 1 WHERE `id` = #{id}")
	void commentcount(@Param("id") String id);

	// @Todo:根据标签进行相关文章推荐
	@Select("SELECT * FROM hibernate.article where tag like #{tag} and id != #{articleid}")
	List<Article> Recommendarticle(@Param("tag") String tag, @Param("articleid") int articleid);

	// @Todo:根据文章id查询文章名字
	@Select("SELECT title FROM hibernate.article where id = #{articleid}")
	String getnameByarticleid(@Param("articleid") int articleid);

	// @Todo:根据文章id查询文章名字
	@Select("SELECT creator FROM hibernate.article where id = #{articleid}")
	String getcreatorByarticleid(@Param("articleid") int articleid);
}
