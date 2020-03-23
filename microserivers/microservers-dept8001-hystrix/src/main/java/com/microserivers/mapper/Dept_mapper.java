package com.microserivers.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.microserivers.entity.Dept;

/**
 * @Auther 卢伟
 * 
 * @Time 2020年3月10日下午5:30:57
 * 
 * @Todo: TODO
 */
public interface Dept_mapper {

	@Select("SELECT * FROM test.dept")
	List<Dept> All_dept();
}
