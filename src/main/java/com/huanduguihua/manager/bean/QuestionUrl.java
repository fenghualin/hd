package com.huanduguihua.manager.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;

public class QuestionUrl extends DefaultBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4617462267327988823L;
	private Integer id;
	private String questionurl;
	private String val;
	private String tablename;
	
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getQuestionurl() {
		return questionurl;
	}
	public void setQuestionurl(String questionurl) {
		this.questionurl = questionurl;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	@Override
	public String __getMyjdbcTableName() {
		return "questionurl";
	}
}
