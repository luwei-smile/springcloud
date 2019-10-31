package com.app.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Login {

	@PostMapping(value = "/login/dashboard")
	public String login_dashboard(@RequestParam String username, @RequestParam String password,
			Map<String, String> map, HttpSession session) {
		if (password.equals("123") && !username.isEmpty()) {
			session.setAttribute("loginuser", username);
			return "redirect:/dashboard";
		} else {
			map.put("msg", "账号和密码错误");
			return "/index";
		}
	}
}
