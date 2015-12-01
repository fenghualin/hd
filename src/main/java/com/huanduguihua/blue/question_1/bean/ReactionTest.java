package com.huanduguihua.blue.question_1.bean;

import java.io.Serializable;
import java.util.Date;

import com.huanduguihua.system.bean.DefaultBean;

public class ReactionTest extends DefaultBean implements Serializable{
	private static final long serialVersionUID = 4522460087269578390L;
	
	private Integer id;//'ID主键',
	private Integer test_no;//'测试编号',
	private Integer user_id;//'学员ID',
	private Integer question_no;//'呈现序号',
	private String reaction_time;//'反应时间',
	private Integer reaction_choice;// '学员选择',
	private Integer delay;//'延时',
	private Boolean is_true;//'是否正确',
	private Integer position;//位置
	
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
	public Integer getReaction_choice() {
		return reaction_choice;
	}
	public void setReaction_choice(Integer reaction_choice) {
		this.reaction_choice = reaction_choice;
	}
	public Integer getDelay() {
		return delay;
	}
	public void setDelay(Integer delay) {
		this.delay = delay;
	}
	public Boolean getIs_true() {
		return is_true;
	}
	public void setIs_true(Boolean is_true) {
		this.is_true = is_true;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + delay;
		result = prime * result + id;
		result = prime * result + (is_true ? 1231 : 1237);
		result = prime * result + position;
		result = prime * result + question_no;
		result = prime * result + reaction_choice;
		result = prime * result
				+ ((reaction_time == null) ? 0 : reaction_time.hashCode());
		result = prime * result + test_no;
		result = prime * result + user_id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReactionTest other = (ReactionTest) obj;
		if (delay != other.delay)
			return false;
		if (id != other.id)
			return false;
		if (is_true != other.is_true)
			return false;
		if (position != other.position)
			return false;
		if (question_no != other.question_no)
			return false;
		if (reaction_choice != other.reaction_choice)
			return false;
		if (reaction_time == null) {
			if (other.reaction_time != null)
				return false;
		} else if (!reaction_time.equals(other.reaction_time))
			return false;
		if (test_no != other.test_no)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ReactionTest [id=" + id + ", test_no=" + test_no + ", user_id="
				+ user_id + ", question_no=" + question_no + ", reaction_time="
				+ reaction_time + ", reaction_choice=" + reaction_choice
				+ ", delay=" + delay + ", is_true=" + is_true + ", position="
				+ position + "]";
	}
	@Override
	public String __getMyjdbcTableName() {
		return "test_reaction";
	}
}
