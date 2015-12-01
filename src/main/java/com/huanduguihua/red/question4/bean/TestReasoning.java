package com.huanduguihua.red.question4.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;

public class TestReasoning extends DefaultBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6039250796241782925L;
	private Integer id;
	private Integer user_id;
	private Integer test_no;
	private String reaction_time;
	private Integer question_no;
	private Integer student_choicea;
	private Integer student_choiceb;
	private Integer student_choicec;
	private Integer student_score;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getTest_no() {
		return test_no;
	}
	public void setTest_no(Integer test_no) {
		this.test_no = test_no;
	}
	public String getReaction_time() {
		return reaction_time;
	}
	public void setReaction_time(String reaction_time) {
		this.reaction_time = reaction_time;
	}
	public Integer getQuestion_no() {
		return question_no;
	}
	public void setQuestion_no(Integer question_no) {
		this.question_no = question_no;
	}
	public Integer getStudent_choicea() {
		return student_choicea;
	}
	public void setStudent_choicea(Integer student_choicea) {
		this.student_choicea = student_choicea;
	}
	public Integer getStudent_choiceb() {
		return student_choiceb;
	}
	public void setStudent_choiceb(Integer student_choiceb) {
		this.student_choiceb = student_choiceb;
	}
	public Integer getStudent_choicec() {
		return student_choicec;
	}
	public void setStudent_choicec(Integer student_choicec) {
		this.student_choicec = student_choicec;
	}
	public Integer getStudent_score() {
		return student_score;
	}
	public void setStudent_score(Integer student_score) {
		this.student_score = student_score;
	}
	@Override
	public String __getMyjdbcTableName() {
		// TODO Auto-generated method stub
		return "test_reasoning";
	}
}
