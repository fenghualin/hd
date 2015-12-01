package com.huanduguihua.blue.question_4.controller;

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

import com.huanduguihua.blue.question_3.bean.LoopTest;
import com.huanduguihua.blue.question_4.bean.CenterTest;
import com.huanduguihua.blue.question_4.service.CenterTestService;
import com.huanduguihua.system.controller.DefaultController;
import com.huanduguihua.user.bean.User;

@Controller
@RequestMapping("/blue/question_4")
public class CenterTestController extends DefaultController{

	@Autowired
	CenterTestService centerTestService;
	
	@RequestMapping(value="start",method=RequestMethod.GET)
	public String start(Model model ,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "blue/question_4/executive")) {
				return "blue/question_4/executive";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "blue/question_4/executive";
	}
	
	@RequestMapping(value="demo",method=RequestMethod.GET)
	public String demo(HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "blue/question_4/executive")) {
				return "blue/question_4/demo";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "blue/question_4/demo";
	}
	
	@RequestMapping(value="ajaxSave",method=RequestMethod.POST)
	public void ajaxSave(HttpServletRequest request,HttpServletResponse response) throws Exception{
		try {
			request.setCharacterEncoding("utf-8");
			
			String textData = request.getParameter("data");
			JSONObject jsonobject = new JSONObject(textData);
			Iterator<String> keys = jsonobject.keys();
			List<CenterTest> centerList = new ArrayList<CenterTest>();
			
			User user = (User) request.getSession().getAttribute("user");
			int userId = 0;
			if(user != null){
				userId = user.getId();
			}
			
			while (keys.hasNext()) {
				String key = keys.next();
				JSONObject map = jsonobject.getJSONObject(key);
				System.out.println("next..."+map);
			 	CenterTest centerTest = new CenterTest();
			 	centerTest.setAccuracy(String.valueOf(map.get("accuracy")));
			 	centerTest.setCorrectAnswer(String.valueOf(map.get("question")));
			 	centerTest.setStudentAnswer(String.valueOf(map.get("answer")));
			 	centerTest.setQuestionNo(Integer.parseInt(String.valueOf(map.get("question_no"))));
			 	centerTest.setRange(String.valueOf(map.get("range")));
			 	centerTest.setReactionTime(String.valueOf(map.get("reaction_time")));
			 	centerTest.setTestNo(Integer.parseInt(String.valueOf(map.get("testNo"))));
			 	centerTest.setUserId(userId);//reaction_choice
			 	centerTest.setReactionChoice(Integer.parseInt(String.valueOf(map.get("reaction_choice"))));
			 	List<Map<String, Object>> l = centerTestService.executeQuery("select * from test_center where user_id=? and question_no=?", user.getId(),Integer.parseInt(String.valueOf(map.get("question_no"))));
			 	if(l.size()==0)
			 		centerList.add(centerTest);
			}
			System.out.println("save..." + centerList);
			for (CenterTest centerTest : centerList) {
				System.out.println("save...");
				centerTestService.save(centerTest);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
