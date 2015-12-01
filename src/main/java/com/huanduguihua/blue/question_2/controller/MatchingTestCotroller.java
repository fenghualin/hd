package com.huanduguihua.blue.question_2.controller;

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

import com.huanduguihua.blue.question_2.bean.MatchingTest;
import com.huanduguihua.blue.question_2.service.MatchingTestService;
import com.huanduguihua.system.controller.DefaultController;
import com.huanduguihua.user.bean.User;

@Controller
@RequestMapping("/blue/question_2")
public class MatchingTestCotroller extends DefaultController{
	
	@Autowired
	MatchingTestService matchingTestService;
	
	@RequestMapping(value="start",method=RequestMethod.GET)
	public String start(Model model, HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "blue/question_2/figure")) {
				return "blue/question_2/figure";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "blue/question_2/figure";
	}
	
	@RequestMapping(value="demo",method=RequestMethod.GET)
	public String demo(HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "blue/question_2/figure")) {
				return "blue/question_2/demo";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "blue/question_2/demo";
	}
	
	@RequestMapping(value="ajaxSave",method=RequestMethod.POST)
	public void ajaxSave(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		User user = (User) request.getSession().getAttribute("user");
		int testNo = Integer.parseInt(request.getParameter("testNo"));
		int userId = 0;
		if(user != null){
			userId = user.getId();
		}
		int questionNo = Integer.parseInt(request.getParameter("questionNo"));
		String reactionTime = request.getParameter("reactionTime"); 
		int reactionChoice = Integer.parseInt(request.getParameter("reactionChoice"));
		int delay = Integer.parseInt(request.getParameter("delay"));
		boolean isTrue = Boolean.parseBoolean(request.getParameter("isTrue")); 
		int position = Integer.parseInt(request.getParameter("position"));
		//创建项目并赋值
		MatchingTest matching = new MatchingTest();
		matching.setTestNo(testNo);
		matching.setUserId(userId);
		matching.setQuestionNo(questionNo);
		matching.setReactionTime(reactionTime);
		matching.setReactionChoice(reactionChoice);
		matching.setDelay(delay);
		matching.setIsTrue(isTrue);
		matching.setPosition(position);
		List<Map<String, Object>> l = matchingTestService.executeQuery("select * from test_macthing where user_id=? and question_no=?", user.getId(),questionNo);
		if(l.size()==0)
			matchingTestService.save(matching);
		matchingTestService.executeUpdate("update test_system_user set xiaotijd=? where id=?", questionNo,user.getId());
		
	}
}
