package com.huanduguihua.red.question1.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huanduguihua.red.question1.bean.TestAppearance;
import com.huanduguihua.red.question1.service.TestAppearanceService;
import com.huanduguihua.user.bean.User;

@Controller
@RequestMapping("/red/testAppearance")
public class TestAppearanceController {
	
	@Autowired
	TestAppearanceService testAppearanceService;
	
	@RequestMapping(value="testAppearancesave",method=RequestMethod.POST)
	public void testAppearancesave(Model model, HttpServletResponse response,HttpServletRequest request){
		TestAppearance testAppearance = new TestAppearance();
		User u = (User) request.getSession().getAttribute("user");
		if(u != null){
			testAppearance.setUser_id(u.getId());
		}
		Integer question_no = Integer.parseInt(request.getParameter("question_no"));
		String reaction_time = request.getParameter("reaction_time");
		Integer reaction_chioce = Integer.parseInt(request.getParameter("clickkey"));
		String delay = request.getParameter("delay");
		Integer type=Integer.parseInt(request.getParameter("type"));
		Integer structure = Integer.parseInt(request.getParameter("structure"));
		Integer angle = Integer.parseInt(request.getParameter("angle"));
		Integer classification = Integer.parseInt(request.getParameter("classification"));
		if(type == 1 && reaction_chioce==1){
			testAppearance.setIs_true(1);
		}
		else{
			testAppearance.setIs_true(0);
		}
		if(type == 2 || type == 3){
			if(reaction_chioce == 0){
				testAppearance.setIs_true(1);
			}
			else{
				testAppearance.setIs_true(0);
			}
		}
		testAppearance.setQuestion_no(question_no);
		testAppearance.setReaction_chioce(reaction_chioce);
		testAppearance.setReaction_time(reaction_time);
		testAppearance.setDelay(delay);
		testAppearance.setType(type);
		testAppearance.setStructure(structure);
		testAppearance.setAngle(angle);
		testAppearance.setClassification(classification);
		List<Map<String, Object>> l = testAppearanceService.executeQuery("select * from test_appearance where user_id=? and question_no=?", u.getId(),question_no);
		if(l.size()==0)
			testAppearanceService.save(testAppearance);
		testAppearanceService.executeUpdate("update test_system_user set xiaotijd=? where id=?", question_no,u.getId());
		
	}
}
