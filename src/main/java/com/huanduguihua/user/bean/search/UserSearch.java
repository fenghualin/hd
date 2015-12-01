//======================================================================
//
//        Copyright (C) 2013-2014 成都酷信科技有限公司
//        All rights reserved
//
//        文件名 ：com.huanduguihua.user.bean.search.UserSearch.java
//
//        创建时间：2014-5-16-下午4:23:54
//		      作者：康佳
//        http://www.cdkuxin.com
//
//======================================================================
package com.huanduguihua.user.bean.search;

import com.huanduguihua.system.bean.search.Search;

/**
 * 名称：
 * 功能：
 * 
 * @author 康佳
 * @version 1.0.0
 * 
 */
public class UserSearch extends Search {
	private Integer queryValue;
	private String searchval;
	private String searchkey;
	public String getSearchval() {
		return searchval;
	}

	public void setSearchval(String searchval) {
		this.searchval = searchval;
	}

	public String getSearchkey() {
		return searchkey;
	}

	public void setSearchkey(String searchkey) {
		this.searchkey = searchkey;
	}

	public Integer getQueryValue() {
		return queryValue;
	}

	public void setQueryValue(Integer queryValue) {
		this.queryValue = queryValue;
	}

}
