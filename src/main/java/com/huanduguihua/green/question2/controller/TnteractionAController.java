package com.huanduguihua.green.question2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import com.huanduguihua.manager.bean.TestQuestionAnswer;
import com.huanduguihua.manager.bean.TestQuestionLang;
import com.huanduguihua.manager.bean.search.TestQuestionLangSearch;
import com.huanduguihua.manager.service.TestQuestionAcswerService;
import com.huanduguihua.manager.service.TestQuestionLangService;
import com.huanduguihua.user.bean.User;
import com.huanduguihua.yellow.question3.bean.TestResult;
import com.huanduguihua.yellow.question3.service.TestResultService;

@Controller
@RequestMapping("/green/TnteractionA")
public class TnteractionAController {
	@Autowired
	TestQuestionLangService testQuestionLangService;
	@Autowired
	TestQuestionAcswerService testQuestionAcswerService;
	@Autowired
	TestResultService testResultService;

	@RequestMapping(value="Questiondatas",method=RequestMethod.POST)
	public void Questiondatas(Model model,HttpServletRequest request,HttpServletResponse response){
		TestQuestionLangSearch tqs = new TestQuestionLangSearch();
		TestQuestionLangSearch s = new TestQuestionLangSearch();
		tqs.setKinds(4);
		String pagestart = request.getParameter("pagestart");
		String pagesize = request.getParameter("pagesize");
		try {
			User u = (User) request.getSession().getAttribute("user");
			if(u.getUsername().startsWith("3")){
				System.out.println("青年");
				s=testQuestionLangService.list(tqs,pagestart,pagesize);
			}else{
				s=testQuestionLangService.listcr(tqs,pagestart,pagesize);
				System.out.println("成年");
			}
			
			if(s.getCount()>0){
				List<TestQuestionLang> list = (List<TestQuestionLang>) s.getDatas();
				TestQuestionLang testQuestionLang=(TestQuestionLang) list.get(0);
				List<TestQuestionAnswer> l = new ArrayList<TestQuestionAnswer>(); 
				if(u.getUsername().startsWith("3")){
					l =testQuestionAcswerService.getlist(testQuestionLang.getId()+"");
				}else{
					l =testQuestionAcswerService.getlistcr(testQuestionLang.getId()+"");
				}
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
	public void linguisiticSave(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="kinds",required=false) Integer kinds){
		User u = (User) request.getSession().getAttribute("user");
		String option_score = request.getParameter("option_score");
		String question_no = request.getParameter("test_no");
		String student_choice = request.getParameter("student_choice");
		String reaction_time = request.getParameter("reaction_time");
		String subject_no = request.getParameter("question_no");
		TestResult tr=new TestResult();
		if(u != null){
			tr.setUser_id(u.getId());
		}
		tr.setSubject_no(Integer.parseInt(subject_no));
		tr.setStudent_choice(student_choice);
		tr.setQuestion_no(Integer.parseInt(question_no));
		tr.setStudent_score(Integer.parseInt(option_score));
		tr.setReaction_time(reaction_time);
		tr.setKinds(kinds);
		List<Map<String, Object>> l = testResultService.executeQuery("select * from test_resilt where user_id=? and question_no=? and subject_no=?", u.getId(),question_no,subject_no);
		if(l.size()==0){
			testResultService.save(tr);
		}
		testResultService.executeUpdate("update test_system_user set xiaotijd=? where id=?", question_no,u.getId());
	}
}
