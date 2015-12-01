package com.huanduguihua.green.question1.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huanduguihua.green.question1.bean.TestSearch;
import com.huanduguihua.green.question1.service.TestSearchService;
import com.huanduguihua.system.controller.DefaultController;
import com.huanduguihua.user.bean.User;

@Controller
@RequestMapping("/green/testsearch")
public class TestSearchController extends DefaultController{
	@Autowired
	TestSearchService testSearchService;

	@RequestMapping(value="saveTestSearch",method=RequestMethod.POST)
	public void saveTestSearch(Model model,HttpServletRequest request,HttpServletResponse response){
		TestSearch testSearch = new TestSearch();
		testSearch.setReaction_time(request.getParameter("reaction_time"));
		testSearch.setStudent_choice(Integer.parseInt(request.getParameter("student_choice")));
		testSearch.setStudent_score(Integer.parseInt(request.getParameter("student_score")));
		User u = super.getSessionUser(request);
		if(u != null)
			testSearch.setUser_id(u.getId());
		Integer question_no=Integer.parseInt(request.getParameter("question_no"));
		testSearch.setQuestion_no(question_no);
		List<Map<String, Object>> l = testSearchService.executeQuery("select * from test_search where user_id=? and question_no=?", u.getId(),question_no);
		if(l.size()==0){
			testSearchService.save(testSearch);
		}
	}
}
