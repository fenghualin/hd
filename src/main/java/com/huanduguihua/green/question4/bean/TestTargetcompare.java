package com.huanduguihua.green.question4.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;

public class TestTargetcompare extends DefaultBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1354371013167325505L;
	public String __getMyjdbcTableName() {return "test_targetcompare";}
	private Integer id;
	private Integer user_id;
	private Integer testNo;
	private String reactionTime;
	private Integer success_click;
	private Integer fail_click;
	private String zuobiao;
	private String is_true;
	public String getIs_true() {
		return is_true;
	}
	public void setIs_true(String is_true) {
		this.is_true = is_true;
	}
	public String getZuobiao() {
		return zuobiao;
	}
	public void setZuobiao(String zuobiao) {
		this.zuobiao = zuobiao;
	}
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
	public Integer getTestNo() {
		return testNo;
	}
	public void setTestNo(Integer testNo) {
		this.testNo = testNo;
	}
	public String getReactionTime() {
		return reactionTime;
	}
	public void setReactionTime(String reactionTime) {
		this.reactionTime = reactionTime;
	}
	public Integer getSuccess_click() {
		return success_click;
	}
	public void setSuccess_click(Integer success_click) {
		this.success_click = success_click;
	}
	public Integer getFail_click() {
		return fail_click;
	}
	public void setFail_click(Integer fail_click) {
		this.fail_click = fail_click;
	}
	@Override
	public String toString() {
		return "TestTargetcompare [id=" + id + ", user_id=" + user_id
				+ ", testNo=" + testNo + ", reaction_time=" + reactionTime
				+ ", success_click=" + success_click + ", fail_click="
				+ fail_click + ", zuobiao=" + zuobiao + ", is_true=" + is_true
				+ "]";
	}
}
