package com.huanduguihua.blue.question_3.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huanduguihua.blue.question_3.bean.LoopTest;
import com.huanduguihua.blue.question_3.service.LoopTestService;
import com.huanduguihua.system.controller.DefaultController;
import com.huanduguihua.user.bean.User;

@Controller
@RequestMapping("/blue/question_3")
public class LoopTestController extends DefaultController{
	
	@Autowired
	LoopTestService loopTestService;
	
	@RequestMapping(value="start",method=RequestMethod.GET)
	public String start(Model model, HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "blue/question_3/phonological")) {
				return "blue/question_3/phonological";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "blue/question_3/phonological";
	}
	
	@RequestMapping(value="demo",method=RequestMethod.GET)
	public String demo(HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "blue/question_3/phonological")) {
				return "blue/question_3/demo";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "blue/question_3/demo";
	} 
	
	@RequestMapping(value="ajaxSave")
	public void ajaxSave(HttpServletRequest request,HttpServletResponse response) throws Exception{
		try {
			request.setCharacterEncoding("utf-8");
			
			String textData = request.getParameter("data");
			
			JSONObject jsonobject = new JSONObject(textData);
			
			Iterator<String> keys = jsonobject.keys();
			
			List<LoopTest> loopList = new ArrayList<LoopTest>();
			
			User user = (User) request.getSession().getAttribute("user");
			System.out.println("user: " + user);
			System.out.println("textData: " + textData);
			int userId = 0;
			if(user != null){
				userId = user.getId();
			}
			
			while (keys.hasNext()) {
				
				String key = keys.next();
			 	JSONObject map = jsonobject.getJSONObject(key);
			 	System.out.println("next..." + map);
			 	LoopTest loopTest = new LoopTest();
			 	loopTest.setAccuracy(String.valueOf(map.get("accuracy")));
			 	loopTest.setCorrectAnswer(String.valueOf(map.get("question")));
			 	System.out.println(map.get("answer"));
			 	loopTest.setStudentAnswer(String.valueOf((map.get("answer"))));
			 	loopTest.setQuestionNo(Integer.parseInt(String.valueOf(map.get("question_no"))));
			 	loopTest.setRange(String.valueOf(map.get("range")));
			 	loopTest.setReactionTime(String.valueOf(map.get("reaction_time")));
			 	loopTest.setTestNo(Integer.parseInt(String.valueOf(map.get("testNo"))));
			 	loopTest.setUserId(userId);//reaction_choice
			 	loopTest.setReactionChoice(Integer.parseInt(String.valueOf(map.get("reaction_choice"))));
			 	List<Map<String, Object>> l = loopTestService.executeQuery("select * from test_loop where user_id=? and question_no=?", user.getId(),Integer.parseInt(String.valueOf(map.get("question_no"))));
			 	if(l.size()==0)
			 		loopList.add(loopTest);
			}
			for (LoopTest loopTest : loopList) {
//				System.out.println(loopTest);
				loopTestService.save(loopTest);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
