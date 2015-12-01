package com.huanduguihua.manager.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;

public class TestQuestionLang extends DefaultBean implements Serializable{
	
	@Override
	public String __getMyjdbcTableName() {return "test_question_lang";}
	
	private static final long serialVersionUID = 4841070841049946743L;
	private Integer id;
	private String question_text;
	private Integer kinds;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getKinds() {
		return kinds;
	}
	public void setKinds(Integer kinds) {
		this.kinds = kinds;
	}
	public String getQuestion_text() {
		return question_text;
	}
	public void setQuestion_text(String question_text) {
		this.question_text = question_text;
	}
}
