package com.huanduguihua.red.question2.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huanduguihua.red.question2.bean.TestThinking;
import com.huanduguihua.red.question2.service.TestThinkingService;
import com.huanduguihua.user.bean.User;

@Controller
@RequestMapping("/red/testThinking")
public class TestThinkingController {

	@Autowired
	TestThinkingService testThinkingService;
	
	@RequestMapping(value="testThinkingsave",method=RequestMethod.POST)
	public void testThinkingsave(Model model,HttpServletRequest request,HttpServletResponse response){
		TestThinking testThinking = new TestThinking();
		User u = (User) request.getSession().getAttribute("user");
		Integer question_no = Integer.parseInt(request.getParameter("question_no"));
		String reaction_time = request.getParameter("reaction_time");
		Integer reaction_chioce = Integer.parseInt(request.getParameter("reaction_chioce"));
		String delay = request.getParameter("delay");
		Integer is_true = Integer.parseInt(request.getParameter("is_true"));
		Integer type = Integer.parseInt(request.getParameter("type"));
		if(u!=null)
			testThinking.setUser_id(u.getId());
		testThinking.setIs_true(is_true);
		testThinking.setQuestion_no(question_no);
		testThinking.setType(type);
		testThinking.setReaction_time(reaction_time);
		testThinking.setReaction_chioce(reaction_chioce);
		testThinking.setDelay(delay);
		List<Map<String, Object>> l = testThinkingService.executeQuery("select * from test_thinking where user_id=? and question_no=?", u.getId(),question_no);
		if(l.size()==0)
			testThinkingService.save(testThinking);
		testThinkingService.executeUpdate("update test_system_user set xiaotijd=? where id=?", question_no,u.getId());
	}
	
	@RequestMapping(value="myjsp",method=RequestMethod.GET)
	public String myjsp(Model model,HttpServletRequest request,HttpServletResponse response){
		return "red/MyJsp";
	}
}
