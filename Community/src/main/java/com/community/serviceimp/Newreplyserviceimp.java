package com.community.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.compont.Paging;
import com.community.mapper.Newreplymapper;
import com.community.pojo.Reply;
import com.community.service.Articleservicedetail;
import com.community.service.Newreplyservice;
import com.community.service.Readerservice;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月22日下午1:54:53
 * 
 * @Todo: 我的最新回复
 */
@Service
public class Newreplyserviceimp implements Newreplyservice {

	@Autowired
	Newreplymapper newreplymapper;

	@Autowired
	Readerservice readerservice;

	@Autowired
	Articleservicedetail articleservicedetail;

	// TODO:查看我的最新回复
	public List<Reply> getreplys() {
		List<Reply> replylist = newreplymapper.getreplyByreceiverid(readerservice.selectreaderid());
		for (Reply reply : replylist) {
			// 根据文章id和评论人id设置文章title和评论人name
			reply.setReplyariclename(articleservicedetail.getnameByarticleid(reply.getReplyaricleid()));
			reply.setReceivername(readerservice.getrepliername(reply.getReplierid()));
		}
		return replylist;
	}

	// TODO:得到分页对象
	public Paging getPaging(int page) {
		int count = newreplymapper.getcountByreaderid(readerservice.selectreaderid());
		Paging paging = new Paging(count, page);
		return paging;
	}

	// TODO:设置通知已读
	public void setMarkRead(int replyid) {
		newreplymapper.replyatste(replyid);

	}

}
