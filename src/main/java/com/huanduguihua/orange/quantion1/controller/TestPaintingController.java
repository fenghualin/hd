package com.huanduguihua.orange.quantion1.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huanduguihua.orange.quantion1.bean.TestPainting;
import com.huanduguihua.orange.quantion1.service.TestPaintingService;
import com.huanduguihua.user.bean.User;

@Controller
@RequestMapping("/orange/testPainting")
public class TestPaintingController {
	
	@Autowired
	TestPaintingService testPaintingService;

	@RequestMapping(value="testPaintingsave",method=RequestMethod.POST)
	public void testPaintingsave(Model model,HttpServletRequest request,HttpServletResponse response){
		try {
			TestPainting testPainting = new TestPainting();
			User u = (User) request.getSession().getAttribute("user");
			Integer question_no = Integer.parseInt(request.getParameter("question_no"));
			String reaction_time = request.getParameter("reaction_time");
			Integer student_choice = Integer.parseInt(request.getParameter("student_choice"));
			Integer question_answer = Integer.parseInt(request.getParameter("question_answer"));
			testPainting.setQuestion_answer(question_answer);
			testPainting.setQuestion_no(question_no);
			testPainting.setReaction_time(reaction_time);
			testPainting.setStudent_choice(student_choice);
			if(u != null)
				testPainting.setUser_id(u.getId());
			List<Map<String, Object>> l = testPaintingService.executeQuery("select * from test_painting where user_id=? and question_no=?", u.getId(),question_no);
			if(l.size()==0)
				testPaintingService.save(testPainting);
			response.getWriter().print("ok");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
