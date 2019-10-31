package com.community.pojo;

import org.springframework.stereotype.Repository;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月17日下午1:42:09
 * 
 * @Todo: 评论实体
 */
@Repository
public class Comment {

	private int commentid;

	// 评论的父评论
	private int comment_parent;

	// 评论人id
	private String commentator;
	private Reader reader;

	// 文章id
	private int articleid;

	// 评论时间
	private String commentdata;

	// 内容
	private String commentcontent;

	// 喜欢和不喜欢
	private int enjoy;
	private int vapidity;

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public int getCommentid() {
		return commentid;
	}

	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}

	public int getComment_parent() {
		return comment_parent;
	}

	public void setComment_parent(int comment_parent) {
		this.comment_parent = comment_parent;
	}

	public String getCommentator() {
		return commentator;
	}

	public void setCommentator(String commentator) {
		this.commentator = commentator;
	}

	public int getArticleid() {
		return articleid;
	}

	public void setArticleid(int articleid) {
		this.articleid = articleid;
	}

	public String getCommentdata() {
		return commentdata;
	}

	public void setCommentdata(String commentdata) {
		this.commentdata = commentdata;
	}

	public String getCommentcontent() {
		return commentcontent;
	}

	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}

	public int getEnjoy() {
		return enjoy;
	}

	public void setEnjoy(int enjoy) {
		this.enjoy = enjoy;
	}

	public int getVapidity() {
		return vapidity;
	}

	public void setVapidity(int vapidity) {
		this.vapidity = vapidity;
	}

	@Override
	public String toString() {
		return "Comment [commentid=" + commentid + ", comment_parent=" + comment_parent + ", commentator=" + commentator
				+ ", articleid=" + articleid + ", commentdata=" + commentdata + ", commentcontent=" + commentcontent
				+ ", enjoy=" + enjoy + ", vapidity=" + vapidity + "]";
	}


}
