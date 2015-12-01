package com.huanduguihua.green.question3.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.huanduguihua.green.question3.bean.TestOperationb;
import com.huanduguihua.green.question3.bean.search.TestOperationbSearch;
import com.huanduguihua.green.question3.service.TestOperationbService;
import com.huanduguihua.manager.bean.TestQuestionAnswer2;
import com.huanduguihua.manager.bean.TestQuestionLang2;
import com.huanduguihua.manager.service.TestQuestionAcswerService2;
import com.huanduguihua.manager.service.TestQuestionLangService2;
import com.huanduguihua.user.bean.User;


@Controller
@RequestMapping("/green/TestOperationb")
public class TestOperationbController {

	@Autowired
	TestOperationbService testOperationbService;
	@Autowired
	TestQuestionAcswerService2 testQuestionAcswerService2;
	@Autowired
	TestQuestionLangService2 testQuestionLangService2;
	
	/**
	 * 问题2数据请求
	 * @param model
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="Questiondatas",method=RequestMethod.POST)
	public void Questiondatas(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam("pagestart") Integer pagestart,
			@RequestParam("pagesize") Integer pagesize){
		TestOperationbSearch tqs = new TestOperationbSearch();
		TestOperationbSearch s = new TestOperationbSearch();
		tqs.setKinds(1);
		try {
			User u = (User) request.getSession().getAttribute("user");
			if(u.getUsername().startsWith("3")){
				s=testQuestionLangService2.list(tqs,pagestart,pagesize);
			}else{
				s=testQuestionLangService2.listcr(tqs,pagestart,pagesize);
			}
			
			if(s.getCount()>0){
				List<TestQuestionLang2> list = (List<TestQuestionLang2>) s.getDatas();
				TestQuestionLang2 testQuestionLang=(TestQuestionLang2) list.get(0);
				List<TestQuestionAnswer2> l = new ArrayList<TestQuestionAnswer2>();
				if(u.getUsername().startsWith("3")){
					l =testQuestionAcswerService2.getlist(testQuestionLang.getId()+"");
				}else{
					l =testQuestionAcswerService2.getlistcr(testQuestionLang.getId()+"");
				}
				JSONArray arr = new JSONArray();
					JSONObject objlang = new JSONObject();
					objlang.put("question_text", testQuestionLang.getQuestion_text());
					objlang.put("question_no", testQuestionLang.getId());
					objlang.put("datacountnumber", s.getCount());
					objlang.put("invberte", testQuestionLang.getInverted());
					arr.put(objlang);
					for(int y = 0 ; y < l.size() ; y++){
						TestQuestionAnswer2 tqa = l.get(y);
						JSONObject obj = new JSONObject();
							obj.put("option_text", tqa.getOption_text());
							obj.put("option_score", tqa.getOption_score());
							obj.put("option_s", tqa.getOption_s());
							arr.put(obj);
					}
					response.setContentType("test/javascript;charset=utf-8");
					response.getWriter().print(arr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="testOperationbsave",method=RequestMethod.POST)
	public void testOperationbsave(HttpServletRequest request,HttpServletResponse response){
//		String invberte = request.getParameter("invberte");
		String question_no = request.getParameter("test_no");
		String student_choice = request.getParameter("student_choice");
		String reaction_time = request.getParameter("reaction_time");
		String test_no = request.getParameter("question_no");
		String student_score = request.getParameter("student_score");
		User u = (User) request.getSession().getAttribute("user");
		String kinds=request.getParameter("kinds");
		TestOperationb tob = new TestOperationb();
		tob.setQuestion_no(Integer.parseInt(question_no));
		tob.setReaction_time(reaction_time);
		tob.setStudent_choice(student_choice);
		tob.setStudent_score(Integer.parseInt(student_score));
		tob.setTest_no(Integer.parseInt(test_no));
		if (u != null ) {
			tob.setUser_id(u.getId());
		}
		if(!StringUtils.isEmpty(kinds)){
			tob.setKinds(Integer.parseInt(kinds));
		}
		List<Map<String, Object>> l = testOperationbService.executeQuery("select * from test_operationb where user_id=? and question_no=? and test_no=?", u.getId(),question_no,test_no);
		if(l.size()==0)
			testOperationbService.save(tob);
		testOperationbService.executeUpdate("update test_system_user set xiaotijd=? where id=?", question_no,u.getId());
	}
}













