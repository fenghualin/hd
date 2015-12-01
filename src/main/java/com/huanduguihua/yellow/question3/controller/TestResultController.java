package com.huanduguihua.yellow.question3.controller;

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

import com.huanduguihua.manager.bean.TestQuestionAnswer;
import com.huanduguihua.manager.bean.TestQuestionLang;
import com.huanduguihua.manager.bean.search.TestQuestionLangSearch;
import com.huanduguihua.manager.service.TestQuestionAcswerService;
import com.huanduguihua.manager.service.TestQuestionLangService;
import com.huanduguihua.user.bean.User;
import com.huanduguihua.yellow.question3.bean.TestResult;
import com.huanduguihua.yellow.question3.service.TestResultService;

@Controller
@RequestMapping("/yellow/testResult")
public class TestResultController {

	@Autowired
	TestQuestionAcswerService testQuestionAcswerService;
	@Autowired
	TestQuestionLangService testQuestionLangService;
	@Autowired
	TestResultService testResultService;
	
	@RequestMapping(value="TestResultsave",method=RequestMethod.POST)
	public void TestResultsave(Model model,HttpServletRequest request,HttpServletResponse response){
		List<TestQuestionLang> list = testQuestionLangService.questionlistquery("1");
//		System.out.println(list.size()+":提要求");
//		if(list.size()>0){
//			for(int i = 0 ; i < list.size() ; i++){
//				//TestQuestionLang tql = list.get(i);
//				//List<TestQuestionAnswer> l =testQuestionAcswerService.getlist(tql.getId()+"");
//				//if(l.size()>0){
//					//for(int y = 0 ; y < l.size() ; y++){
//						//TestQuestionAnswer tqa = l.get(y);
//					//}
//				//}
//			}
//		}
		request.setAttribute("tizusize", list.size());
	}
	
	@RequestMapping(value="Questiondatas",method=RequestMethod.POST)
	public void Questiondatas(Model model,HttpServletRequest request,HttpServletResponse response){
		TestQuestionLangSearch tqs = new TestQuestionLangSearch();
		tqs.setKinds(2);
		String pagestart = request.getParameter("pagestart");
		String pagesize = request.getParameter("pagesize");
		try {
			TestQuestionLangSearch s=testQuestionLangService.list(tqs,pagestart,pagesize);
			
			if(s.getCount()>0){
				List<TestQuestionLang> list = (List<TestQuestionLang>) s.getDatas();
				TestQuestionLang testQuestionLang=(TestQuestionLang) list.get(0);
				List<TestQuestionAnswer> l =testQuestionAcswerService.getlist(testQuestionLang.getId()+"");
				JSONArray arr = new JSONArray();
					JSONObject objlang = new JSONObject();
					objlang.put("question_text", testQuestionLang.getQuestion_text());
					objlang.put("question_no", testQuestionLang.getId());
					objlang.put("datacountnumber", s.getCount());
					arr.put(objlang);
					for(int y = 0 ; y < l.size() ; y++){
						TestQuestionAnswer tqa = l.get(y);
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
		}
	}
	@RequestMapping(value="linguisiticSave",method=RequestMethod.POST)
	public void linguisiticSave(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		String option_score = request.getParameter("option_score");
		String question_no = request.getParameter("test_no");
		String student_choice = request.getParameter("student_choice");
		String reaction_time = request.getParameter("reaction_time");
		String subject_no = request.getParameter("question_no");
		String kinds = request.getParameter("kinds");
		TestResult tr=new TestResult();
//		System.out.println(option_score+"--"+student_choice+"--"+reaction_time);
		if(u != null){
			tr.setUser_id(u.getId());
		}
		tr.setSubject_no(Integer.parseInt(subject_no));
		tr.setStudent_choice(student_choice);
		tr.setQuestion_no(Integer.parseInt(question_no));
		tr.setStudent_score(Integer.parseInt(option_score));
		if(!StringUtils.isEmpty(kinds))
			tr.setKinds(Integer.parseInt(kinds));
		tr.setReaction_time(reaction_time);
		List<Map<String, Object>> l = testResultService.executeQuery("select * from test_resilt where user_id=? and question_no=? and subject_no=?", u.getId(),question_no,subject_no);
		if(l.size()==0)
		testResultService.save(tr);
		testResultService.executeUpdate("update test_system_user set xiaotijd=? where id=?", question_no,u.getId());
	}
	
}
