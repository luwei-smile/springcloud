package com.microserivers.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.microserivers.entity.Dept;

import feign.hystrix.FallbackFactory;

/**
 * @Auther 卢伟
 * 
 * @Time 2020年3月19日下午5:48:47
 * 
 * @Todo: TODO
 */
@Component
public class Dept_Factory implements FallbackFactory<Deptservice_feign> {

	// TODO:TODO
	@Override
	public Deptservice_feign create(Throwable arg0) {
		return new Deptservice_feign() {

			@Override
			public List<Dept> All_Dept() {
				System.out.println("===========");
				ArrayList<Dept> list = new ArrayList<Dept>();
				list.add(new Dept(2, "2", "2", "2"));
				return list;
			}

		};
	}
}
