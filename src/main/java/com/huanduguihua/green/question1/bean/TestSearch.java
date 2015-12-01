package com.huanduguihua.green.question1.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;

public class TestSearch extends DefaultBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 280278402674309788L;
	public String __getMyjdbcTableName() {return "test_search";}
	private Integer id;
	private Integer test_no;
	private Integer user_id;
	private String reaction_time;
	private Integer student_choice;
	private Integer student_score;
	private Integer question_no;
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
	public String getReaction_time() {
		return reaction_time;
	}
	public void setReaction_time(String reaction_time) {
		this.reaction_time = reaction_time;
	}
	public Integer getStudent_choice() {
		return student_choice;
	}
	public void setStudent_choice(Integer student_choice) {
		this.student_choice = student_choice;
	}
	public Integer getStudent_score() {
		return student_score;
	}
	public void setStudent_score(Integer student_score) {
		this.student_score = student_score;
	}
	public Integer getQuestion_no() {
		return question_no;
	}
	public void setQuestion_no(Integer question_no) {
		this.question_no = question_no;
	}
	
}
