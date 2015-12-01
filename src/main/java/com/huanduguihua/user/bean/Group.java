package com.huanduguihua.user.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;

public class Group extends DefaultBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5384311259913057205L;
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String __getMyjdbcTableName() {
		return "group";
	}
	
}
