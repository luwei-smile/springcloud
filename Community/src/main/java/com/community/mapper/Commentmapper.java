package com.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.community.pojo.Comment;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月18日下午4:19:42
 * 
 * @Todo: 操作评论表
 */
public interface Commentmapper {

	// @Todo:根据文章ID分页查询
	@Select("SELECT * FROM hibernate.comment where articleid = #{articleid} and comment_parent = 0 order by commentid desc limit #{begin},#{number}")
	List<Comment> comment_pages(@Param("begin") int begin, @Param("number") int number,
			@Param("articleid") Integer articleid);

	// @Todo:根据文章ID,comment_parent分页查询评论总条数
	@Select("SELECT count(1) FROM hibernate.comment where articleid = #{articleid} and comment_parent = 0")
	int count(@Param("articleid") int articleid);

	// @Todo:添加一条评论
	@Insert("INSERT INTO `hibernate`.`comment` (`commentator`, `articleid`, `commentdata`, `commentcontent`) VALUES"
			+ " (#{comment.commentator},#{comment.articleid},#{comment.commentdata},#{comment.commentcontent})")
	void send_comment(@Param("comment") Comment comment);

	// @Todo:根据comment_parent拿到全部二级评论
	@Select("SELECT * FROM hibernate.comment where comment_parent = #{comment_parent} order by commentid desc")
	List<Comment> Secondary_comment(@Param("comment_parent") String comment_parent,
			@Param("articleid") String articleid);

	// @Todo:二级级评论回复一级评论
	@Insert("INSERT INTO `hibernate`.`comment` (`commentator`, `comment_parent`, `commentdata`, `commentcontent`) VALUES"
			+ " (#{comment.commentator},#{comment.comment_parent},#{comment.commentdata},#{comment.commentcontent})")
	void send_secondary_comment(@Param("comment") Comment comment);

	// @Todo:根据父评论过去评论人id
	@Select("SELECT commentator FROM hibernate.comment where commentid = #{comment_parent}")
	int getcommentatorBycomment_parent(@Param("comment_parent") int comment_parent);
}
