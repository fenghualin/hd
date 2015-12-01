package com.huanduguihua.manager.controller;

import java.io.IOException;
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
import com.huanduguihua.system.exception.service.ServiceException;

@Controller
@RequestMapping("/questionmanager")
public class QuestionManagerController2 extends DefaultController{

	@Autowired
	TestQuestionLangService2 testQuestionLangService2;
	@Autowired
	TestQuestionAcswerService2 testQuestionAcswerService2;
	
	@RequestMapping(value="questiondata2",method=RequestMethod.POST)
	public void questiondata2(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam("page") Integer page,
			@RequestParam("rows") Integer rows){
		TestOperationbSearch langSearch=new TestOperationbSearch();
		try {
			TestOperationbSearch testOperationbSearch = testQuestionLangService2.list(langSearch, page, rows);
			Long toal = testOperationbSearch.getCount();
			List<TestQuestionLang2> l=(List<TestQuestionLang2>) testOperationbSearch.getDatas();
			JSONObject json = new JSONObject();
			JSONArray arr2 = new JSONArray();
			json.put("total", toal);
			for(int i = 0 ; i < l.size(); i ++ ){
				JSONObject obj = new JSONObject();
				TestQuestionLang2 testQuestionLang2 = (TestQuestionLang2) l.get(i);
				obj.put("id", testQuestionLang2.getId());
				obj.put("name",testQuestionLang2.getKinds());
				obj.put("question_text",testQuestionLang2.getQuestion_text());
				obj.put("inverted", testQuestionLang2.getInverted());
				arr2.put(obj);
			}
			json.put("rows", arr2);
			super.outjson(request, response, json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value="questiondata2cr",method=RequestMethod.POST)
	public void questiondata2cr(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam("page") Integer page,
			@RequestParam("rows") Integer rows){
		TestOperationbSearch langSearch=new TestOperationbSearch();
		try {
			TestOperationbSearch testOperationbSearch = testQuestionLangService2.listcr(langSearch, page, rows);
			Long toal = testOperationbSearch.getCount();
			List<TestQuestionLang2> l=(List<TestQuestionLang2>) testOperationbSearch.getDatas();
			JSONObject json = new JSONObject();
			JSONArray arr2 = new JSONArray();
			json.put("total", toal);
			for(int i = 0 ; i < l.size(); i ++ ){
				JSONObject obj = new JSONObject();
				TestQuestionLang2 testQuestionLang2 = (TestQuestionLang2) l.get(i);
				obj.put("id", testQuestionLang2.getId());
				obj.put("name",testQuestionLang2.getKinds());
				obj.put("question_text",testQuestionLang2.getQuestion_text());
				obj.put("inverted", testQuestionLang2.getInverted());
				arr2.put(obj);
			}
			json.put("rows", arr2);
			super.outjson(request, response, json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 问题管理界面2
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="questionmanagerui2cr",method=RequestMethod.GET)
	public String questionmanagerui2cr(Model model , HttpServletRequest request , HttpServletResponse response){
		
		return "manager/questionmanager2cr";
	}
	/**
	 * 问题管理界面2
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="questionmanagerui2",method=RequestMethod.GET)
	public String questionmanagerui2(Model model , HttpServletRequest request , HttpServletResponse response){
		
		return "manager/questionmanager2";
	}
	
	@RequestMapping(value="questionaddui2",method=RequestMethod.GET)
	public String questionaddui2(Model model,HttpServletRequest request,HttpServletResponse response){
		 return "manager/questionadd2";
	}
	
	/**
	 * 问题2保存
	 * @param model
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="questionsave2",method=RequestMethod.POST)
	public void questionsave2(Model model,HttpServletRequest request,HttpServletResponse response){
		try {
			TestQuestionLang2 testQuestionLang = new TestQuestionLang2();
			Integer testQuestionLangid = testQuestionLangService2.getTableId("test_question_lang2");
			testQuestionLang.setKinds(Integer.parseInt((String)request.getParameter("questionkinds")));
			testQuestionLang.setId(testQuestionLangid);
			testQuestionLang.setQuestion_text((String)request.getParameter("questionleirong"));
			if("true".equals(request.getParameter("questioninverted"))){
				testQuestionLang.setInverted(1);
			}
			else if("false".equals(request.getParameter("questioninverted"))){
				testQuestionLang.setInverted(0);
			}
			testQuestionLangService2.save(testQuestionLang);
			TestQuestionAnswer2 testQuestionAnswer = new TestQuestionAnswer2();
			testQuestionAnswer.setOption_s("A");
			testQuestionAnswer.setOption_score(Integer.parseInt(request.getParameter("pointA")));
			testQuestionAnswer.setOption_text(request.getParameter("answerA"));
			testQuestionAnswer.setQuestion_id(testQuestionLangid);
//			System.out.println("题目id:"+testQuestionAnswer.getQuestion_id());
			testQuestionAcswerService2.save(testQuestionAnswer);
			
			TestQuestionAnswer2 testQuestionAnswerb = new TestQuestionAnswer2();
			testQuestionAnswerb.setOption_s("B");
			testQuestionAnswerb.setOption_score(Integer.parseInt(request.getParameter("pointB")));
			testQuestionAnswerb.setOption_text(request.getParameter("answerB"));
			testQuestionAnswerb.setQuestion_id(testQuestionLangid);
			testQuestionAcswerService2.save(testQuestionAnswerb);
			TestQuestionAnswer2 testQuestionAnswerc = new TestQuestionAnswer2();
			testQuestionAnswerc.setOption_s("C");
			testQuestionAnswerc.setOption_score(Integer.parseInt(request.getParameter("pointC")));
			testQuestionAnswerc.setOption_text(request.getParameter("answerC"));
			testQuestionAnswerc.setQuestion_id(testQuestionLangid);
			testQuestionAcswerService2.save(testQuestionAnswerc);
			TestQuestionAnswer2 testQuestionAnswerD = new TestQuestionAnswer2();
//			System.out.println(Integer.parseInt(request.getParameter("pointD"))+"--"+request.getParameter("answerD"));
			testQuestionAnswerD.setOption_s("D");
			testQuestionAnswerD.setOption_score(Integer.parseInt(request.getParameter("pointD")));
			testQuestionAnswerD.setOption_text(request.getParameter("answerD"));
			testQuestionAnswerD.setQuestion_id(testQuestionLangid);
			testQuestionAcswerService2.save(testQuestionAnswerD);
			TestQuestionAnswer2 testQuestionAnswerE = new TestQuestionAnswer2();
//			System.out.println(Integer.parseInt(request.getParameter("pointE"))+"--"+request.getParameter("answerE"));
			testQuestionAnswerE.setOption_s("E");
			testQuestionAnswerE.setOption_score(Integer.parseInt(request.getParameter("pointE")));
			testQuestionAnswerE.setOption_text(request.getParameter("answerE"));
			testQuestionAnswerE.setQuestion_id(testQuestionLangid);
			testQuestionAcswerService2.save(testQuestionAnswerE);
			super.out(request, response, "ok");
		} catch (Exception e) {
			super.out(request, response, "no");
			e.printStackTrace();
		}
	}
	/**
	 * 问题2保存
	 * @param model
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="questionsave2cr",method=RequestMethod.POST)
	public void questionsave2cr(Model model,HttpServletRequest request,HttpServletResponse response){
		try {
			TestQuestionLang2 testQuestionLang = new TestQuestionLang2();
			Integer testQuestionLangid = testQuestionLangService2.getTableId("test_question_lang2_cr");
			testQuestionLang.setKinds(Integer.parseInt((String)request.getParameter("questionkinds")));
			testQuestionLang.setId(testQuestionLangid);
			testQuestionLang.setQuestion_text((String)request.getParameter("questionleirong"));
			if("true".equals(request.getParameter("questioninverted"))){
				testQuestionLang.setInverted(1);
			}
			else if("false".equals(request.getParameter("questioninverted"))){
				testQuestionLang.setInverted(0);
			}
			testQuestionLangService2.savecr(testQuestionLang);
			TestQuestionAnswer2 testQuestionAnswer = new TestQuestionAnswer2();
			testQuestionAnswer.setOption_s("A");
			testQuestionAnswer.setOption_score(Integer.parseInt(request.getParameter("pointA")));
			testQuestionAnswer.setOption_text(request.getParameter("answerA"));
			testQuestionAnswer.setQuestion_id(testQuestionLangid);
//			System.out.println("题目id:"+testQuestionAnswer.getQuestion_id());
			testQuestionAcswerService2.savecr(testQuestionAnswer);
			
			TestQuestionAnswer2 testQuestionAnswerb = new TestQuestionAnswer2();
			testQuestionAnswerb.setOption_s("B");
			testQuestionAnswerb.setOption_score(Integer.parseInt(request.getParameter("pointB")));
			testQuestionAnswerb.setOption_text(request.getParameter("answerB"));
			testQuestionAnswerb.setQuestion_id(testQuestionLangid);
			testQuestionAcswerService2.savecr(testQuestionAnswerb);
			TestQuestionAnswer2 testQuestionAnswerc = new TestQuestionAnswer2();
			testQuestionAnswerc.setOption_s("C");
			testQuestionAnswerc.setOption_score(Integer.parseInt(request.getParameter("pointC")));
			testQuestionAnswerc.setOption_text(request.getParameter("answerC"));
			testQuestionAnswerc.setQuestion_id(testQuestionLangid);
			testQuestionAcswerService2.savecr(testQuestionAnswerc);
			TestQuestionAnswer2 testQuestionAnswerD = new TestQuestionAnswer2();
//			System.out.println(Integer.parseInt(request.getParameter("pointD"))+"--"+request.getParameter("answerD"));
			testQuestionAnswerD.setOption_s("D");
			testQuestionAnswerD.setOption_score(Integer.parseInt(request.getParameter("pointD")));
			testQuestionAnswerD.setOption_text(request.getParameter("answerD"));
			testQuestionAnswerD.setQuestion_id(testQuestionLangid);
			testQuestionAcswerService2.savecr(testQuestionAnswerD);
			TestQuestionAnswer2 testQuestionAnswerE = new TestQuestionAnswer2();
//			System.out.println(Integer.parseInt(request.getParameter("pointE"))+"--"+request.getParameter("answerE"));
			testQuestionAnswerE.setOption_s("E");
			testQuestionAnswerE.setOption_score(Integer.parseInt(request.getParameter("pointE")));
			testQuestionAnswerE.setOption_text(request.getParameter("answerE"));
			testQuestionAnswerE.setQuestion_id(testQuestionLangid);
			testQuestionAcswerService2.savecr(testQuestionAnswerE);
			super.out(request, response, "ok");
		} catch (Exception e) {
			super.out(request, response, "no");
			e.printStackTrace();
		}
	}
	
	/**
	 * 查看问题详细信息
	 */
	@RequestMapping(value="questionlook2",method=RequestMethod.GET)
	public String questionlook2(Model model,HttpServletRequest request,HttpServletResponse response){
		int qid = Integer.parseInt(request.getParameter("qid"));
		try {
			TestQuestionLang2 testQuestionLang =  testQuestionLangService2.get(qid);
			List<TestQuestionAnswer2> list = testQuestionAcswerService2.questionlists("select * from test_question_answer2 where question_id="+qid);
			if(list.size()>0){
				for(int i = 0 ; i < list.size() ; i++){
					TestQuestionAnswer2 testQuestionAnswer = list.get(i);
					if("A".equals(testQuestionAnswer.getOption_s())){
						request.setAttribute("answerA", testQuestionAnswer.getOption_text());
						request.setAttribute("pointA", testQuestionAnswer.getOption_score());
						request.setAttribute("testQuestionAnswerid", testQuestionAnswer.getId());
					}
					if("B".equals(testQuestionAnswer.getOption_s())){
						request.setAttribute("answerB", testQuestionAnswer.getOption_text());
						request.setAttribute("pointB", testQuestionAnswer.getOption_score());
						request.setAttribute("testQuestionAnswerid", testQuestionAnswer.getId());
					}
					if("C".equals(testQuestionAnswer.getOption_s())){
						request.setAttribute("answerC", testQuestionAnswer.getOption_text());
						request.setAttribute("pointC", testQuestionAnswer.getOption_score());
						request.setAttribute("testQuestionAnswerid", testQuestionAnswer.getId());
					}
					if("D".equals(testQuestionAnswer.getOption_s())){
						request.setAttribute("answerD", testQuestionAnswer.getOption_text());
						request.setAttribute("pointD", testQuestionAnswer.getOption_score());
						request.setAttribute("testQuestionAnswerid", testQuestionAnswer.getId());
					}
					if("E".equals(testQuestionAnswer.getOption_s())){
						request.setAttribute("answerE", testQuestionAnswer.getOption_text());
						request.setAttribute("pointE", testQuestionAnswer.getOption_score());
						request.setAttribute("testQuestionAnswerid", testQuestionAnswer.getId());
					}
				}
			}
			request.setAttribute("qid", testQuestionLang.getId());
			request.setAttribute("qkinds", testQuestionLang.getKinds());
			request.setAttribute("qcontext", testQuestionLang.getQuestion_text());
			request.setAttribute("inverted", testQuestionLang.getInverted());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		 return "manager/questionadd2";
	}
	
	/**
	 * 查看问题详细信息
	 */
	@RequestMapping(value="questionlook2cr",method=RequestMethod.GET)
	public String questionlook2cr(Model model,HttpServletRequest request,HttpServletResponse response){
		int qid = Integer.parseInt(request.getParameter("qid"));
		try {
			TestQuestionLang2 testQuestionLang =  testQuestionLangService2.getcr(qid);
			List<TestQuestionAnswer2> list = testQuestionAcswerService2.questionlists("select * from test_question_answer2_cr where question_id="+qid);
			if(list.size()>0){
				for(int i = 0 ; i < list.size() ; i++){
					TestQuestionAnswer2 testQuestionAnswer = list.get(i);
					if("A".equals(testQuestionAnswer.getOption_s())){
						request.setAttribute("answerA", testQuestionAnswer.getOption_text());
						request.setAttribute("pointA", testQuestionAnswer.getOption_score());
						request.setAttribute("testQuestionAnswerid", testQuestionAnswer.getId());
					}
					if("B".equals(testQuestionAnswer.getOption_s())){
						request.setAttribute("answerB", testQuestionAnswer.getOption_text());
						request.setAttribute("pointB", testQuestionAnswer.getOption_score());
						request.setAttribute("testQuestionAnswerid", testQuestionAnswer.getId());
					}
					if("C".equals(testQuestionAnswer.getOption_s())){
						request.setAttribute("answerC", testQuestionAnswer.getOption_text());
						request.setAttribute("pointC", testQuestionAnswer.getOption_score());
						request.setAttribute("testQuestionAnswerid", testQuestionAnswer.getId());
					}
					if("D".equals(testQuestionAnswer.getOption_s())){
						request.setAttribute("answerD", testQuestionAnswer.getOption_text());
						request.setAttribute("pointD", testQuestionAnswer.getOption_score());
						request.setAttribute("testQuestionAnswerid", testQuestionAnswer.getId());
					}
					if("E".equals(testQuestionAnswer.getOption_s())){
						request.setAttribute("answerE", testQuestionAnswer.getOption_text());
						request.setAttribute("pointE", testQuestionAnswer.getOption_score());
						request.setAttribute("testQuestionAnswerid", testQuestionAnswer.getId());
					}
				}
			}
			request.setAttribute("qid", testQuestionLang.getId());
			request.setAttribute("qkinds", testQuestionLang.getKinds());
			request.setAttribute("qcontext", testQuestionLang.getQuestion_text());
			request.setAttribute("inverted", testQuestionLang.getInverted());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "manager/questionadd2";
	}
	
	/**
	 * 问题删除
	 */
	@RequestMapping(value="questiondelete2",method=RequestMethod.POST)
	public void questiondelete2(Model model,HttpServletRequest request,HttpServletResponse response){
		String s = request.getParameter("qid");
		String [] sid = s.split(",");
		for(int i=0;i<sid.length;i++){
			try {
				testQuestionLangService2.delete(Integer.parseInt(sid[i]));
				testQuestionAcswerService2.deletes(Integer.parseInt(sid[i]));
				super.out(request, response, "ok");
			} catch (Exception e) {
				super.out(request, response, "no");
				e.printStackTrace();
			}
		}
	}
	/**
	 * 问题删除
	 */
	@RequestMapping(value="questiondelete2cr",method=RequestMethod.POST)
	public void questiondelete2cr(Model model,HttpServletRequest request,HttpServletResponse response){
		String s = request.getParameter("qid");
		String [] sid = s.split(",");
		for(int i=0;i<sid.length;i++){
			try {
				testQuestionLangService2.deletecr(Integer.parseInt(sid[i]));
				testQuestionAcswerService2.deletescr(Integer.parseInt(sid[i]));
				super.out(request, response, "ok");
			} catch (Exception e) {
				super.out(request, response, "no");
				e.printStackTrace();
			}
		}
	}

	/**
	 * 问题2修改page
	 */
	@RequestMapping(value="questionupdatepage2",method=RequestMethod.GET)
	public String questionupdatepage2(Model model,HttpServletRequest request,HttpServletResponse response){
		int qid = Integer.parseInt(request.getParameter("qid"));
		try {
			TestQuestionLang2 testQuestionLang =  testQuestionLangService2.get(qid);
			List<TestQuestionAnswer2> list = testQuestionAcswerService2.questionlists("select id,option_s,option_text,option_score,question_id from test_question_answer2 where question_id="+qid);
			if(list.size()>0){
				for(int i = 0 ; i < list.size() ; i++){
					TestQuestionAnswer2 testQuestionAnswer = list.get(i);
					if("A".equals(testQuestionAnswer.getOption_s())){
						request.setAttribute("answerA", testQuestionAnswer.getOption_text());
						request.setAttribute("pointA", testQuestionAnswer.getOption_score());
						request.setAttribute("testQuestionAnswerid", testQuestionAnswer.getId());
					}
					if("B".equals(testQuestionAnswer.getOption_s())){
						request.setAttribute("answerB", testQuestionAnswer.getOption_text());
						request.setAttribute("pointB", testQuestionAnswer.getOption_score());
						request.setAttribute("testQuestionAnswerid", testQuestionAnswer.getId());
					}
					if("C".equals(testQuestionAnswer.getOption_s())){
						request.setAttribute("answerC", testQuestionAnswer.getOption_text());
						request.setAttribute("pointC", testQuestionAnswer.getOption_score());
						request.setAttribute("testQuestionAnswerid", testQuestionAnswer.getId());
					}
					if("D".equals(testQuestionAnswer.getOption_s())){
						request.setAttribute("answerD", testQuestionAnswer.getOption_text());
						request.setAttribute("pointD", testQuestionAnswer.getOption_score());
						request.setAttribute("testQuestionAnswerid", testQuestionAnswer.getId());
					}
					if("E".equals(testQuestionAnswer.getOption_s())){
						request.setAttribute("answerE", testQuestionAnswer.getOption_text());
						request.setAttribute("pointE", testQuestionAnswer.getOption_score());
						request.setAttribute("testQuestionAnswerid", testQuestionAnswer.getId());
					}
				}
			}
			request.setAttribute("qid", testQuestionLang.getId());
			request.setAttribute("qkinds", testQuestionLang.getKinds());
			request.setAttribute("qcontext", testQuestionLang.getQuestion_text());
			request.setAttribute("inverted", testQuestionLang.getInverted());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		 return "manager/questionUpdate2";
	}
	/**
	 * 问题2修改page
	 */
	@RequestMapping(value="questionupdatepage2cr",method=RequestMethod.GET)
	public String questionupdatepage2cr(Model model,HttpServletRequest request,HttpServletResponse response){
		int qid = Integer.parseInt(request.getParameter("qid"));
		try {
			TestQuestionLang2 testQuestionLang =  testQuestionLangService2.getcr(qid);
			List<TestQuestionAnswer2> list = testQuestionAcswerService2.questionlists("select id,option_s,option_text,option_score,question_id from test_question_answer2_cr where question_id="+qid);
			if(list.size()>0){
				for(int i = 0 ; i < list.size() ; i++){
					TestQuestionAnswer2 testQuestionAnswer = list.get(i);
					if("A".equals(testQuestionAnswer.getOption_s())){
						request.setAttribute("answerA", testQuestionAnswer.getOption_text());
						request.setAttribute("pointA", testQuestionAnswer.getOption_score());
						request.setAttribute("testQuestionAnswerid", testQuestionAnswer.getId());
					}
					if("B".equals(testQuestionAnswer.getOption_s())){
						request.setAttribute("answerB", testQuestionAnswer.getOption_text());
						request.setAttribute("pointB", testQuestionAnswer.getOption_score());
						request.setAttribute("testQuestionAnswerid", testQuestionAnswer.getId());
					}
					if("C".equals(testQuestionAnswer.getOption_s())){
						request.setAttribute("answerC", testQuestionAnswer.getOption_text());
						request.setAttribute("pointC", testQuestionAnswer.getOption_score());
						request.setAttribute("testQuestionAnswerid", testQuestionAnswer.getId());
					}
					if("D".equals(testQuestionAnswer.getOption_s())){
						request.setAttribute("answerD", testQuestionAnswer.getOption_text());
						request.setAttribute("pointD", testQuestionAnswer.getOption_score());
						request.setAttribute("testQuestionAnswerid", testQuestionAnswer.getId());
					}
					if("E".equals(testQuestionAnswer.getOption_s())){
						request.setAttribute("answerE", testQuestionAnswer.getOption_text());
						request.setAttribute("pointE", testQuestionAnswer.getOption_score());
						request.setAttribute("testQuestionAnswerid", testQuestionAnswer.getId());
					}
				}
			}
			request.setAttribute("qid", testQuestionLang.getId());
			request.setAttribute("qkinds", testQuestionLang.getKinds());
			request.setAttribute("qcontext", testQuestionLang.getQuestion_text());
			request.setAttribute("inverted", testQuestionLang.getInverted());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		 return "manager/questionUpdate2";
	}
	/**
	 * 问题修改
	 */
	@RequestMapping(value="questionUpdate2",method=RequestMethod.POST)
	public void questionUpdate2(Model model,HttpServletRequest request,HttpServletResponse response){
		try {
		TestQuestionLang2 testQuestionLang = new TestQuestionLang2();
		Integer testQuestionLangid = Integer.parseInt(request.getParameter("questionid"));
		testQuestionLang.setId(testQuestionLangid);
		testQuestionLang.setKinds(Integer.parseInt((String)request.getParameter("questionkinds")));
		testQuestionLang.setQuestion_text((String)request.getParameter("questionleirong"));
		if("true".equals(request.getParameter("questioninverted"))){
			testQuestionLang.setInverted(1);
		}
		else if("false".equals(request.getParameter("questioninverted"))){
			testQuestionLang.setInverted(0);
		}
		TestQuestionAnswer2 testQuestionAnswer = new TestQuestionAnswer2();
		
		testQuestionAnswer.setOption_s("A");
		testQuestionAnswer.setOption_score(Integer.parseInt(request.getParameter("pointA")));
		testQuestionAnswer.setOption_text(request.getParameter("answerA"));
		testQuestionAnswer.setQuestion_id(testQuestionLangid);
		TestQuestionAnswer2 testQuestionAnswerb = new TestQuestionAnswer2();
		testQuestionAnswerb.setOption_s("B");
		testQuestionAnswerb.setOption_score(Integer.parseInt(request.getParameter("pointB")));
		testQuestionAnswerb.setOption_text(request.getParameter("answerB"));
		testQuestionAnswerb.setQuestion_id(testQuestionLangid);
		
		TestQuestionAnswer2 testQuestionAnswerc = new TestQuestionAnswer2();
		testQuestionAnswerc.setOption_s("C");
		testQuestionAnswerc.setOption_score(Integer.parseInt(request.getParameter("pointC")));
		testQuestionAnswerc.setOption_text(request.getParameter("answerC"));
		testQuestionAnswerc.setQuestion_id(testQuestionLangid);
		
		TestQuestionAnswer2 testQuestionAnswerD = new TestQuestionAnswer2();
		testQuestionAnswerD.setOption_s("D");
		testQuestionAnswerD.setOption_score(Integer.parseInt(request.getParameter("pointD")));
		testQuestionAnswerD.setOption_text(request.getParameter("answerD"));
		testQuestionAnswerD.setQuestion_id(testQuestionLangid);
		
		TestQuestionAnswer2 testQuestionAnswerE = new TestQuestionAnswer2();
		testQuestionAnswerE.setOption_s("E");
		testQuestionAnswerE.setOption_score(Integer.parseInt(request.getParameter("pointE")));
		testQuestionAnswerE.setOption_text(request.getParameter("answerE"));
		testQuestionAnswerE.setQuestion_id(testQuestionLangid);
		testQuestionLangService2.update(testQuestionLang);
		testQuestionAcswerService2.update(testQuestionAnswer);
		testQuestionAcswerService2.update(testQuestionAnswerb);
		testQuestionAcswerService2.update(testQuestionAnswerc);
		testQuestionAcswerService2.update(testQuestionAnswerD);
		testQuestionAcswerService2.update(testQuestionAnswerE);
		super.out(request, response, "ok");
		} catch (Exception e) {
			super.out(request, response, "no");
			e.printStackTrace();
		}
	}
	/**
	 * 问题修改
	 */
	@RequestMapping(value="questionUpdate2cr",method=RequestMethod.POST)
	public void questionUpdate2cr(Model model,HttpServletRequest request,HttpServletResponse response){
		try {
			TestQuestionLang2 testQuestionLang = new TestQuestionLang2();
			Integer testQuestionLangid = Integer.parseInt(request.getParameter("questionid"));
			testQuestionLang.setId(testQuestionLangid);
			testQuestionLang.setKinds(Integer.parseInt((String)request.getParameter("questionkinds")));
			testQuestionLang.setQuestion_text((String)request.getParameter("questionleirong"));
			if("true".equals(request.getParameter("questioninverted"))){
				testQuestionLang.setInverted(1);
			}
			else if("false".equals(request.getParameter("questioninverted"))){
				testQuestionLang.setInverted(0);
			}
			TestQuestionAnswer2 testQuestionAnswer = new TestQuestionAnswer2();
			
			testQuestionAnswer.setOption_s("A");
			testQuestionAnswer.setOption_score(Integer.parseInt(request.getParameter("pointA")));
			testQuestionAnswer.setOption_text(request.getParameter("answerA"));
			testQuestionAnswer.setQuestion_id(testQuestionLangid);
			TestQuestionAnswer2 testQuestionAnswerb = new TestQuestionAnswer2();
			testQuestionAnswerb.setOption_s("B");
			testQuestionAnswerb.setOption_score(Integer.parseInt(request.getParameter("pointB")));
			testQuestionAnswerb.setOption_text(request.getParameter("answerB"));
			testQuestionAnswerb.setQuestion_id(testQuestionLangid);
			
			TestQuestionAnswer2 testQuestionAnswerc = new TestQuestionAnswer2();
			testQuestionAnswerc.setOption_s("C");
			testQuestionAnswerc.setOption_score(Integer.parseInt(request.getParameter("pointC")));
			testQuestionAnswerc.setOption_text(request.getParameter("answerC"));
			testQuestionAnswerc.setQuestion_id(testQuestionLangid);
			
			TestQuestionAnswer2 testQuestionAnswerD = new TestQuestionAnswer2();
			testQuestionAnswerD.setOption_s("D");
			testQuestionAnswerD.setOption_score(Integer.parseInt(request.getParameter("pointD")));
			testQuestionAnswerD.setOption_text(request.getParameter("answerD"));
			testQuestionAnswerD.setQuestion_id(testQuestionLangid);
			
			TestQuestionAnswer2 testQuestionAnswerE = new TestQuestionAnswer2();
			testQuestionAnswerE.setOption_s("E");
			testQuestionAnswerE.setOption_score(Integer.parseInt(request.getParameter("pointE")));
			testQuestionAnswerE.setOption_text(request.getParameter("answerE"));
			testQuestionAnswerE.setQuestion_id(testQuestionLangid);
			testQuestionLangService2.updatecr(testQuestionLang);
			testQuestionAcswerService2.updatecr(testQuestionAnswer);
			testQuestionAcswerService2.updatecr(testQuestionAnswerb);
			testQuestionAcswerService2.updatecr(testQuestionAnswerc);
			testQuestionAcswerService2.updatecr(testQuestionAnswerD);
			testQuestionAcswerService2.updatecr(testQuestionAnswerE);
			super.out(request, response, "ok");
		} catch (Exception e) {
			super.out(request, response, "no");
			e.printStackTrace();
		}
	}
}

