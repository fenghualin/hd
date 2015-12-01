package com.huanduguihua.red.question4.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.huanduguihua.red.question4.bean.TestReasoning;
import com.huanduguihua.red.question4.service.TestReasoningService;
import com.huanduguihua.user.bean.User;

@Controller
@RequestMapping("/red/testReasoning")
public class TestReasoningController {

	@Autowired
	TestReasoningService testReasoningService;
	
	@RequestMapping(value="testReasoningsave",method=RequestMethod.POST)
	public void testReasoningsave(Model model , HttpServletRequest request , HttpServletResponse response){
		try {
			TestReasoning reasoning=new TestReasoning();
			User u = (User) request.getSession().getAttribute("user");
			if(u!=null)
				reasoning.setUser_id(u.getId());
			String reaction_time = request.getParameter("reaction_time");
			Integer question_no=Integer.parseInt(request.getParameter("question_no"));
			Integer student_score = Integer.parseInt(request.getParameter("student_score"));
			Integer student_choicea = Integer.parseInt(request.getParameter("student_choicea"));
			Integer student_choiceb = Integer.parseInt(request.getParameter("student_choiceb"));
			Integer student_choicec = Integer.parseInt(request.getParameter("student_choicec"));
			reasoning.setReaction_time(reaction_time);
			reasoning.setQuestion_no(question_no);
			reasoning.setStudent_choicea(student_choicea);
			if(student_choiceb != 0){
				reasoning.setStudent_choiceb(student_choiceb);
			}
			if(student_choicec != 0){
				reasoning.setStudent_choicec(student_choicec);
			}
			reasoning.setStudent_score(student_score);
			List<Map<String, Object>> l = testReasoningService.executeQuery("select * from test_reasoning where user_id=? and question_no=?", u.getId(),question_no);
			if(l.size()==0)
				testReasoningService.save(reasoning);
			testReasoningService.executeUpdate("update test_system_user set xiaotijd=? where id=?", question_no,u.getId());
			response.getWriter().print("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value="testReasoningtwo",method=RequestMethod.GET)
	public String testReasoningtwo(Model model , HttpServletRequest request , HttpServletResponse response){
		return "red/deductiontwo";
	}
	@RequestMapping(value="testReasoningthree",method=RequestMethod.GET)
	public String testReasoningthree(Model model , HttpServletRequest request , HttpServletResponse response){
		return "red/deductionthree";
	}
	@RequestMapping(value="testReasoningfour",method=RequestMethod.GET)
	public String testReasoningfour(Model model , HttpServletRequest request , HttpServletResponse response){
		return "red/deductionfour";
	}
	@RequestMapping(value="testReasoningfive",method=RequestMethod.GET)
	public String testReasoningfive(Model model , HttpServletRequest request , HttpServletResponse response){
		return "red/deductionfive";
	}
	@RequestMapping(value="testReasoningsix",method=RequestMethod.GET)
	public String testReasoningsix(Model model , HttpServletRequest request , HttpServletResponse response){
		return "red/deductionsix";
	}
}
