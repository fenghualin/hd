package com.huanduguihua.gray.question4.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;

public class Rgtstbean extends DefaultBean implements Serializable{
	private static final long serialVersionUID = -1166042250246310673L;
	private Integer id;
	private String content;
	private Integer userId;
	private String beizhu;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	@Override
	public String __getMyjdbcTableName() {
		return "test_rgtst";
	}
}
