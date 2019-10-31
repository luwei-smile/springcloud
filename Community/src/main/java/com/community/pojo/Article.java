package com.community.pojo;

import org.springframework.stereotype.Repository;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月9日下午8:42:45
 * 
 * @Todo: 文章实体
 */
@Repository
public class Article {

	private Integer id;
	private String title;
	private String description;
	private String tag;
	private long gmt_creat;
	private long gmt_modified;
	private String creator;
	private Reader reader;
	private Integer viewcount;
	private Integer commentcount;
	private Integer likecount;
	private String create_time;

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public long getGmt_creat() {
		return gmt_creat;
	}

	public void setGmt_creat(long gmt_creat) {
		this.gmt_creat = gmt_creat;
	}

	public long getGmt_modified() {
		return gmt_modified;
	}

	public void setGmt_modified(long gmt_modified) {
		this.gmt_modified = gmt_modified;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public Integer getViewcount() {
		return viewcount;
	}

	public void setViewcount(Integer viewcount) {
		this.viewcount = viewcount;
	}

	public Integer getCommentcount() {
		return commentcount;
	}

	public void setCommentcount(Integer commentcount) {
		this.commentcount = commentcount;
	}

	public Integer getLikecount() {
		return likecount;
	}

	public void setLikecount(Integer likecount) {
		this.likecount = likecount;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", description=" + description + ", tag=" + tag
				+ ", gmt_creat=" + gmt_creat + ", gmt_modified=" + gmt_modified + ", creator=" + creator
				+ ", viewcount=" + viewcount + ", commentcount=" + commentcount + ", likecount=" + likecount
				+ ", create_time=" + create_time + "]";
	}


}
