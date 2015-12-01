<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style type="text/css">
.student_defenqk table{
	width:700px;
}
.student_defenqk table tr td{
	text-align: center;
}
</style>
<div class="student_defenqk">
<table>
	<c:if test="${qunumber==1}">
		<tr>
			<td>程显序号</td><td>学员选择</td><td>时间</td><td>延时</td><td>位置</td><td>得分</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.reaction_choice }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.delay }</td>
			<td>${questionlist.position }</td>
			<td><c:if test="${questionlist.is_true == true}">1</c:if><c:if test="${questionlist.is_true == false}">0</c:if></td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==2}">
		<tr>
			<td>程显序号</td><td>学员选择</td><td>时间</td><td>延时</td><td>位置</td><td>得分</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.questionNo }</td>
			<td>${questionlist.reactionChoice }</td>
			<td>${questionlist.reactionTime}</td>
			<td>${questionlist.delay }</td>
			<td>${questionlist.position }</td>
			<td><c:if test="${questionlist.isTrue == true}">1</c:if><c:if test="${questionlist.isTrue == false}">0</c:if></td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==3}">
		<tr>
			<td>程显序号</td><td>学员选择</td><td>时间</td><td>广度</td><td>正确率</td><td>正确答案</td><td>学生回答</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.questionNo }</td>
			<td>${questionlist.reactionChoice }</td>
			<td>${questionlist.reactionTime}</td>
			<td>${questionlist.range }</td>
			<td>${questionlist.accuracy }</td>
			<td>${questionlist.correctAnswer }</td>
			<td>${questionlist.studentAnswer }</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==4}">
		<tr>
			<td>程显序号</td><td>学员选择</td><td>时间</td><td>广度</td><td>正确率</td><td>正确答案</td><td>学生回答</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.questionNo }</td>
			<td>${questionlist.reactionChoice }</td>
			<td>${questionlist.reactionTime}</td>
			<td>${questionlist.range }</td>
			<td>${questionlist.accuracy }</td>
			<td>${questionlist.correctAnswer }</td>
			<td>${questionlist.studentAnswer }</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==5}">
		<tr>
			<td>程显序号</td><td>学员选择</td><td>时间</td><td>广度</td><td>正确率</td><td>正确答案</td><td>学生回答</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.questionNo }</td>
			<td>${questionlist.reactionChioce }</td>
			<td>${questionlist.reactionTime}</td>
			<td>${questionlist.range }</td>
			<td>${questionlist.accuracy }</td>
			<td>${questionlist.correctAnswer }</td>
			<td>${questionlist.studentAnswer }</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==6}">
		<tr>
			<td>程显序号</td><td>学员选择</td><td>时间</td><td>是否正确</td><td>正确答案</td><td>学生回答</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.reaction_choice }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.is_true }</td>
			<td>${questionlist.correct_answer }</td>
			<td>${questionlist.student_answer }</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==7}">
		<tr>
			<td>程显序号</td><td>时间</td><td>步骤</td><td>是否正确</td><td>正确答案</td><td>学生回答</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.step}</td>
			<td>${questionlist.is_true }</td>
			<td>${questionlist.correct_answer }</td>
			<td>${questionlist.student_answer }</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==8}">
		<tr>
			<td>程显序号</td><td>时间</td><td>题目编号</td><td>学生选择</td><td>学员得分</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.subject_no }</td>
			<td>${questionlist.student_choice }</td>
			<td>${questionlist.student_score }</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==9}">
		<tr>
			<td>时间</td><td>碰壁次数</td><td>忙去次数</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.reaction_time }</td>
			<td>${questionlist.wall_number}</td>
			<td>${questionlist.blindness_number }</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==10}">
		<tr>
			<td>程显序号</td><td>时间</td><td>学生选择</td><td>学员得分</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.student_choice }</td>
			<td>${questionlist.student_score }</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==11}">
		<tr>
			<td>程显序号</td><td>时间</td><td>成功点击</td><td>错误点击</td><td>坐标</td><td>是否正确</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.testNo }</td>
			<td>${questionlist.reactionTime}</td>
			<td>${questionlist.success_click }</td>
			<td>${questionlist.fail_click }</td>
			<td>${questionlist.zuobiao }</td>
			<td>${questionlist.is_true }</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==12}">
		<tr>
			<td>程显序号</td><td>时间</td><td>总步数</td><td>思考时间</td><td>得分</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.sum_step }</td>
			<td>${questionlist.start_think }</td>
			<td>${questionlist.student_score }</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==13}">
		<tr>
			<td>程显序号</td><td>时间</td><td>题目编号</td><td>学生选择</td><td>学员得分</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.subject_no }</td>
			<td>${questionlist.student_choice }</td>
			<td>${questionlist.student_score }</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==14}">
		<tr>
			<td>程显序号</td><td>时间</td><td>题目编号</td><td>学生选择</td><td>学员得分</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.test_no }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.student_choice }</td>
			<td>${questionlist.student_score }</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==15}">
		<tr>
			<td>程显序号</td><td>时间</td><td>总步数</td><td>思考时间</td><td>得分</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.sum_step }</td>
			<td>${questionlist.start_think }</td>
			<td>${questionlist.student_score}</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==16}">
		<tr>
			<td>程显序号</td><td>时间</td><td>A选项</td><td>B选项</td><td>C选项</td><td>得分</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.student_choicea}</td>
			<td>${questionlist.student_choiceb}</td>
			<td>${questionlist.student_choicec}</td>
			<td>${questionlist.student_score}</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==17}">
		<tr>
			<td>程显序号</td><td>时间</td><td>学生选择</td><td>延时</td><td>类型</td><td>结构顺序</td><td>旋转角度</td><td>沃分类</td><td>是否正确</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.reaction_chioce}</td>
			<td>${questionlist.delay}</td>
			<td>${questionlist.type}</td>
			<td>${questionlist.structure}</td>
			<td>${questionlist.angle}</td>
			<td>${questionlist.classification}</td>
			<td>${questionlist.is_true }</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==18}">
		<tr>
			<td>程显序号</td><td>时间</td><td>学生选择</td><td>延时</td><td>是否正确</td><td>类型</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.reaction_chioce}</td>
			<td>${questionlist.delay}</td>
			<td>${questionlist.is_true}</td>
			<td>${questionlist.type}</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==19}">
		<tr>
			<td>程显序号</td><td>时间</td><td>学生选择</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.student_choice}</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==20}">
		<tr>
			<td>程显序号</td><td>时间</td><td>学生选择</td><td>问题答案</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.student_choice}</td>
			<td>${questionlist.question_answer}</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==21}">
		<tr>
			<td>程显序号</td><td>时间</td><td>学生选择</td><td>问题答案</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.student_choice}</td>
			<td>${questionlist.question_answer}</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==22}">
		<tr>
			<td>程显序号</td><td>时间</td><td>学生选择</td><td>问题答案</td><td>学生得分</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.student_choice}</td>
			<td>${questionlist.question_right}</td>
			<td>${questionlist.student_score}</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==23}">
		<tr>
			<td>程显序号</td><td>时间</td><td>学生选择</td><td>问题答案</td><td>学生得分</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.student_choice}</td>
			<td>${questionlist.question_right}</td>
			<td>${questionlist.student_score}</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==24}">
		<tr>
			<td>程显序号</td><td>时间</td><td>学生选择</td><td>问题答案</td><td>学生得分</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.student_choice}</td>
			<td>${questionlist.question_right}</td>
			<td>${questionlist.student_score}</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==25}">
		<tr>
			<td>程显序号</td><td>时间</td><td>学生选择</td><td>问题答案</td><td>学生得分</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.student_choice}</td>
			<td>${questionlist.question_right}</td>
			<td>${questionlist.student_score}</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==26}">
		<tr>
			<td>程显序号</td><td>时间</td><td>学生选择</td><td>学生得分</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.student_choice}</td>
			<td>${questionlist.student_score}</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==27}">
		<tr>
			<td>程显序号</td><td>时间</td><td>题目编号</td><td>学生选择</td><td>学员得分</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.subject_no }</td>
			<td>${questionlist.student_choice }</td>
			<td>${questionlist.student_score }</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==28}">
		<tr>
			<td>程显序号</td><td>时间</td><td>A选项</td><td>B选项</td><td>学生得分</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.student_choicea}</td>
			<td>${questionlist.student_choiceb}</td>
			<td>${questionlist.student_score}</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==29}">
		<tr>
			<td>程显序号</td><td>时间</td><td>学生选择</td><td>问题答案</td><td>学生得分</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.student_choice}</td>
			<td>${questionlist.right_anser}</td>
			<td>${questionlist.student_score}</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==30}">
		<tr>
			<td>程显序号</td><td>时间</td><td>题目编号</td><td>学生选择</td><td>学员得分</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.test_no }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.student_choice }</td>
			<td>${questionlist.student_score }</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==31}">
		<tr>
			<td>程显序号</td><td>时间</td><td>题目编号</td><td>学生选择</td><td>学员得分</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.test_no }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.student_choice }</td>
			<td>${questionlist.student_score }</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==32}">
		<tr>
			<td>程显序号</td><td>时间</td><td>学生选择</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.student_choice}</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==33}">
		<tr>
			<td>程显序号</td><td>时间</td><td>题目编号</td><td>学生选择</td><td>学员得分</td>
		</tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr>
			<td>${questionlist.test_no }</td>
			<td>${questionlist.reaction_time}</td>
			<td>${questionlist.question_no }</td>
			<td>${questionlist.student_choice }</td>
			<td>${questionlist.student_score }</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${qunumber==34}">
		<tr><td style="text-align:left;height:50px;"><p style="margin-left:40px;">内容：</p></td></tr>
		<c:forEach items="${questionlist}" var="questionlist">
		<tr valign="top">
			<td style="width:600px;height:500px;text-align: left;"><textarea style="width:80%;height:60%;margin-left:40px;padding:3px">${questionlist.content}</textarea></td>
		</tr>
		</c:forEach>
	</c:if>
</table>
</div>