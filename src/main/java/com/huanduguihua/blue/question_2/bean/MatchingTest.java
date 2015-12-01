package com.huanduguihua.blue.question_2.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;

public class MatchingTest extends DefaultBean implements Serializable{
	private static final long serialVersionUID = -3239697177037225521L;

	private Integer id;
	private Integer testNo;
	private Integer userId;
	private Integer questionNo;
	private String reactionTime;
	private Integer reactionChoice;
	private Integer delay;
	private Boolean isTrue;
	private Integer position;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTestNo() {
		return testNo;
	}
	public void setTestNo(Integer testNo) {
		this.testNo = testNo;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(Integer questionNo) {
		this.questionNo = questionNo;
	}
	public String getReactionTime() {
		return reactionTime;
	}
	public void setReactionTime(String reactionTime) {
		this.reactionTime = reactionTime;
	}
	public Integer getReactionChoice() {
		return reactionChoice;
	}
	public void setReactionChoice(Integer reactionChoice) {
		this.reactionChoice = reactionChoice;
	}
	public Integer getDelay() {
		return delay;
	}
	public void setDelay(Integer delay) {
		this.delay = delay;
	}
	public Boolean getIsTrue() {
		return isTrue;
	}
	public void setIsTrue(Boolean isTrue) {
		this.isTrue = isTrue;
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
		result = prime * result + (isTrue ? 1231 : 1237);
		result = prime * result + position;
		result = prime * result + questionNo;
		result = prime * result + reactionChoice;
		result = prime * result
				+ ((reactionTime == null) ? 0 : reactionTime.hashCode());
		result = prime * result + testNo;
		result = prime * result + userId;
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
		MatchingTest other = (MatchingTest) obj;
		if (delay != other.delay)
			return false;
		if (id != other.id)
			return false;
		if (isTrue != other.isTrue)
			return false;
		if (position != other.position)
			return false;
		if (questionNo != other.questionNo)
			return false;
		if (reactionChoice != other.reactionChoice)
			return false;
		if (reactionTime == null) {
			if (other.reactionTime != null)
				return false;
		} else if (!reactionTime.equals(other.reactionTime))
			return false;
		if (testNo != other.testNo)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MatchingTest [id=" + id + ", testNo=" + testNo + ", userId="
				+ userId + ", questionNo=" + questionNo + ", reactionTime="
				+ reactionTime + ", reactionChoice=" + reactionChoice
				+ ", delay=" + delay + ", isTrue=" + isTrue + ", position="
				+ position + "]";
	}
	@Override
	public String __getMyjdbcTableName() {
		return "test_macthing";
	}
}
