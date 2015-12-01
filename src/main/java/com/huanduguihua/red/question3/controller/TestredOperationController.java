package com.huanduguihua.red.question3.controller;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.huanduguihua.red.question3.bean.TestredOperation;
import com.huanduguihua.red.question3.service.TestredOperationService;
import com.huanduguihua.user.bean.User;

@Controller
@RequestMapping("/red/testredoperation")
public class TestredOperationController {

	@Autowired
	TestredOperationService testOperationService;
	
	@RequestMapping(value="/testredoperationsave",method=RequestMethod.POST)
	public void testredoperationsave(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam("mod") String mod,
			@RequestParam("sel") String sel){
		try {
		TestredOperation testredOperation = new TestredOperation();
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null)
			testredOperation.setUser_id(u.getId());
		String  reaction_time =request.getParameter("reaction_time");
		Integer question_no = Integer.parseInt(request.getParameter("question_no"));
		Integer sum_step = Integer.parseInt(request.getParameter("sum_step"));
		String start_think = request.getParameter("start_think");
		Integer student_score = Integer.parseInt(request.getParameter("student_score"));
		testredOperation.setQuestion_no(question_no);
		testredOperation.setReaction_time(reaction_time);
		testredOperation.setStart_think(start_think);
		testredOperation.setStudent_score(student_score);
		testredOperation.setSum_step(sum_step);
		testredOperation.setMod(mod);
		testredOperation.setSel(sel);
		List<Map<String, Object>> l = testOperationService.executeQuery("select * from test_redoperation where user_id=? and question_no=?", u.getId(),question_no);
		if(l.size()==0)
		testOperationService.save(testredOperation);
		response.getWriter().print("ok");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/testredoperationtwo",method=RequestMethod.GET)
	public String testredoperationtwo(Model model,HttpServletRequest request,HttpServletResponse response){
		return "red/operationtwo";
	}
	
	@RequestMapping(value="/testredoperationthree",method=RequestMethod.GET)
	public String testredoperationthree(Model model,HttpServletRequest request,HttpServletResponse response){
		return "red/operationthree";
	}
	
	@RequestMapping(value="/testredoperationfour",method=RequestMethod.GET)
	public String testredoperationfour(Model model,HttpServletRequest request,HttpServletResponse response){
		return "red/operationfour";
	}
	
	@RequestMapping(value="/testredoperationlx",method=RequestMethod.GET)
	public String testredoperationlx(Model model,HttpServletRequest request,HttpServletResponse response){
		return "red/operationlx";
	}
}
