package com.huanduguihua.orange.question2.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huanduguihua.orange.question2.bean.ImageInation;
import com.huanduguihua.orange.question2.service.ImageInationService;
import com.huanduguihua.user.bean.User;

@Controller
@RequestMapping("/orange/imageInation")
public class ImagInationController {
	@Autowired
	ImageInationService imageInationService;
	
	@RequestMapping(value="imageInationsave",method=RequestMethod.POST)
	public void imageInationsave(Model model , HttpServletRequest request , HttpServletResponse response ){
		try {
			ImageInation imageInation = new ImageInation();
			User u =(User)request.getSession().getAttribute("user");
			Integer question_answer = Integer.parseInt(request.getParameter("question_answer"));
			Integer question_no = Integer.parseInt(request.getParameter("question_no"));
			String reaction_time = request.getParameter("reaction_time");
			Integer student_choice = Integer.parseInt(request.getParameter("student_choice"));
			if(u!= null)
				imageInation.setUser_id(u.getId());
			
			imageInation.setQuestion_answer(question_answer);
			imageInation.setQuestion_no(question_no);
			imageInation.setReaction_time(reaction_time);
			imageInation.setStudent_choice(student_choice);
			List<Map<String, Object>> l = imageInationService.executeQuery("select * from test_imageination where user_id=? and question_no=?", u.getId(),question_no);
			if(l.size()==0)
				imageInationService.save(imageInation);
			response.getWriter().print("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
