package com.huanduguihua.yellow.question2.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huanduguihua.user.bean.User;
import com.huanduguihua.yellow.question2.bean.TestOperation;
import com.huanduguihua.yellow.question2.service.TestOperationService;

@Controller
@RequestMapping("/yellow/mathoperation")
public class TestOperationController {

	@Autowired
	TestOperationService operationService;
	
	@RequestMapping(value="operationSubmit",method=RequestMethod.POST)
	public void operationSubmit(Model model,HttpServletRequest request,HttpServletResponse response){
		TestOperation testOperation = new TestOperation();
		User u =(User) request.getSession().getAttribute("user");
		if(u!=null){
			testOperation.setUser_id(u.getId());
		}
		testOperation.setId(operationService.getTableId("test_operation"));
		Integer test_no=Integer.parseInt((String)request.getParameter("test_no"));
		testOperation.setTest_no(test_no);
		Integer question_no=Integer.parseInt((String)request.getParameter("question_no"));
		testOperation.setQuestion_no(question_no);
		testOperation.setCorrect_answer(Integer.parseInt(request.getParameter("correct_answer")));
		testOperation.setStep(Integer.parseInt((String)request.getParameter("step")));
		testOperation.setReaction_time((String)request.getParameter("reaction_time"));
		if("1".equals(request.getParameter("is_true"))){
			testOperation.setIs_true(true);
		}
		else{
			testOperation.setIs_true(false);
		}
		if(request.getParameter("student_answer")!=null && request.getParameter("student_answer") != "")
			testOperation.setStudent_answer(Integer.parseInt(request.getParameter("student_answer")));
		List<Map<String, Object>> l = operationService.executeQuery("select * from test_operation where user_id=? and question_no=? and test_no=?", u.getId(),question_no,test_no);
		if(l.size()==0)
		operationService.save(testOperation);
	}
	
	public long getNas(){
		
		return System.nanoTime();
	}
	
}
