package com.community.serviceimp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.mapper.Articlemapperdetail;
import com.community.pojo.Article;
import com.community.service.Articleservicedetail;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月15日下午8:37:28
 * 
 * @Todo: 文章细节修改
 */
@Service
public class Articleservicedetail_imp implements Articleservicedetail {

	@Autowired
	Articlemapperdetail articlemapperdetail;

	// TODO:修改浏览次数
	public void viewcount(Integer id) {
		articlemapperdetail.viewcount(id);

	}

	// TODO:根据标签进行相关文章推荐
	public List<Article> RecommendBytag(String tags, int articleid) {
		List<Article> listpage = new ArrayList<Article>();
		String[] split = tags.split(",");
		for (String tag : split) {
			listpage.addAll(articlemapperdetail.Recommendarticle("%" + tag + "%", articleid));

			// 每次都推荐最多10篇文章,标记文章个数
			if (listpage.size() > 10)
				break;
		}
		if (listpage.size() < 10)
			return listpage;
		return listpage.subList(0, 10);
	}

	// TODO:根据文章id查询文章名字
	public String getnameByarticleid(int articleid) {
		return articlemapperdetail.getnameByarticleid(articleid);
	}

}
