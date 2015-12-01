package com.huanduguihua.red.question1.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;

public class TestAppearance extends DefaultBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4215822766421111413L;
	private Integer id;
	private Integer test_no;
	private Integer user_id;
	private Integer question_no;
	private String reaction_time;
	private Integer reaction_chioce;
	private String delay;
	private Integer is_true;
	private Integer type;
	private Integer structure;
	private Integer angle;
	private Integer classification;
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStructure() {
		return structure;
	}
	public void setStructure(Integer structure) {
		this.structure = structure;
	}
	public Integer getIs_true() {
		return is_true;
	}
	public void setIs_true(Integer is_true) {
		this.is_true = is_true;
	}
	public Integer getAngle() {
		return angle;
	}
	public void setAngle(Integer angle) {
		this.angle = angle;
	}
	public Integer getClassification() {
		return classification;
	}
	public void setClassification(Integer classification) {
		this.classification = classification;
	}
	@Override
	public String __getMyjdbcTableName() {
		return "test_appearance";
	}
	
}
