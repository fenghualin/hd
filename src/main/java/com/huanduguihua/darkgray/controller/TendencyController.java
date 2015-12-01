package com.huanduguihua.darkgray.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
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
import com.huanduguihua.manager.bean.search.TestQuestionLangSearch;
import com.huanduguihua.manager.service.TestQuestionAcswerService2;
import com.huanduguihua.manager.service.TestQuestionLangService2;
import com.huanduguihua.system.controller.DefaultController;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;
import com.huanduguihua.user.bean.User;

@Controller
@RequestMapping("/darkgray")
public class TendencyController extends DefaultController{
	private static Logger logger = Logger.getLogger(TendencyController.class);
	@Autowired
	TestQuestionLangService2 testQuestionLangService2;
	@Autowired
	TestQuestionAcswerService2 testQuestionAcswerService2;
	
	@RequestMapping(value="resto",method=RequestMethod.GET)
	public String resto(HttpServletRequest request){
		return "rest/resto";
	}
	@RequestMapping(value="end",method=RequestMethod.GET)
	public String end(HttpServletRequest request){
		return "end";
	}
	@RequestMapping(value="restt",method=RequestMethod.GET)
	public String restt(HttpServletRequest request){
		return "rest/restt";
	}
	@RequestMapping(value="tendency",method=RequestMethod.GET)
	public String tendency(Model model , HttpServletRequest request , HttpServletResponse response){
		User user = super.getSessionUser(request);
		if(user != null){
			if (super.checkTimu(request, "darkgray/tendency")) {
				return "darkgray/tendency";
			} else {
				super.historyBack(response,request);
				return null;
			}
		} else {
			return "redirect:/";
		}
//		return "darkgray/tendency";
	}
	
	@RequestMapping(value="gomainselect",method=RequestMethod.GET)
	public String gomainselect(Model model , HttpServletRequest request , HttpServletResponse response){
		User user = super.getSessionUser(request);
		if(user != null){
			if (super.checkMokuai(request, "darkgray/mainselect")) {
				return "darkgray/mainselect";
			} else {
				super.historyBack(response,request);
				return null;
			}
		} else {
			return "redirect:/";
		}
//		return "darkgray/mainselect";
	}
	
	@RequestMapping(value="Questiondatas",method=RequestMethod.POST)
	public void Questiondatas(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam("pagestart") Integer pagestart,
			@RequestParam("pagesize") Integer pagesize){
		
		TestOperationbSearch tqs = new TestOperationbSearch();
		TestOperationbSearch search = new TestOperationbSearch();
		tqs.setKinds(2);
		try {
			User u = (User) request.getSession().getAttribute("user");
			if(u.getUsername().startsWith("3")){
				search = testQuestionLangService2.list(tqs,pagestart,pagesize);
			}else{
				search = testQuestionLangService2.listcr(tqs,pagestart,pagesize);
			}
			
			if(search.getCount()>0 && search.getDatas().size()>0){
				List<TestQuestionLang2> list = search.getDatas();
				
				TestQuestionLang2 testQuestionLang = list.get(0);
				List<TestQuestionAnswer2> answerList = new ArrayList<TestQuestionAnswer2>();
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
			logger.error("查询题目异常", e);
			e.printStackTrace();
		}
	}
}
