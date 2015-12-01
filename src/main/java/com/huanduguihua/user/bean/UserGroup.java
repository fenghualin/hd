package com.huanduguihua.user.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;

public class UserGroup extends DefaultBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -247884349219273507L;
	private Integer id;
	private Integer userId;
	private Integer groupId;
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
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	@Override
	public String __getMyjdbcTableName() {
		// TODO Auto-generated method stub
		return "usergroup";
	}
}
