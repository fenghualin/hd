package com.huanduguihua.blue.question_5.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huanduguihua.blue.question_4.bean.CenterTest;
import com.huanduguihua.blue.question_5.bean.EmptyTest;
import com.huanduguihua.blue.question_5.service.EmptyTestService;
import com.huanduguihua.system.controller.DefaultController;
import com.huanduguihua.user.bean.User;

@Controller
@RequestMapping("/blue/question_5")
public class EmptyTestController extends DefaultController{
	
	@Autowired
	EmptyTestService emptyTestService;
	
	@RequestMapping(value="start",method=RequestMethod.GET)
	public String start(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "blue/question_5/visualspatial")) {
				return "blue/question_5/visualspatial";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "blue/question_5/visualspatial";
	}
	
	@RequestMapping(value="demo",method=RequestMethod.GET)
	public String demo(HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "blue/question_5/visualspatial")) {
				return "blue/question_5/demo";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "blue/question_5/demo";
	}
	
	@RequestMapping(value="ajaxSave",method=RequestMethod.POST)
	public void ajaxSave(HttpServletRequest request,HttpServletResponse response) throws Exception{
request.setCharacterEncoding("utf-8");
		
		String textData = request.getParameter("data");
		JSONObject jsonobject = new JSONObject(textData);
		Iterator<String> keys = jsonobject.keys();
		
		List<EmptyTest> emptyList = new ArrayList<EmptyTest>();
		
		User user = (User) request.getSession().getAttribute("user");
		int userId = 0;
		if(user != null){
			userId = user.getId();
		}
		
		while (keys.hasNext()) {
			String key = keys.next();
		 	//Map map = (Map)jsonobject.get(key);
			JSONObject map = jsonobject.getJSONObject(key);
		 	EmptyTest emptyTest = new EmptyTest();
		 	
//		 	emptyTest.setAccuracy(String.valueOf(map.get("accuracy")));
//		 	emptyTest.setCorrectAnswer((Long)(map.get("question")));
//		 	emptyTest.setStudentAnswer((Long)(map.get("answer")));
//		 	emptyTest.setQuestioinNo(Integer.parseInt(String.valueOf(map.get("question_no"))));
//		 	emptyTest.setRange(String.valueOf(map.get("range")));
//		 	emptyTest.setReactionTime(String.valueOf(map.get("reaction_time")));
//		 	emptyTest.setTestNo(Integer.parseInt(String.valueOf(map.get("testNo"))));
//		 	emptyTest.setUserId(userId);//reaction_choice
//		 	emptyTest.setReactionChioce(Integer.parseInt(String.valueOf(map.get("reaction_choice"))));
		 	
		 	emptyTest.setAccuracy(map.optString("accuracy"));
		 	emptyTest.setCorrectAnswer(map.optString("question"));
		 	emptyTest.setStudentAnswer(map.optString("answer"));
		 	emptyTest.setQuestionNo(map.optInt("question_no"));
		 	emptyTest.setRange(map.optString("range"));
		 	emptyTest.setReactionTime(map.optString("reaction_time"));
		 	emptyTest.setTestNo(map.optInt("testNo"));
		 	emptyTest.setUserId(userId);//reaction_choice
		 	emptyTest.setReactionChioce(map.optInt("reaction_choice"));
		 	List<Map<String, Object>> l = emptyTestService.executeQuery("select * from test_empty where user_id=? and question_no=?", user.getId(),Integer.parseInt(String.valueOf(map.get("question_no"))));
		 	if(l.size()==0)
		 		emptyList.add(emptyTest);
		}
		
		for (EmptyTest emptyTest : emptyList) {
			emptyTestService.save(emptyTest);
		}
	}
}
