package com.community.pojo;

import org.springframework.stereotype.Repository;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月10日下午1:19:34
 * 
 * @Todo: 用户实体
 */
@Repository
public class Reader {

	private Integer id;
	private String name = "1";
	private String mobile;
	private String psd;
	private String protrait;

	public String getProtrait() {
		return protrait;
	}

	public void setProtrait(String protrait) {
		this.protrait = protrait;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}

	@Override
	public String toString() {
		return "Reader [id=" + id + ", name=" + name + ", mobile=" + mobile + ", psd=" + psd + ", protrait=" + protrait
				+ "]";
	}


}
