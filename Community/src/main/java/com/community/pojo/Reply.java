package com.community.pojo;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月22日下午1:59:32
 * 
 * @Todo: 通知实体
 */
public class Reply {

	// 通知id
	private int replyid;
	// 回复人的id
	private int replierid;
	// 回复类型 评论还是回复评论
	private String replytype;
	// 回复文章的id
	private int replyaricleid;
	private String replyariclename;
	// 接收人的id和名字
	private int receiverid;
	private String receivername;
	// 通知状态 已读还是未读
	private boolean replyatste;

	public String getReplyariclename() {
		return replyariclename;
	}

	public void setReplyariclename(String replyariclename) {
		this.replyariclename = replyariclename;
	}

	public String getReceivername() {
		return receivername;
	}

	public void setReceivername(String receivername) {
		this.receivername = receivername;
	}
	public int getReplyid() {
		return replyid;
	}
	public void setReplyid(int replyid) {
		this.replyid = replyid;
	}
	public int getReplierid() {
		return replierid;
	}
	public void setReplierid(int replierid) {
		this.replierid = replierid;
	}

	public String getReplytype() {
		return replytype;
	}

	public void setReplytype(String replytype) {
		this.replytype = replytype;
	}
	public int getReplyaricleid() {
		return replyaricleid;
	}
	public void setReplyaricleid(int replyaricleid) {
		this.replyaricleid = replyaricleid;
	}
	public int getReceiverid() {
		return receiverid;
	}
	public void setReceiverid(int receiverid) {
		this.receiverid = receiverid;
	}
	public boolean isReplyatste() {
		return replyatste;
	}
	public void setReplyatste(boolean replyatste) {
		this.replyatste = replyatste;
	}
	@Override
	public String toString() {
		return "Reply [replyid=" + replyid + ", replierid=" + replierid + ", replytype=" + replytype
				+ ", replyaricleid=" + replyaricleid + ", receiverid=" + receiverid + ", replyatste=" + replyatste
				+ "]";
	}


}
