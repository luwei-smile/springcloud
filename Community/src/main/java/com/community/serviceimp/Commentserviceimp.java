package com.community.serviceimp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.compont.Paging;
import com.community.mapper.Articlemapperdetail;
import com.community.mapper.Commentmapper;
import com.community.mapper.Newreplymapper;
import com.community.mapper.Readermapper;
import com.community.pojo.Comment;
import com.community.pojo.Reader;
import com.community.pojo.Reply;
import com.community.service.Commentservice;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月18日下午4:41:04
 * 
 * @Todo: 评论操作服务层实现类
 */
@Service
public class Commentserviceimp implements Commentservice {

	@Autowired
	Commentmapper commentmapper;

	@Autowired
	Articlemapperdetail articlemapperdetail;

	@Autowired
	Readermapper readermapper;

	@Autowired
	Newreplymapper newreplymapper;

	private Paging paging;

	// @Todo:根据文章ID分页查询
	public List<Comment> comment_pages(int pageNumber, Integer articleid) {
		int count = commentmapper.count(articleid);
		paging = new Paging(count, pageNumber);
		// 分页 当第一次访问页面时 默认当前页是1
		List<Comment> list = commentmapper.comment_pages(paging.getLimit() * (pageNumber - 1), paging.getLimit(),
				articleid);
		return list;
	}

	// TODO:添加一条评论
	public void send_comment(String commentcontent, int articleid, String id) {
		Comment comment = new Comment();
		Reply reply = new Reply();

		// 构造评论对象
		comment.setArticleid(articleid);
		comment.setCommentcontent(commentcontent);
		comment.setCommentdata(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		comment.setCommentator(id);

		// 获取文章作者id
		int creatorid = readermapper.selectreaders(articlemapperdetail.getcreatorByarticleid(articleid)).getId();
		// 构造通知对象
		reply.setReceiverid(creatorid);
		reply.setReplytype("评论");
		reply.setReplyaricleid(articleid);
		reply.setReplierid(new Integer(id));

		newreplymapper.addreply(reply);

		// 增加文章回复条数
		articlemapperdetail.commentcount(articleid + "");
		// 添加回复
		commentmapper.send_comment(comment);
	}

	// TODO:二级级评论回复一级评论
	public void send_secondary_comment(String commentcontent, int comment_parent, String loginuserid,
			int articleid) {
		Comment comment = new Comment();
		Reply reply = new Reply();
		// 构造评论对象
		comment.setCommentcontent(commentcontent);
		comment.setComment_parent(comment_parent);
		comment.setCommentdata(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		comment.setCommentator(loginuserid);

		// 获取文章作者id
		int commentatorid = commentmapper.getcommentatorBycomment_parent(comment_parent);
		// 构造通知对象
		reply.setReceiverid(commentatorid);
		reply.setReplytype("回复");
		reply.setReplyaricleid(articleid);
		reply.setReplierid(new Integer(loginuserid));

		newreplymapper.addreply(reply);

		// 增加文章回复条数
		articlemapperdetail.commentcount(articleid + "");
		// 添加回复
		commentmapper.send_secondary_comment(comment);

	}

	// TODO:根据comment_parent拿到全部二级评论
	public List<Comment> Secondary_comment(String comment_parent, String articleid) {
		return commentmapper.Secondary_comment(comment_parent, articleid);
	}

	// TODO:根据Id查询用户
	public Reader selectreaders(String commentator) {
		// TODO Auto-generated method stub
		return readermapper.selectreaders(commentator);
	}


	// @Todo:根据文章ID查询评论总数
	public int comment_count(int articleid) {
		return commentmapper.count(articleid);
	}

	public Paging getPaging() {
		return paging;
	}



}
