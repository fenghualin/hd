package com.huanduguihua.manager.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;

public class TestQuestionLang2 extends DefaultBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6825866007604189848L;
	@Override
	public String __getMyjdbcTableName() {return "test_question_lang2";}
	
	private Integer id;
	private String question_text;
	private Integer kinds;
	private Integer inverted;
	private Integer order;
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
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
	public Integer getInverted() {
		return inverted;
	}
	public void setInverted(Integer inverted) {
		this.inverted = inverted;
	}
}
