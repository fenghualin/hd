package com.huanduguihua.violet.question2.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;

public class Logical extends DefaultBean implements Serializable{

	private static final long serialVersionUID = 378271457327280024L;
	private Integer id;
	private Integer userId;			//user_id
	private Integer questionNo;		//question_no
	private String reactionTime;	//reaction_time
	private Integer studentChoice;	//student_choice
	private Integer rightAnswer;	//正确答案right_anser
	private Integer studentScore;	//student_score
	private Integer isright;//是否正确
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
	public Integer getQuestion_no() {
		return questionNo;
	}
	public void setQuestion_no(Integer question_no) {
		this.questionNo = question_no;
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
	public Integer getRight_anser() {
		return rightAnswer;
	}
	public void setRight_anser(Integer right_anser) {
		this.rightAnswer = right_anser;
	}
	public Integer getStudent_score() {
		return studentScore;
	}
	public void setStudent_score(Integer student_score) {
		this.studentScore = student_score;
	}
	public Integer getIsright() {
		return isright;
	}
	public void setIsright(Integer isright) {
		this.isright = isright;
	}
	@Override
	public String __getMyjdbcTableName() {
		return "test_logical";
	}
}
