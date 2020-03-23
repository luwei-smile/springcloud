package com.microserivers.serivers;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microserivers.entity.Dept;

/**
 * @Auther 卢伟
 * 
 * @Time 2020年3月10日下午5:28:48
 * 
 * @Todo: TODO
 */
@Service
public interface Dept_serivers {

	// @Todo:TODO
	List<Dept> All_dept();
}
