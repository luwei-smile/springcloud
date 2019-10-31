package com.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.community.pojo.Reply;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月22日下午1:55:19
 * 
 * @Todo: 我的最新回复
 */
public interface Newreplymapper {

	// @Todo:查看我的最新回复
	@Select("SELECT * FROM hibernate.reply where receiverid = #{readerid} order by replyid desc")
	List<Reply> getreplyByreceiverid(@Param("readerid") String readerid);

	// @Todo:查询回复总数根据登录用户id
	@Select("SELECT count(1) FROM hibernate.reply where receiverid = #{readerid} order by replyid desc")
	int getcountByreaderid(@Param("readerid") String readerid);

	// @Todo:添加一条评论时同时添加一条消息
	@Insert("INSERT INTO `hibernate`.`reply` (`replierid`, `replytype`, `replyaricleid`, `receiverid`) "
			+ "VALUES (#{reply.replierid},#{reply.replytype},#{reply.replyaricleid},#{reply.receiverid})")
	void addreply(@Param("reply") Reply reply);

	// @Todo:设置通知已读
	@Update("UPDATE `hibernate`.`reply` SET `replyatste` = 'true' WHERE (`replyid` = #{replyid})")
	void replyatste(@Param("replyid") int replyid);

}
