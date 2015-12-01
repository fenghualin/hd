package com.huanduguihua.blue.question_1.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.huanduguihua.blue.question_1.bean.ReactionTest;
import com.huanduguihua.blue.question_1.service.ReactionTestService;
import com.huanduguihua.system.controller.DefaultController;
import com.huanduguihua.user.bean.Group;
import com.huanduguihua.user.bean.Mokuai;
import com.huanduguihua.user.bean.MokuaiGroup;
import com.huanduguihua.user.bean.User;
import com.huanduguihua.user.bean.UserGroup;
import com.huanduguihua.user.service.GroupService;
import com.huanduguihua.user.service.MokuaiGroupService;
import com.huanduguihua.user.service.MokuaiService;
import com.huanduguihua.user.service.UserGroupService;
import com.huanduguihua.user.service.UserService;

@Controller
@RequestMapping("/blue/question_1")
public class ReactionTestController extends DefaultController{
	
	@Autowired
	ReactionTestService reactionTestService;
	@Autowired UserGroupService userGroupService;
	@Autowired GroupService groupService;
	@Autowired UserService userService;
	@Autowired MokuaiGroupService mokuaiGroupService;
	@Autowired MokuaiService mokuaiService;
	
	@RequestMapping(value="index",method=RequestMethod.GET)
	public String Test(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkMokuai(request, "blue/question_1/mainselect")) {
				return "blue/question_1/mainselect";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "blue/question_1/mainselect";
	}
	
	@RequestMapping(value="start",method=RequestMethod.GET)
	public String Start(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "blue/question_1/reaction")) {
				return "blue/question_1/reaction";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "blue/question_1/reaction";
	}
	
	@RequestMapping(value="demo",method=RequestMethod.GET)
	public String demo(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "blue/question_1/reaction")) {
				return "blue/question_1/demo";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "blue/question_1/demo";
	}
	@RequestMapping(value="ajaxSave",method=RequestMethod.POST)
	public void ajaxSave(Model model,HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		User user = (User) request.getSession().getAttribute("user");
		int userId = 0;
		if(user != null){
			userId = user.getId();
		}
		int question_no = Integer.parseInt(request.getParameter("question_no"));
		String reaction_time = request.getParameter("reaction_time");
		int reaction_choice = Integer.parseInt(request.getParameter("reaction_choice"));
		int delay = Integer.parseInt(request.getParameter("delay"));
		Boolean is_true = Boolean.valueOf(request.getParameter("is_true"));
		int position = Integer.parseInt(request.getParameter("position"));
		//创建对象并赋值
		ReactionTest reaction = new ReactionTest();
		reaction.setQuestion_no(question_no);
		reaction.setReaction_time(reaction_time);
		reaction.setReaction_choice(reaction_choice);
		reaction.setDelay(delay);
		reaction.setIs_true(is_true);
		reaction.setPosition(position);
		reaction.setTest_no(0);
		reaction.setUser_id(userId);
		List<Map<String, Object>> l = reactionTestService.executeQuery("select * from test_reaction where user_id=? and question_no=?", user.getId(),question_no);
		if(l.size()==0)
		reactionTestService.save(reaction);
		reactionTestService.executeUpdate("update test_system_user set xiaotijd=? where id=?", question_no,user.getId());
	}
}
