package com.huanduguihua.manager.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;

public class Jigou extends DefaultBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7495693445394820524L;
	private Integer id;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	private String describe;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String __getMyjdbcTableName() {
		return "jigou";
	}
	
}
