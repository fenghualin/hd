package com.huanduguihua.gray.question1.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.huanduguihua.green.question3.bean.search.TestOperationbSearch;
import com.huanduguihua.manager.bean.TestQuestionAnswer2;
import com.huanduguihua.manager.bean.TestQuestionLang2;
import com.huanduguihua.manager.service.TestQuestionAcswerService2;
import com.huanduguihua.manager.service.TestQuestionLangService2;
import com.huanduguihua.system.controller.DefaultController;
import com.huanduguihua.user.bean.User;

@Controller
@RequestMapping("/gray/personalityA")
public class PersonalityAController extends DefaultController {

	@Autowired TestQuestionLangService2 testQuestionLangService2;
	
	@Autowired TestQuestionAcswerService2 testQuestionAcswerService2;
	
	@RequestMapping(value="Questiondatas",method=RequestMethod.POST)
	public void Questiondatas(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam("pagestart") Integer pagestart,
			@RequestParam("pagesize") Integer pagesize){
		User u = (User) request.getSession().getAttribute("user");
		TestOperationbSearch search = new TestOperationbSearch();
		search.setKinds(3);

		try {
			if(u.getUsername().startsWith("3")){
				search = testQuestionLangService2.list(search,pagestart,pagesize);
			}else{
				search = testQuestionLangService2.listcr(search,pagestart,pagesize);
			}
			
			if(search.getCount()>0){
				List<TestQuestionLang2> list = search.getDatas();
				TestQuestionLang2 testQuestionLang =list.get(0);
				List<TestQuestionAnswer2> answerList ;
				if(u.getUsername().startsWith("3")){
					 answerList =testQuestionAcswerService2.getlist(testQuestionLang.getId());
				}else{
					 answerList =testQuestionAcswerService2.getlistcr(testQuestionLang.getId());
				}
				JSONArray arr = new JSONArray();
					JSONObject objlang = new JSONObject();
					objlang.put("question_text", testQuestionLang.getQuestion_text());
					objlang.put("question_no", testQuestionLang.getId());
					objlang.put("datacountnumber", search.getCount());
					objlang.put("invberte", testQuestionLang.getInverted());
					arr.put(objlang);
	
					for(TestQuestionAnswer2 answer : answerList){
						arr.put(answer.toJSONObject());
					}
					
					response.setContentType("test/javascript;charset=utf-8");
					response.getWriter().print(arr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
