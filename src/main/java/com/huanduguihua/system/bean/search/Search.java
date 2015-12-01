/**
 * com.huanduguihua.system.bean.search
 * DefaultSearch.java
 * 
 * 2014-5-12-下午2:41:43
 *  2014成都酷信科技公司-版权所有
 * 
 */
package com.huanduguihua.system.bean.search;

import java.util.List;

import com.huanduguihua.system.bean.DefaultBean;

/**
 * 
 * DefaultSearch
 * 
 * kin
 * kin
 * 2014-5-12 下午2:41:43
 * 
 * @author KangJia
 * @version 1.0.0
 * 
 */
public class Search<E extends DefaultBean> {
	private String query = "";
	private String where = "";
	private String order = "";
	private Integer page = 1;	//搜索页
	/**什么*/
	private Integer pageSize = 10;	//每页数量，默认10
	private Long count = 0L;	//数据总数
	private List<E> datas;		//页面数据
	
	private Integer accountId;
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	/** 如果设置为-1，则会查询出所有的记录 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Integer getPageCount() {
		return (int) ((count-1)/pageSize+1);
	}
	
	public List<E> getDatas() {
		return datas;
	}
	public void setDatas(List<E> datas) {
		this.datas = datas;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getWhere() {
		return where;
	}
	public void setWhere(String where) {
		this.where = where;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
}
