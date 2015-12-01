package com.huanduguihua.user.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;

public class MokuaiJinduisFinish extends DefaultBean implements Serializable{
	private static final long serialVersionUID = 2102465263466345431L;
	private Integer id;
	private Integer jinduId;
	private Integer userId;
	private Integer isFinish;
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getIsFinish() {
		return isFinish;
	}
	public void setIsFinish(Integer isFinish) {
		this.isFinish = isFinish;
	}
	@Override
	public String __getMyjdbcTableName() {
		return "mokuaijinduisfinish";
	}
}
