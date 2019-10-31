package com.community.controller;


import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.community.pojo.Reader;
import com.community.service.Articleservice;
import com.community.service.Readerservice;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月10日下午12:45:45
 * 
 * @Todo: 用户登录注册
 */
@Controller
public class Login_register {

	@Autowired
	Readerservice readerservice;

	@Autowired
	Articleservice articleservice;

	// @Todo:TODO
	@GetMapping("/loginpage")
	public String loginpage() {
		return "login";
	}

	// @Todo:TODO
	@GetMapping("/registerpage")
	public String registerpage() {
		return "register";
	}

	// @Todo:用户登录
	@PostMapping("/login")
	public String login(Reader reader, Model model, HttpSession session) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(reader.getName(), reader.getPsd());
		try {
			subject.login(token);
			session.setAttribute("reader", reader);
			return "redirect:/";
		} catch (AuthenticationException e) {
			model.addAttribute("loginmsg", "用户名或者密码输入错误");
			return "login";
		}

	}

	// @Todo:TODO
	@PostMapping("/register")
	public String register(Reader reader) {
		readerservice.register(reader);
		return "redirect:/login";

	}
}
