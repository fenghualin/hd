package com.huanduguihua.user.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;

public class UserMokuai extends DefaultBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4662342452768746179L;
	private Integer id;
	private Integer userId;
	private Integer mokuaiId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getMokuaiId() {
		return mokuaiId;
	}
	public void setMokuaiId(Integer mokuaiId) {
		this.mokuaiId = mokuaiId;
	}
	@Override
	public String __getMyjdbcTableName() {
		return "usermokuai";
	}
	
}
