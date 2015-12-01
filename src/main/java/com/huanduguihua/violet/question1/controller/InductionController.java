package com.huanduguihua.violet.question1.controller;

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
import com.huanduguihua.system.controller.DefaultController;
import com.huanduguihua.user.bean.User;
import com.huanduguihua.violet.question1.bean.Induction;
import com.huanduguihua.violet.question1.service.InductionService;

@Controller
@RequestMapping("/violet/induction")
public class InductionController extends DefaultController {

	@Autowired
	InductionService inductionService;
	@Autowired
	TestQuestionLangService testQuestionLangService;
	@Autowired
	TestQuestionAcswerService testQuestionAcswerService;
	
	@RequestMapping(value="inductionsave",method=RequestMethod.POST)
	public void inductionsave(Model model , HttpServletRequest request , HttpServletResponse response,
			@RequestParam("question_no") Integer questionNo,
			@RequestParam("student_choicea") Integer studentChoicea,
			@RequestParam("student_choiceb") Integer studentChoiceb,
			@RequestParam("reaction_time") String reactionTime,
			@RequestParam("student_score") Integer studentScore){
		
		User user = super.getSessionUser(request);
		
		Induction induction = new Induction();
		
		if(user != null){
			induction.setUser_id(user.getId());
		}
		
		induction.setQuestion_no(questionNo);
		induction.setStudent_choicea(studentChoicea);
		induction.setStudent_choiceb(studentChoiceb);
		induction.setReaction_time(reactionTime);
		induction.setStudent_score(studentScore);
		List<Map<String, Object>> l = inductionService.executeQuery("select * from test_induction where user_id=? and question_no=?", user.getId(),questionNo);
		if(l.size()==0)
		inductionService.save(induction);
		inductionService.executeUpdate("update test_system_user set xiaotijd=? where id=?", questionNo,user.getId());
		
	}
	
	@RequestMapping(value="Questiondatas",method=RequestMethod.POST)
	public void Questiondatas(Model model,HttpServletRequest request,HttpServletResponse response){
		TestQuestionLangSearch tqs = new TestQuestionLangSearch();
		TestQuestionLangSearch s = new TestQuestionLangSearch();
		tqs.setKinds(1);
		String pagestart = request.getParameter("pagestart");
		String pagesize = request.getParameter("pagesize");
		try {
			User u = (User) request.getSession().getAttribute("user");
			System.out.println("username="+u.getUsername());
			if(u.getUsername().startsWith("3")){
				 s=testQuestionLangService.list(tqs,pagestart,pagesize);
			}else{
				 s=testQuestionLangService.listcr(tqs,pagestart,pagesize);
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
}
