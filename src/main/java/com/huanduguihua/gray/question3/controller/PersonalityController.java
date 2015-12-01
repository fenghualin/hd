package com.huanduguihua.gray.question3.controller;

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

import com.huanduguihua.gray.question3.bean.Personality;
import com.huanduguihua.gray.question3.service.PersonalityService;
import com.huanduguihua.user.bean.User;

@Controller
@RequestMapping("/gray/personality")
public class PersonalityController {

	@Autowired
	PersonalityService personalityService;
	
	@RequestMapping(value="personalitysave",method=RequestMethod.POST)
	public void personalitysave(Model model , HttpServletRequest request , HttpServletResponse response,
			@RequestParam("question_no") Integer questionNo,
			@RequestParam("student_choice") Integer studentChoice,
			@RequestParam("imglength") Integer imglength,
			@RequestParam("reaction_time") String reactionTime){
		try {
			Personality personality = new Personality();
			User u = (User) request.getSession().getAttribute("user");
			if(u!=null){
				personality.setUser_id(u.getId());
			}
			personality.setQuestion_no(questionNo);
			personality.setReaction_time(reactionTime);
			personality.setStudent_choice(studentChoice);
			personality.setImglength(imglength);
			
			List<Map<String, Object>> l = personalityService.executeQuery("select * from test_personality where user_id=? and question_no=?", u.getId(),questionNo);
			if(l.size()==0){
				personalityService.save(personality);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
