package com.huanduguihua.violet.question1.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;


public class Induction extends DefaultBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7481641210633726311L;
	private Integer id;
	private Integer userId;	//user_id
	private String reactionTime;	//reaction_time
	private Integer studentChoicea;//student_choicea
	private Integer studentChoiceb;//student_choiceb
	private Integer questionNo;	//question_no
	private Integer studentScore;	//student_score
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return userId;
	}
	public void setUser_id(Integer user_id) {
		this.userId = user_id;
	}
	public String getReaction_time() {
		return reactionTime;
	}
	public void setReaction_time(String reaction_time) {
		this.reactionTime = reaction_time;
	}
	public Integer getStudent_choicea() {
		return studentChoicea;
	}
	public void setStudent_choicea(Integer student_choicea) {
		this.studentChoicea = student_choicea;
	}
	public Integer getStudent_choiceb() {
		return studentChoiceb;
	}
	public void setStudent_choiceb(Integer student_choiceb) {
		this.studentChoiceb = student_choiceb;
	}
	public Integer getQuestion_no() {
		return questionNo;
	}
	public void setQuestion_no(Integer question_no) {
		this.questionNo = question_no;
	}
	public Integer getStudent_score() {
		return studentScore;
	}
	public void setStudent_score(Integer student_score) {
		this.studentScore = student_score;
	}
	@Override
	public String __getMyjdbcTableName() {
		return "test_induction";
	}
}
