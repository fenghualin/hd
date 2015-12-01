package com.huanduguihua.yellow.question4.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;

public class TestMaze extends DefaultBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4469438563247047964L;
	public String __getMyjdbcTableName() {return "test_maze";}
	private Integer id;//'ID主键',
	private Integer test_no;//'测试编号',
	private Integer user_id;//'学员ID',
	private String reaction_time;//'反应时间',
	private Integer wall_number;//碰壁次数
	private Integer blindness_number;//盲区次数
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
	public Integer getWall_number() {
		return wall_number;
	}
	public void setWall_number(Integer wall_number) {
		this.wall_number = wall_number;
	}
	public Integer getBlindness_number() {
		return blindness_number;
	}
	public void setBlindness_number(Integer blindness_number) {
		this.blindness_number = blindness_number;
	}
	
}
