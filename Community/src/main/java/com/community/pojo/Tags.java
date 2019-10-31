package com.community.pojo;

import org.springframework.stereotype.Repository;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月22日上午9:54:32
 * 
 * @Todo: 标签实体
 */
@Repository
public class Tags {

	private int tagid;
	private String tagtype;
	private String tagname;

	public int getTagid() {
		return tagid;
	}

	public void setTagid(int tagid) {
		this.tagid = tagid;
	}

	public String getTagtype() {
		return tagtype;
	}

	public void setTagtype(String tagtype) {
		this.tagtype = tagtype;
	}

	public String getTagname() {
		return tagname;
	}

	public void setTagname(String tagname) {
		this.tagname = tagname;
	}

	@Override
	public String toString() {
		return "Tags [tagid=" + tagid + ", tagtype=" + tagtype + ", tagname=" + tagname + "]";
	}

}
