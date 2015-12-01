package com.huanduguihua.violet.question2.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.huanduguihua.system.controller.DefaultController;
import com.huanduguihua.user.bean.User;
import com.huanduguihua.violet.question2.bean.Logical;
import com.huanduguihua.violet.question2.service.LogicalService;

@Controller
@RequestMapping("/violet/logical")
public class LogicalController extends DefaultController {

	@Autowired
	LogicalService logicalService;
	
	@RequestMapping(value="logicalsave",method=RequestMethod.POST)
	public void logicalsave(Model model , HttpServletRequest request , HttpServletResponse response,
			@RequestParam("question_no") Integer question_no,
			@RequestParam("reaction_time") String reaction_time,
			@RequestParam("student_choice") Integer student_choice,
			@RequestParam("right_anser") Integer right_anser,
			@RequestParam("student_score") Integer student_score,
			@RequestParam("isright") Integer isright){
		Logical logical = new Logical();
		
		User user = super.getSessionUser(request);
		if(user!=null)
			logical.setUser_id(user.getId());
		
		logical.setQuestion_no(question_no);
		logical.setIsright(isright);
		logical.setReaction_time(reaction_time);
		logical.setRight_anser(right_anser);
		logical.setStudent_score(student_score);
		logical.setStudent_choice(student_choice);
		List<Map<String, Object>> l = logicalService.executeQuery("select * from test_logical where user_id=? and question_no=?", user.getId(),question_no);
		if(l.size()==0)
			logicalService.save(logical);
		logicalService.executeUpdate("update test_system_user set xiaotijd=? where id=?", question_no,user.getId());
	}
}
