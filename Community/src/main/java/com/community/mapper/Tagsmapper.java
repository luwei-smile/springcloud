package com.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.community.pojo.Tags;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月22日上午10:44:23
 * 
 * @Todo: 标签
 */
public interface Tagsmapper {

	// @Todo:显示相同类型的标签
	@Select("SELECT * FROM hibernate.tags where tagtype = #{tagstype}")
	List<Tags> tagsBytype(@Param("tagstype") String tagstype);

}
