package com.huanduguihua.user.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;

public class JinduisFinish extends DefaultBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8395771853521245346L;
	private Integer id;
	private Integer jinduId;
	private Integer userId;
	private Integer isFinish;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getJinduId() {
		return jinduId;
	}
	public void setJinduId(Integer jinduId) {
		this.jinduId = jinduId;
	}
	public Integer getIsFinish() {
		return isFinish;
	}
	public void setIsFinish(Integer isFinish) {
		this.isFinish = isFinish;
	}
	@Override
	public String __getMyjdbcTableName() {
		return "jinduisfinish";
	}
}
