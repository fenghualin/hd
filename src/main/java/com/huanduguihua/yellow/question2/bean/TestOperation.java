package com.huanduguihua.yellow.question2.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;

public class TestOperation extends DefaultBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4508622855164711395L;
	
	private Integer id;//'ID主键',
	private Integer test_no;//'测试编号',
	private Integer user_id;//'学员ID',
	private Integer question_no;//'呈现序号'
	private String reaction_time;//'反应时间',
	private Integer step;//'步骤'
	private Boolean is_true;//'是否正确',
	private Integer correct_answer;//正确答案
	private Integer student_answer;//学问回答
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
	public Integer getStep() {
		return step;
	}
	public void setStep(Integer step) {
		this.step = step;
	}
	public Boolean getIs_true() {
		return is_true;
	}
	public void setIs_true(Boolean is_true) {
		this.is_true = is_true;
	}
	public Integer getCorrect_answer() {
		return correct_answer;
	}
	public void setCorrect_answer(Integer correct_answer) {
		this.correct_answer = correct_answer;
	}
	public Integer getStudent_answer() {
		return student_answer;
	}
	public void setStudent_answer(Integer student_answer) {
		this.student_answer = student_answer;
	}
	@Override
	public String __getMyjdbcTableName() {
		return "test_operation";
	}
}
