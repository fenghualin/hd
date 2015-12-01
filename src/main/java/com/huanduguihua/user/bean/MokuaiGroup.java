package com.huanduguihua.user.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;

public class MokuaiGroup extends DefaultBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1710634821718957290L;
	private Integer id;
	private Integer mokuaiId;
	private Integer groupId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMokuaiId() {
		return mokuaiId;
	}
	public void setMokuaiId(Integer mokuaiId) {
		this.mokuaiId = mokuaiId;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	@Override
	public String __getMyjdbcTableName() {
		return "mokuaigroup";
	}
}
