package com.huanduguihua.orange.question3.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huanduguihua.orange.question3.bean.ColorContrast;
import com.huanduguihua.orange.question3.service.ColorContrastService;
import com.huanduguihua.user.bean.User;

@Controller
@RequestMapping("/orange/colorContrast")
public class ColorContrastController {

	@Autowired
	ColorContrastService colorContrastService;
	
	@RequestMapping(value="colorContrastsave",method=RequestMethod.POST)
	public void colorContrastsave(Model model , HttpServletRequest request , HttpServletResponse response){
		try {
			ColorContrast colorContrast = new ColorContrast();
			User u = (User) request.getSession().getAttribute("user");
			if(u!=null)
				colorContrast.setUser_id(u.getId());
			Integer question_no = Integer.parseInt(request.getParameter("question_no"));
			String reaction_time = request.getParameter("reaction_time");
			Integer student_choice = Integer.parseInt(request.getParameter("student_choice"));
			Integer question_answer = Integer.parseInt(request.getParameter("question_answer"));
			colorContrast.setQuestion_answer(question_answer);
			colorContrast.setReaction_time(reaction_time);
			colorContrast.setQuestion_no(question_no);
			colorContrast.setStudent_choice(student_choice);
			List<Map<String, Object>> l = colorContrastService.executeQuery("select * from test_colorcontrast where user_id=? and question_no=?", u.getId(),question_no);
			if(l.size()==0)
				colorContrastService.save(colorContrast);
			colorContrastService.executeUpdate("update test_system_user set xiaotijd=? where id=?", question_no,u.getId());
			response.getWriter().print("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
