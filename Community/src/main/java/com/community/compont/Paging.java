package com.community.compont;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月11日下午7:42:39
 * 
 * @Todo: 实现分页
 */
public class Paging {
	private int total; // 总记录数。
	private int limit = 10; // 每页显示记录数。
	private int pages; // 总页数。
	private int pageNumber = 1; // 当前页。
     
	private boolean hasPreviousPage;
	private boolean hasNextPage;

	private int navigatePages = 7; // 导航页码数,默认显示页数
	private List<Integer> pagelist = new ArrayList<Integer>();// 所有导航页号。

	public Paging(int total, int pageNumber) {
		this.total = total;
		this.pageNumber = pageNumber;
		this.pages = (total + limit - 1) / limit;
	}

	public Paging(int total) {
		this.total = total;
		this.pages = (total + limit - 1) / limit;
	}

	// 所有导航页号。
	public List<Integer> getPagelist() {
		int index;
		// 总页数小于等于显示页数,全部显示页码。
		// 否者根据显示页数和当前页来填入导航页号。
		if (pages <= navigatePages) {
			index = 1;
			while (pages != 0) {
				pagelist.add(index++);
				pages--;
			}
			return pagelist;
		} else {
			// 当前页小于显示总页数,导航页号为“1~显示页数”
			if (pageNumber < navigatePages) {
				for (int i = 1; i <= navigatePages; i++) {
					pagelist.add(i);
				}
				return pagelist;
			}

			// 当前页大于显示“总页数-显示页数”,导航页号为“1~显示页数”
			if (pageNumber >= pages - navigatePages + 1) {
				for (int i = pages - navigatePages + 1; i <= pages; i++) {
					pagelist.add(i);
				}
				return pagelist;
			}
			double key = (double) navigatePages / 2;
			for (int i = (int) -key; i < key; i++) {
				pagelist.add(pageNumber + i);
			}
			return pagelist;
		}
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPages() {
		return (total + limit) / limit;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	// 是否有前一页
	public boolean isHasPreviousPage() {
		if (pages <= navigatePages) {
			return hasPreviousPage;
		}

		if (pageNumber <= 4) {
			return hasPreviousPage;
		}
		return !hasPreviousPage;
	}

	// 是否有下一页
	public boolean isHasNextPage() {
		if (pages <= navigatePages) {
			return hasNextPage;
		}

		if (pageNumber <= total - 4) {
			return hasNextPage;
		}
		return !hasNextPage;
	}

	public int getNavigatePages() {
		return navigatePages;
	}

	public void setNavigatePages(int navigatePages) {
		this.navigatePages = navigatePages;
	}

}