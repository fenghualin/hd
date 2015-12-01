package com.huanduguihua.yellow.question1.controller;

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
import com.huanduguihua.manager.service.QuestionUrlService;
import com.huanduguihua.system.controller.DefaultController;
import com.huanduguihua.user.bean.User;
import com.huanduguihua.yellow.question1.bean.TestCompare;
import com.huanduguihua.yellow.question1.service.TestCompareService;


@Controller
@RequestMapping("/yellow")
public class TestCompareController extends DefaultController{
	@Autowired
	TestCompareService testCompareService;
	@Autowired
	QuestionUrlService questionUrlService;
	
	@RequestMapping(value="gomainselect",method=RequestMethod.GET)
	public String gomainselect(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkMokuai(request, "yellow/mainselect")) {
				return "yellow/mainselect";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "yellow/mainselect";
	}
	
	@RequestMapping(value="gocomparing",method=RequestMethod.GET)
	public String gocomparing(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "yellow/comparing")) {
				return "yellow/comparing";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="golinguisitic",method=RequestMethod.GET)
	public String golinguisitic(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "yellow/linguisitic")) {
				return "yellow/linguisitic";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "yellow/linguisitic";
	}
	
	@RequestMapping(value="gooperation",method=RequestMethod.GET)
	public String gooperation(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "yellow/operation")) {
				return "yellow/operation";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "yellow/operation";
	}
	
	@RequestMapping(value="gosnake",method=RequestMethod.GET)
	public String gosnake(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "yellow/snake")) {
				return "yellow/snake";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		} 
//		return "yellow/snake";
	}
	@RequestMapping(value="gosnakelx",method=RequestMethod.GET)
	public String gosnakelx(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "yellow/snake")) {
				return "yellow/snakelx";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		} 
//		return "yellow/snakelx";
	}
	@RequestMapping(value="comparingSubmit",method=RequestMethod.POST)
	public void comparingSubmit(Model model,HttpServletRequest request,HttpServletResponse response,String test_no){
		TestCompare compare = new TestCompare();
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			compare.setUser_id(u.getId());
		}
		compare.setId(testCompareService.getTableId("test_compare"));
		if(request.getParameter("reaction_choice")!="" && request.getParameter("reaction_choice")!=null)
		compare.setReaction_choice(Integer.parseInt((String)request.getParameter("reaction_choice")));
		compare.setReaction_time(request.getParameter("reaction_time"));
		compare.setTest_no(Integer.parseInt((String)request.getParameter("test_no")));
		Integer question_no=Integer.parseInt((String)request.getParameter("question_no"));
		compare.setQuestion_no(question_no);
		compare.setCorrect_answer(Integer.parseInt((String)request.getParameter("correct_answer")));
		if("true".equals(request.getParameter("is_true"))){
			compare.setIs_true(true);
		}
		else{
			compare.setIs_true(false);
		}
		compare.setStudent_answer(Integer.parseInt((String)request.getParameter("student_answer")));
		List<Map<String, Object>> l = testCompareService.executeQuery("select * from test_compare where user_id=? and question_no=?", u.getId(),question_no);
		if(l.size()==0)
		testCompareService.save(compare);
	}
	@RequestMapping(value="setpanduantimu",method=RequestMethod.POST)
	public void setpanduantimu(Model model,HttpServletRequest request,HttpServletResponse response,String test_no){
		request.getSession().setAttribute("state", request.getParameter("state"));
	}
	
	@RequestMapping(value="getpanduantimu",method=RequestMethod.POST)
	public void getpanduantimu(Model model,HttpServletRequest request,HttpServletResponse response,String test_no){
		try {
			response.getWriter().print((String)request.getSession().getAttribute("state"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
