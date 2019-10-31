package com.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.community.pojo.Reader;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月10日下午1:22:15
 * 
 * @Todo: 操作用户实体映射文件
 */
public interface Readermapper {

	// @Todo:用户注册
	@Insert("INSERT INTO `hibernate`.`article` (`name`, `mobile`, `psd`) "
			+ "VALUES (#{reader.name},#{reader.mobile},#{reader.psd})")
	void register(@Param("reader") Reader reader);

	// @Todo:根据用户名查询密码
	@Select("select psd from hibernate.reader where name = #{name}")
	String selectreader(@Param("name") String name);

	// @Todo:根据用户名查询用户ID
	@Select("select id from hibernate.reader where name = #{name}")
	String selectreaderid(@Param("name") String name);

	// @Todo:根据Id查询用户
	@Select("select * from hibernate.reader where id = #{creator}")
	Reader selectreaders(@Param("creator") String creator);

	// @Todo:得到评论用户name
	@Select("select name from hibernate.reader where id = #{replierid}")
	String gettitleByreplierid(int replierid);
}
