package com.huanduguihua.manager.controller;


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

import com.huanduguihua.manager.bean.TestQuestionAnswer;
import com.huanduguihua.manager.bean.TestQuestionLang;
import com.huanduguihua.manager.bean.search.TestQuestionLangSearch;
import com.huanduguihua.manager.service.TestQuestionAcswerService;
import com.huanduguihua.manager.service.TestQuestionLangService;
import com.huanduguihua.system.controller.DefaultController;
import com.huanduguihua.system.exception.service.ServiceException;

/**
 * 
 * @author liusen
 */
@Controller
@RequestMapping("/questionman")
public class QuestionManagerController extends DefaultController{
	@Autowired
	TestQuestionLangService testQuestionLangService;
	@Autowired
	TestQuestionAcswerService testQuestionAcswerService; 
	/**
	 * 后台主界面
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="gomain",method=RequestMethod.GET)
	public String gomain(Model model,HttpServletRequest request,HttpServletResponse response){
		 return "manager/main";
	}
	/**
	 * 问题管理界面
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="questionmanagerui",method=RequestMethod.GET)
	public String questionmanagerui(Model model,HttpServletRequest request,HttpServletResponse response){
		 return "manager/questionmanager";
	}
	/**
	 * 问题管理界面成人版
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="questionmanageruicr",method=RequestMethod.GET)
	public String questionmanageruicr(Model model,HttpServletRequest request,HttpServletResponse response){
		 return "manager/questionmanagercr";
	}
	
	/**
	 * 问题管理界面数据
	 * @param model
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="questiondata",method=RequestMethod.POST)
	public void questiondata(Model model,HttpServletRequest request,HttpServletResponse response){
		Integer page = Integer.parseInt(request.getParameter("page"));
		Integer rows = Integer.parseInt(request.getParameter("rows"));
		TestQuestionLangSearch langSearch=new TestQuestionLangSearch();
		try {
			TestQuestionLangSearch testQuestionLangSearch = testQuestionLangService.list(langSearch, page+"", rows+"");
			Long toal = testQuestionLangSearch.getCount();
			List<TestQuestionLang> l=(List<TestQuestionLang>) testQuestionLangSearch.getDatas();
			JSONObject json = new JSONObject();
			JSONArray arr2 = new JSONArray();
			json.put("total", toal);
				for(int i = 0 ; i < l.size(); i ++ ){
					JSONObject obj = new JSONObject();
					TestQuestionLang testQuestionLang = (TestQuestionLang) l.get(i);
					obj.put("id", testQuestionLang.getId());
					obj.put("name",testQuestionLang.getKinds());
					obj.put("question_text", testQuestionLang.getQuestion_text());
					arr2.put(obj);
				}
				json.put("rows", arr2);
			super.outjson(request, response, json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 问题管理界面数据
	 * @param model
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="questiondatacr",method=RequestMethod.POST)
	public void questiondatacr(Model model,HttpServletRequest request,HttpServletResponse response){
		Integer page = Integer.parseInt(request.getParameter("page"));
		Integer rows = Integer.parseInt(request.getParameter("rows"));
		TestQuestionLangSearch langSearch=new TestQuestionLangSearch();
		try {
			TestQuestionLangSearch testQuestionLangSearch = testQuestionLangService.listcr(langSearch, page+"", rows+"");
			Long toal = testQuestionLangSearch.getCount();
			List<TestQuestionLang> l=(List<TestQuestionLang>) testQuestionLangSearch.getDatas();
			JSONObject json = new JSONObject();
			JSONArray arr2 = new JSONArray();
			json.put("total", toal);
				for(int i = 0 ; i < l.size(); i ++ ){
					JSONObject obj = new JSONObject();
					TestQuestionLang testQuestionLang = (TestQuestionLang) l.get(i);
					obj.put("id", testQuestionLang.getId());
					obj.put("name",testQuestionLang.getKinds());
					obj.put("question_text", testQuestionLang.getQuestion_text());
					arr2.put(obj);
				}
				json.put("rows", arr2);
			super.outjson(request, response, json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 问题添加界面
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="questionaddui",method=RequestMethod.GET)
	public String questionaddui(Model model,HttpServletRequest request,HttpServletResponse response){
		 return "manager/questionadd";
	}
	/**
	 * 问题提交保存
	 */
	@RequestMapping(value="questionsave",method=RequestMethod.POST)
	public void questionsave(Model model,HttpServletRequest request,HttpServletResponse response){
		try {
			TestQuestionLang testQuestionLang = new TestQuestionLang();
			Integer testQuestionLangid = testQuestionLangService.getTableId("test_question_lang");
			testQuestionLang.setId(testQuestionLangid);
			testQuestionLang.setKinds(Integer.parseInt((String)request.getParameter("questionkinds")));
			testQuestionLang.setQuestion_text((String)request.getParameter("questionleirong"));
			
			Integer testquestionAnswerid = testQuestionAcswerService.getTableId("test_question_answer");
			TestQuestionAnswer testQuestionAnswer = new TestQuestionAnswer();
			testQuestionAnswer.setId(testquestionAnswerid);
			testQuestionAnswer.setOption_s("A");
			testQuestionAnswer.setOption_score(Integer.parseInt(request.getParameter("pointA")));
			testQuestionAnswer.setOption_text(request.getParameter("answerA"));
			testQuestionAnswer.setQuestion_id(testQuestionLangid);
			
			TestQuestionAnswer testQuestionAnswerb = new TestQuestionAnswer();
			testQuestionAnswerb.setId(testquestionAnswerid+1);
			testQuestionAnswerb.setOption_s("B");
			testQuestionAnswerb.setOption_score(Integer.parseInt(request.getParameter("pointB")));
			testQuestionAnswerb.setOption_text(request.getParameter("answerB"));
			testQuestionAnswerb.setQuestion_id(testQuestionLangid);
			
			TestQuestionAnswer testQuestionAnswerc = new TestQuestionAnswer();
			testQuestionAnswerc.setId(testquestionAnswerid+2);
			testQuestionAnswerc.setOption_s("C");
			testQuestionAnswerc.setOption_score(Integer.parseInt(request.getParameter("pointC")));
			testQuestionAnswerc.setOption_text(request.getParameter("answerC"));
			testQuestionAnswerc.setQuestion_id(testQuestionLangid);
			
			TestQuestionAnswer testQuestionAnswerD = new TestQuestionAnswer();
			testQuestionAnswerD.setId(testquestionAnswerid+3);
			testQuestionAnswerD.setOption_s("D");
			testQuestionAnswerD.setOption_score(Integer.parseInt(request.getParameter("pointD")));
			testQuestionAnswerD.setOption_text(request.getParameter("answerD"));
			testQuestionAnswerD.setQuestion_id(testQuestionLangid);
			testQuestionAcswerService.save(testQuestionAnswer);
			testQuestionAcswerService.save(testQuestionAnswerb);
			testQuestionAcswerService.save(testQuestionAnswerc);
			testQuestionAcswerService.save(testQuestionAnswerD);
			testQuestionLangService.save(testQuestionLang);
			super.out(request, response, "ok");
		} catch (Exception e) {
			super.out(request, response, "no");
			e.printStackTrace();
		}
	}
	/**
	 * 问题提交保存
	 */
	@RequestMapping(value="questionsavecr",method=RequestMethod.POST)
	public void questionsavecr(Model model,HttpServletRequest request,HttpServletResponse response){
		try {
			TestQuestionLang testQuestionLang = new TestQuestionLang();
			Integer testQuestionLangid = testQuestionLangService.getTableId("test_question_lang_cr");
			testQuestionLang.setId(testQuestionLangid);
			testQuestionLang.setKinds(Integer.parseInt((String)request.getParameter("questionkinds")));
			testQuestionLang.setQuestion_text((String)request.getParameter("questionleirong"));
			
			Integer testquestionAnswerid = testQuestionAcswerService.getTableId("test_question_answer_cr");
			TestQuestionAnswer testQuestionAnswer = new TestQuestionAnswer();
			testQuestionAnswer.setId(testquestionAnswerid);
			testQuestionAnswer.setOption_s("A");
			testQuestionAnswer.setOption_score(Integer.parseInt(request.getParameter("pointA")));
			testQuestionAnswer.setOption_text(request.getParameter("answerA"));
			testQuestionAnswer.setQuestion_id(testQuestionLangid);
			
			TestQuestionAnswer testQuestionAnswerb = new TestQuestionAnswer();
			testQuestionAnswerb.setId(testquestionAnswerid+1);
			testQuestionAnswerb.setOption_s("B");
			testQuestionAnswerb.setOption_score(Integer.parseInt(request.getParameter("pointB")));
			testQuestionAnswerb.setOption_text(request.getParameter("answerB"));
			testQuestionAnswerb.setQuestion_id(testQuestionLangid);
			
			TestQuestionAnswer testQuestionAnswerc = new TestQuestionAnswer();
			testQuestionAnswerc.setId(testquestionAnswerid+2);
			testQuestionAnswerc.setOption_s("C");
			testQuestionAnswerc.setOption_score(Integer.parseInt(request.getParameter("pointC")));
			testQuestionAnswerc.setOption_text(request.getParameter("answerC"));
			testQuestionAnswerc.setQuestion_id(testQuestionLangid);
			
			TestQuestionAnswer testQuestionAnswerD = new TestQuestionAnswer();
			testQuestionAnswerD.setId(testquestionAnswerid+3);
			testQuestionAnswerD.setOption_s("D");
			testQuestionAnswerD.setOption_score(Integer.parseInt(request.getParameter("pointD")));
			testQuestionAnswerD.setOption_text(request.getParameter("answerD"));
			testQuestionAnswerD.setQuestion_id(testQuestionLangid);
			testQuestionAcswerService.savecr(testQuestionAnswer);
			testQuestionAcswerService.savecr(testQuestionAnswerb);
			testQuestionAcswerService.savecr(testQuestionAnswerc);
			testQuestionAcswerService.savecr(testQuestionAnswerD);
			testQuestionLangService.savecr(testQuestionLang);
			super.out(request, response, "ok");
		} catch (Exception e) {
			super.out(request, response, "no");
			e.printStackTrace();
		}
	}
	/**
	 * 问题删除
	 */
	@RequestMapping(value="questiondelete",method=RequestMethod.POST)
	public void questiondelete(Model model,HttpServletRequest request,HttpServletResponse response){
		String s = request.getParameter("qid");
		String [] sid = s.split(",");
		for(int i=0;i<sid.length;i++){
			try {
				testQuestionLangService.delete(Integer.parseInt(sid[i]));
				testQuestionAcswerService.deletes(Integer.parseInt(sid[i]));
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
	@RequestMapping(value="questiondeletecr",method=RequestMethod.POST)
	public void questiondeletecr(Model model,HttpServletRequest request,HttpServletResponse response){
		String s = request.getParameter("qid");
		String [] sid = s.split(",");
		for(int i=0;i<sid.length;i++){
			try {
				testQuestionLangService.deletecr(Integer.parseInt(sid[i]));
				testQuestionAcswerService.deletescr(Integer.parseInt(sid[i]));
				super.out(request, response, "ok");
			} catch (Exception e) {
				super.out(request, response, "no");
				e.printStackTrace();
			}
		}
			
	}
	/**
	 * 查看问题详细信息
	 */
	@RequestMapping(value="questionlook",method=RequestMethod.GET)
	public String questionlook(Model model,HttpServletRequest request,HttpServletResponse response){
		int qid = Integer.parseInt(request.getParameter("qid"));
		try {
			TestQuestionLang testQuestionLang =  testQuestionLangService.get(qid);
			List<TestQuestionAnswer> list = testQuestionAcswerService.questionlists("select id,option_s,option_text,option_score,question_id from test_question_answer where question_id="+qid);
			if(list.size()>0){
				for(int i = 0 ; i < list.size() ; i++){
					TestQuestionAnswer testQuestionAnswer = list.get(i);
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
				}
			}
			request.setAttribute("qid", testQuestionLang.getId());
			request.setAttribute("qkinds", testQuestionLang.getKinds());
			request.setAttribute("qcontext", testQuestionLang.getQuestion_text());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		 return "manager/questionadd";
	}
	/**
	 * 查看问题详细信息
	 */
	@RequestMapping(value="questionlookcr",method=RequestMethod.GET)
	public String questionlookcr(Model model,HttpServletRequest request,HttpServletResponse response){
		int qid = Integer.parseInt(request.getParameter("qid"));
		try {
			TestQuestionLang testQuestionLang =  testQuestionLangService.getcr(qid);
			List<TestQuestionAnswer> list = testQuestionAcswerService.questionlists("select id,option_s,option_text,option_score,question_id from test_question_answer_cr where question_id="+qid);
			if(list.size()>0){
				for(int i = 0 ; i < list.size() ; i++){
					TestQuestionAnswer testQuestionAnswer = list.get(i);
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
				}
			}
			request.setAttribute("qid", testQuestionLang.getId());
			request.setAttribute("qkinds", testQuestionLang.getKinds());
			request.setAttribute("qcontext", testQuestionLang.getQuestion_text());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "manager/questionadd";
	}
	/**
	 * 问题修改page
	 */
	@RequestMapping(value="questionupdatepage",method=RequestMethod.GET)
	public String questionupdatepage(Model model,HttpServletRequest request,HttpServletResponse response){
		int qid = Integer.parseInt(request.getParameter("qid"));
		try {
			TestQuestionLang testQuestionLang =  testQuestionLangService.get(qid);
			List<TestQuestionAnswer> list = testQuestionAcswerService.questionlists("select id,option_s,option_text,option_score,question_id from test_question_answer where question_id="+qid);
			if(list.size()>0){
				for(int i = 0 ; i < list.size() ; i++){
					TestQuestionAnswer testQuestionAnswer = list.get(i);
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
				}
			}
			request.setAttribute("qid", testQuestionLang.getId());
			request.setAttribute("qkinds", testQuestionLang.getKinds());
			request.setAttribute("qcontext", testQuestionLang.getQuestion_text());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		 return "manager/questionUpdate";
	}
	/**
	 * 问题修改page
	 */
	@RequestMapping(value="questionupdatepagecr",method=RequestMethod.GET)
	public String questionupdatepagecr(Model model,HttpServletRequest request,HttpServletResponse response){
		int qid = Integer.parseInt(request.getParameter("qid"));
		try {
			TestQuestionLang testQuestionLang =  testQuestionLangService.getcr(qid);
			List<TestQuestionAnswer> list = testQuestionAcswerService.questionlists("select id,option_s,option_text,option_score,question_id from test_question_answer_cr where question_id="+qid);
			if(list.size()>0){
				for(int i = 0 ; i < list.size() ; i++){
					TestQuestionAnswer testQuestionAnswer = list.get(i);
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
				}
			}
			request.setAttribute("qid", testQuestionLang.getId());
			request.setAttribute("qkinds", testQuestionLang.getKinds());
			request.setAttribute("qcontext", testQuestionLang.getQuestion_text());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "manager/questionUpdate";
	}
	/**
	 * 问题修改
	 */
	@RequestMapping(value="questionUpdate",method=RequestMethod.POST)
	public void questionUpdate(Model model,HttpServletRequest request,HttpServletResponse response){
		try {
		TestQuestionLang testQuestionLang = new TestQuestionLang();
		Integer testQuestionLangid = Integer.parseInt(request.getParameter("questionid"));
		testQuestionLang.setId(testQuestionLangid);
		testQuestionLang.setKinds(Integer.parseInt((String)request.getParameter("questionkinds")));
		testQuestionLang.setQuestion_text((String)request.getParameter("questionleirong"));
		TestQuestionAnswer testQuestionAnswer = new TestQuestionAnswer();
		
		testQuestionAnswer.setOption_s("A");
		testQuestionAnswer.setOption_score(Integer.parseInt(request.getParameter("pointA")));
		testQuestionAnswer.setOption_text(request.getParameter("answerA"));
		testQuestionAnswer.setQuestion_id(testQuestionLangid);
		TestQuestionAnswer testQuestionAnswerb = new TestQuestionAnswer();
		testQuestionAnswerb.setOption_s("B");
		testQuestionAnswerb.setOption_score(Integer.parseInt(request.getParameter("pointB")));
		testQuestionAnswerb.setOption_text(request.getParameter("answerB"));
		testQuestionAnswerb.setQuestion_id(testQuestionLangid);
		
		TestQuestionAnswer testQuestionAnswerc = new TestQuestionAnswer();
		testQuestionAnswerc.setOption_s("C");
		testQuestionAnswerc.setOption_score(Integer.parseInt(request.getParameter("pointC")));
		testQuestionAnswerc.setOption_text(request.getParameter("answerC"));
		testQuestionAnswerc.setQuestion_id(testQuestionLangid);
		
		TestQuestionAnswer testQuestionAnswerD = new TestQuestionAnswer();
		testQuestionAnswerD.setOption_s("D");
		testQuestionAnswerD.setOption_score(Integer.parseInt(request.getParameter("pointD")));
		testQuestionAnswerD.setOption_text(request.getParameter("answerD"));
		testQuestionAnswerD.setQuestion_id(testQuestionLangid);
//		System.out.println(testQuestionAnswer.getOption_s()+"--"+testQuestionAnswer.getOption_text()+"--"+testQuestionAnswer.getOption_score()+""+"--"+testQuestionAnswer.getQuestion_id()+"");
//		System.out.println(testQuestionAnswer.getOption_s()+"--"+testQuestionAnswerb.getOption_text()+"--"+testQuestionAnswerb.getOption_score()+""+"--"+testQuestionAnswerb.getQuestion_id()+"");
		testQuestionLangService.update(testQuestionLang);
		testQuestionAcswerService.update(testQuestionAnswer);
		testQuestionAcswerService.update(testQuestionAnswerb);
		testQuestionAcswerService.update(testQuestionAnswerc);
		testQuestionAcswerService.update(testQuestionAnswerD);
		super.out(request, response, "ok");
		} catch (Exception e) {
			super.out(request, response, "no");
			e.printStackTrace();
		}
	}
	/**
	 * 问题修改
	 */
	@RequestMapping(value="questionUpdatecr",method=RequestMethod.POST)
	public void questionUpdatecr(Model model,HttpServletRequest request,HttpServletResponse response){
		try {
			TestQuestionLang testQuestionLang = new TestQuestionLang();
			Integer testQuestionLangid = Integer.parseInt(request.getParameter("questionid"));
			testQuestionLang.setId(testQuestionLangid);
			testQuestionLang.setKinds(Integer.parseInt((String)request.getParameter("questionkinds")));
			testQuestionLang.setQuestion_text((String)request.getParameter("questionleirong"));
			TestQuestionAnswer testQuestionAnswer = new TestQuestionAnswer();
			
			testQuestionAnswer.setOption_s("A");
			testQuestionAnswer.setOption_score(Integer.parseInt(request.getParameter("pointA")));
			testQuestionAnswer.setOption_text(request.getParameter("answerA"));
			testQuestionAnswer.setQuestion_id(testQuestionLangid);
			TestQuestionAnswer testQuestionAnswerb = new TestQuestionAnswer();
			testQuestionAnswerb.setOption_s("B");
			testQuestionAnswerb.setOption_score(Integer.parseInt(request.getParameter("pointB")));
			testQuestionAnswerb.setOption_text(request.getParameter("answerB"));
			testQuestionAnswerb.setQuestion_id(testQuestionLangid);
			
			TestQuestionAnswer testQuestionAnswerc = new TestQuestionAnswer();
			testQuestionAnswerc.setOption_s("C");
			testQuestionAnswerc.setOption_score(Integer.parseInt(request.getParameter("pointC")));
			testQuestionAnswerc.setOption_text(request.getParameter("answerC"));
			testQuestionAnswerc.setQuestion_id(testQuestionLangid);
			
			TestQuestionAnswer testQuestionAnswerD = new TestQuestionAnswer();
			testQuestionAnswerD.setOption_s("D");
			testQuestionAnswerD.setOption_score(Integer.parseInt(request.getParameter("pointD")));
			testQuestionAnswerD.setOption_text(request.getParameter("answerD"));
			testQuestionAnswerD.setQuestion_id(testQuestionLangid);
//		System.out.println(testQuestionAnswer.getOption_s()+"--"+testQuestionAnswer.getOption_text()+"--"+testQuestionAnswer.getOption_score()+""+"--"+testQuestionAnswer.getQuestion_id()+"");
//		System.out.println(testQuestionAnswer.getOption_s()+"--"+testQuestionAnswerb.getOption_text()+"--"+testQuestionAnswerb.getOption_score()+""+"--"+testQuestionAnswerb.getQuestion_id()+"");
			testQuestionLangService.updatecr(testQuestionLang);
			testQuestionAcswerService.updatecr(testQuestionAnswer);
			testQuestionAcswerService.updatecr(testQuestionAnswerb);
			testQuestionAcswerService.updatecr(testQuestionAnswerc);
			testQuestionAcswerService.updatecr(testQuestionAnswerD);
			super.out(request, response, "ok");
		} catch (Exception e) {
			super.out(request, response, "no");
			e.printStackTrace();
		}
	}
}
