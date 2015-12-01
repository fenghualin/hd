package com.huanduguihua.green.question5.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;

public class TestPintu extends DefaultBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 364829446598450940L;
	public String __getMyjdbcTableName() {return "test_pintu";}
	private Integer id;
	private Integer user_id;
	private Integer test_no;
	private String reaction_time;
	private Integer question_no;
	private Integer sum_step;
	private String start_think;
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
	public Integer getSum_step() {
		return sum_step;
	}
	public void setSum_step(Integer sum_step) {
		this.sum_step = sum_step;
	}
	public String getStart_think() {
		return start_think;
	}
	public void setStart_think(String start_think) {
		this.start_think = start_think;
	}
	public Integer getStudent_score() {
		return student_score;
	}
	public void setStudent_score(Integer student_score) {
		this.student_score = student_score;
	}
}
