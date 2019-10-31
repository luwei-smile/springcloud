package com.community.serviceimp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.community.pojo.Fileload;
import com.community.service.Fileloadingserive;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月23日下午12:32:12
 * 
 * @Todo: 图片文件上传
 */
@Service
public class Fileloadserviceimp implements Fileloadingserive {

	// TODO:图片上传
	public Fileload picload(HttpServletRequest request) {
		MultipartHttpServletRequest multipartrequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartrequest.getFile("editormd-image-file");
		FileOutputStream fileOutputStream = null;
		Fileload fileload = new Fileload();
		int len = (int) file.getSize();
		byte[] b = new byte[len];
		String path = "G:/Java/jdk1.8.0_131/Community/src/main/resources/static";
		String filname = "/images/loading/" + new Date().getTime() + file.getOriginalFilename();
		try {
			fileOutputStream = new FileOutputStream(path + filname);
			file.getInputStream().read(b);
			fileOutputStream.write(b, 0, len);
			fileload.setSuccess(1);
			fileload.setUrl(filname);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fileOutputStream != null)
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return fileload;
	}

}
