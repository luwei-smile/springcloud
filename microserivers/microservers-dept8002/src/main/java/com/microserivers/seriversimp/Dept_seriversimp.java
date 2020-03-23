package com.microserivers.seriversimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microserivers.entity.Tag;
import com.microserivers.mapper.Dept_mapper;
import com.microserivers.serivers.Dept_serivers;

/**
 * @Auther 卢伟
 * 
 * @Time 2020年3月10日下午5:27:53
 * 
 * @Todo: TODO
 */
@Service
public class Dept_seriversimp implements Dept_serivers {

	@Autowired
	Dept_mapper dept_mapper;

	@Override
	public List<Tag> All_dept() {
		return dept_mapper.All_dept();
	}

}
