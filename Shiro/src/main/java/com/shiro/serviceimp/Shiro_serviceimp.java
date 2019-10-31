package com.shiro.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiro.mapper.Shiro_boot;
import com.shiro.pojo.Login;
import com.shiro.service.Shiro_service;

@Service
public class Shiro_serviceimp implements Shiro_service {

	@Autowired
	private Shiro_boot shiro_boot;

	@Override
	public Login findone(String username) {

		return shiro_boot.FindOne("lu");
	}



}
