package com.huanduguihua.manager.bean;

import java.io.Serializable;

import org.json.JSONObject;

import com.huanduguihua.system.bean.DefaultBean;

public class TestQuestionAnswer2 extends DefaultBean implements Serializable{

	private static final long serialVersionUID = 8612649171360774602L;
	public String __getMyjdbcTableName() {return "test_question_answer2";}
	private Integer id;
	//选项
	private String option_s;
	//选项类容
	private String option_text;
	//题目得分
	private Integer option_score;
	//题目id
	private Integer question_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOption_s() {
		return option_s;
	}
	public void setOption_s(String option_s) {
		this.option_s = option_s;
	}
	public String getOption_text() {
		return option_text;
	}
	public void setOption_text(String option_text) {
		this.option_text = option_text;
	}
	public int getOption_score() {
		return option_score;
	}
	public void setOption_score(Integer option_score) {
		this.option_score = option_score;
	}
	public Integer getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}
	
	public JSONObject toJSONObject() {
		JSONObject json = new JSONObject();
		try {
			json.put("option_text", this.getOption_text());
			json.put("option_score", this.getOption_score());
			json.put("option_s", this.getOption_s());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
}
