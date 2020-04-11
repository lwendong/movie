package com.movie.pojo;

public class PageInfo {
	
	private Integer pageNo;
	private Integer pageSize;
	
	public PageInfo(Integer pageNo,Integer pageSize) {
		this.pageSize = pageSize;
		if (pageNo == null || pageNo.equals(0)) {
			this.pageNo = 0;
		}else {
			this.pageNo = (pageNo - 1) * this.pageSize;
		}
		
	}
	
	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
