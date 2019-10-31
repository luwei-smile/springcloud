package com.community.controller.persional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.community.compont.Paging;
import com.community.pojo.Reply;
import com.community.service.Newreplyservice;
import com.community.service.Readerservice;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月22日下午1:50:43
 * 
 * @Todo: 我的最新回复
 */
@Controller
public class New_Reply {

	@Autowired
	Newreplyservice newreplyservice;

	@Autowired
	Readerservice readerservice;

	// @Todo:查看我的最新回复
	@GetMapping("/newreply")
	private String Newreply(@RequestParam("page") int page, Model model) {
		List<Reply> replylist = newreplyservice.getreplys();

		Paging paging = newreplyservice.getPaging(page);
		model.addAttribute("replylist", replylist);
		model.addAttribute("paging", paging);
		model.addAttribute("profiltype", "我的最新回复");
		return "newreply";

	}
}
