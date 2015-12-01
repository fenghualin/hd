package com.huanduguihua.blue.question_3.bean;

import java.io.Serializable;

import com.huanduguihua.system.bean.DefaultBean;

public class LoopTest extends DefaultBean implements Serializable {
	private static final long serialVersionUID = 2340915801063995065L;

	private Integer id;
	private Integer testNo;
	private Integer userId;
	private Integer questionNo;
	private String reactionTime;
	private Integer reactionChoice;
	private String range;
	private String accuracy;
	private String correctAnswer;
	private String studentAnswer;
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
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public String getStudentAnswer() {
		return studentAnswer;
	}
	public void setStudentAnswer(String studentAnswer) {
		this.studentAnswer = studentAnswer;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accuracy == null) ? 0 : accuracy.hashCode());
		result = prime * result
				+ ((correctAnswer == null) ? 0 : correctAnswer.hashCode());
		result = prime * result
				+ ((questionNo == null) ? 0 : questionNo.hashCode());
		result = prime * result + ((range == null) ? 0 : range.hashCode());
		result = prime * result
				+ ((reactionChoice == null) ? 0 : reactionChoice.hashCode());
		result = prime * result
				+ ((reactionTime == null) ? 0 : reactionTime.hashCode());
		result = prime * result
				+ ((studentAnswer == null) ? 0 : studentAnswer.hashCode());
		result = prime * result + ((testNo == null) ? 0 : testNo.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		LoopTest other = (LoopTest) obj;
		if (accuracy == null) {
			if (other.accuracy != null)
				return false;
		} else if (!accuracy.equals(other.accuracy))
			return false;
		if (correctAnswer == null) {
			if (other.correctAnswer != null)
				return false;
		} else if (!correctAnswer.equals(other.correctAnswer))
			return false;
		if (questionNo == null) {
			if (other.questionNo != null)
				return false;
		} else if (!questionNo.equals(other.questionNo))
			return false;
		if (range == null) {
			if (other.range != null)
				return false;
		} else if (!range.equals(other.range))
			return false;
		if (reactionChoice == null) {
			if (other.reactionChoice != null)
				return false;
		} else if (!reactionChoice.equals(other.reactionChoice))
			return false;
		if (reactionTime == null) {
			if (other.reactionTime != null)
				return false;
		} else if (!reactionTime.equals(other.reactionTime))
			return false;
		if (studentAnswer == null) {
			if (other.studentAnswer != null)
				return false;
		} else if (!studentAnswer.equals(other.studentAnswer))
			return false;
		if (testNo == null) {
			if (other.testNo != null)
				return false;
		} else if (!testNo.equals(other.testNo))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LoopTest [testNo=" + testNo + ", userId=" + userId
				+ ", questionNo=" + questionNo + ", reactionTime="
				+ reactionTime + ", reactionChoice=" + reactionChoice
				+ ", range=" + range + ", accuracy=" + accuracy
				+ ", correctAnswer=" + correctAnswer + ", studentAnswer="
				+ studentAnswer + "]";
	}
	@Override
	public String __getMyjdbcTableName() {
		return "test_loop";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
