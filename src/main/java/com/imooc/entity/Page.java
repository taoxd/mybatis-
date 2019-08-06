package com.imooc.entity;

/**
 * 分页对应的实体类
 */
public class Page {
	/**
	 * 总条数
	 */
	private int totalCount;
	/**
	 * 当前第几页
	 */
	private int pageNo;
	/**
	 * 总页数
	 */
	private int totalPage;
	/**
	 * 每页显示条数
	 */
	private int pageSize = 5;
	/**
	 * 数据库中limit的参数，从第几条开始取
	 */
	private int dbIndex;
	/**
	 * 数据库中limit的参数，一共取多少条
	 */
	private int dbNumber;
	
	/**
	 * 根据当前对象中属性值计算并设置相关属性值
	 */
	public void count() {
		// 计算总页数
		int totalPageTemp = this.totalCount / this.pageSize;
		int plus = (this.totalCount % this.pageSize) == 0 ? 0 : 1;
		totalPageTemp = totalPageTemp + plus;
		if(totalPageTemp <= 0) {
			totalPageTemp = 1;
		}
		this.totalPage = totalPageTemp;
		
		// 设置当前页数
		// 总页数小于当前页数，应将当前页数设置为总页数
		if(this.totalPage < this.pageNo) {
			this.pageNo = this.totalPage;
		}
		// 当前页数小于1设置为1
		if(this.pageNo < 1) {
			this.pageNo = 1;
		}
		
		// 设置limit的参数
		this.dbIndex = (this.pageNo - 1) * this.pageSize;
		this.dbNumber = this.pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.count();
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		this.count();
	}

	public int getDbIndex() {
		return dbIndex;
	}

	public void setDbIndex(int dbIndex) {
		this.dbIndex = dbIndex;
	}

	public int getDbNumber() {
		return dbNumber;
	}

	public void setDbNumber(int dbNumber) {
		this.dbNumber = dbNumber;
	}
}
