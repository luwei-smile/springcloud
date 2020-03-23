package com.microserivers.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Auther 卢伟
 * 
 * @Time 2020年3月16日上午11:22:21
 * 
 * @Todo: TODO
 */
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Tag {

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



}
