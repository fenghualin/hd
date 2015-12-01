package com.huanduguihua.green.question3.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;

public class TestOperationb extends DefaultBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2868348112442957894L;
	public String __getMyjdbcTableName() {return "test_operationb";}
	private Integer id;//'ID主键',
	private Integer test_no;//'测试编号',
	private Integer user_id;//'学员ID',
	private Integer question_no;//呈现序号
	private String reaction_time;//反应时间
	private String student_choice;//学员选择
	private Integer student_score;//学员得分
	private Integer subject_no;//题目编号
	private Integer kinds;
	public Integer getKinds() {
		return kinds;
	}
	public void setKinds(Integer kinds) {
		this.kinds = kinds;
	}
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
	public String getStudent_choice() {
		return student_choice;
	}
	public void setStudent_choice(String student_choice) {
		this.student_choice = student_choice;
	}
	public Integer getStudent_score() {
		return student_score;
	}
	public void setStudent_score(Integer student_score) {
		this.student_score = student_score;
	}
	public Integer getSubject_no() {
		return subject_no;
	}
	public void setSubject_no(Integer subject_no) {
		this.subject_no = subject_no;
	}
}
