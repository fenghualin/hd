package com.huanduguihua.gray.question3.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;


public class Personality extends DefaultBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2162313322057416274L;
	private Integer id;
	private Integer questionNo;	//question_no
	private Integer userId;		//user_id
	private String reactionTime;	//reaction_time
	private Integer studentChoice;	//student_choice不要使用下划线，单词与单词之间使用首字母大写的形式表示
	private Integer imglength;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQuestion_no() {
		return questionNo;
	}
	public void setQuestion_no(Integer question_no) {
		this.questionNo = question_no;
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
	public Integer getStudent_choice() {
		return studentChoice;
	}
	public void setStudent_choice(Integer student_choice) {
		this.studentChoice = student_choice;
	}
	public Integer getImglength() {
		return imglength;
	}
	public void setImglength(Integer imglength) {
		this.imglength = imglength;
	}
	@Override
	public String __getMyjdbcTableName() {
		return "test_personality";
	}
}
