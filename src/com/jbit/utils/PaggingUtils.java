package com.jbit.utils;

/**
 * 分页组件
 * @author Administrator
 *
 */
public class PaggingUtils {
	private int currentPageNo=1; //页码
	private int pageSize=5; //每页条数
	private int totalPageCount; //总页数
	private int totalCount; //总条数
	
	/**
	 * 初始化分页组件
	 * @param totalCount
	 */
	public void initPagging(int totalCount){
		this.totalCount=totalCount;
		
		//计算总页数
		this.totalPageCount=this.totalCount%this.pageSize==0?(this.totalCount/this.pageSize):(this.totalCount/this.pageSize)+1;
		
		//临界值处理
		if(currentPageNo>totalPageCount){
			currentPageNo=totalPageCount;
		}
		
		if(currentPageNo<1){
			currentPageNo=1;
		}
		
	}
	
	public int startPage(){
		return (currentPageNo-1)*pageSize;
	}
	
	public int endPage(){
		return pageSize;
	}
	
	
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	
	
	
}
