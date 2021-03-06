package com.huanduguihua.orange.question2.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;

public class ImageInation extends DefaultBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4417128074153851603L;
	private Integer id;
	private Integer user_id;
	private Integer question_no;
	private String reaction_time;
	private Integer student_choice;
	private Integer question_answer;
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
	public Integer getStudent_choice() {
		return student_choice;
	}
	public void setStudent_choice(Integer student_choice) {
		this.student_choice = student_choice;
	}
	public Integer getQuestion_answer() {
		return question_answer;
	}
	public void setQuestion_answer(Integer question_answer) {
		this.question_answer = question_answer;
	}
	@Override
	public String __getMyjdbcTableName() {
		return "test_imageination";
	}
}
