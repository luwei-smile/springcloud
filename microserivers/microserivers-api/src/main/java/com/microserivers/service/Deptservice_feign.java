package com.microserivers.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.microserivers.entity.Dept;

/**
 * @Auther 卢伟
 * 
 * @Time 2020年3月16日下午2:46:51
 * 
 * @Todo: TODO
 */

@FeignClient(value = "MICROSERIVERSAPP", fallbackFactory = Dept_Factory.class)
public interface Deptservice_feign {

	@RequestMapping(value = "/alldept")
	List<Dept> All_Dept();

}
