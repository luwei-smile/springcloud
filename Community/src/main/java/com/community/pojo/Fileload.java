package com.community.pojo;

import org.springframework.stereotype.Repository;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月23日上午9:10:25
 * 
 * @Todo: 图片上传
 */
@Repository
public class Fileload {

	private int success;
	private String message;
	private String url;

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
