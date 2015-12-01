package com.huanduguihua.red.question2.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;

public class TestThinking extends DefaultBean implements Serializable{

	/**
	 * 思维转换
	 */
	private static final long serialVersionUID = -3419398024929749418L;
	private Integer id;
	private Integer test_no;
	private Integer user_id;
	private Integer question_no;
	private String reaction_time;
	private Integer reaction_chioce;
	private String delay;
	private Integer is_true;
	private Integer type;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTest_no() {
		return test_no;
	}
	public void setTest_no(Integer test_no) {
		this.test_no = test_no;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getQuestion_no() {
		return question_no;
	}
	public void setQuestion_no(Integer question_no) {
		this.question_no = question_no;
	}
	public String getReaction_time() {
		return reaction_time;
	}
	public void setReaction_time(String reaction_time) {
		this.reaction_time = reaction_time;
	}
	public Integer getReaction_chioce() {
		return reaction_chioce;
	}
	public void setReaction_chioce(Integer reaction_chioce) {
		this.reaction_chioce = reaction_chioce;
	}
	public String getDelay() {
		return delay;
	}
	public void setDelay(String delay) {
		this.delay = delay;
	}
	public Integer getIs_true() {
		return is_true;
	}
	public void setIs_true(Integer is_true) {
		this.is_true = is_true;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@Override
	public String __getMyjdbcTableName() {
		return "test_thinking";
	}
}
