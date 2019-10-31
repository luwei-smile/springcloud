package com.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shiro.serviceimp.Shiro_serviceimp;

@Controller
public class Shiro_Controller {

	@Autowired
	private Shiro_serviceimp shiro_serviceimp;

	@RequestMapping("/log")
	public String hello() {
		System.out.println(shiro_serviceimp.findone("lu"));
		// 创建securitymangerfactory工厂 读取配置文件
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		// 通过securitymanger工厂获取实例
		SecurityManager instance = factory.getInstance();
		// 设置运行环境
		SecurityUtils.setSecurityManager(instance);
		// 得到subject对象
		Subject subject = SecurityUtils.getSubject();

		// token中的用户和凭证是用户输入的
		UsernamePasswordToken Token = new UsernamePasswordToken("zhang", "[C@2fe4f615");
		System.out.println(Token.getUsername() + Token.getPassword());
		if (subject.isAuthenticated()) {
			System.out.println("验证成功");
		} else {
			System.out.println("验证成失败");
		}
		return "login";
	}
}
