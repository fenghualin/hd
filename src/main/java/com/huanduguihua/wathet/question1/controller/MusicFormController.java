package com.huanduguihua.wathet.question1.controller;

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
import com.huanduguihua.wathet.question1.bean.MusicForm;
import com.huanduguihua.wathet.question1.service.MusicFormService;


@Controller
@RequestMapping("/whatet/musicform")
public class MusicFormController extends DefaultController {

	@Autowired
	MusicFormService musicFormService;
	
	@RequestMapping(value="musicFormsave",method=RequestMethod.POST)
	public void musicFormsave(Model model , HttpServletRequest request , HttpServletResponse response,
			@RequestParam("question_no") Integer question_no,
			@RequestParam("reaction_time") String reaction_time,
			@RequestParam("question_right") Integer question_right,
			@RequestParam("student_choice") Integer student_choice,
			@RequestParam("student_score") Integer student_score){
		try {
			MusicForm musicForm = new  MusicForm();
			User user = super.getSessionUser(request);
			if(user != null)
				musicForm.setUser_id(user.getId());
			
			musicForm.setQuestion_no(question_no);
			musicForm.setQuestion_right(question_right);
			musicForm.setReaction_time(reaction_time);
			musicForm.setStudent_choice(student_choice);
			musicForm.setStudent_score(student_score);
			List<Map<String, Object>> l = musicFormService.executeQuery("select * from test_musicform where user_id=? and question_no=?", user.getId(),question_no);
			if(l.size()==0)
				musicFormService.save(musicForm);
			musicFormService.executeUpdate("update test_system_user set xiaotijd=? where id=?", question_no,user.getId());
			response.getWriter().print("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
