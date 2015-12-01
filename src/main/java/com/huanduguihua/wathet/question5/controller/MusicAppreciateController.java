package com.huanduguihua.wathet.question5.controller;

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

import com.huanduguihua.user.bean.User;
import com.huanduguihua.wathet.question5.bean.MusicAppreciate;
import com.huanduguihua.wathet.question5.service.MusicAppreciateService;

@Controller
@RequestMapping("/whatet/musicappreciate")
public class MusicAppreciateController {
	@Autowired
	MusicAppreciateService musicAppreciateService;

	@RequestMapping(value="musicAppreciatesave",method=RequestMethod.POST)
	public void musicAppreciatesave(Model model,HttpServletRequest request , HttpServletResponse response,
			@RequestParam(value="question_no",required=false) Integer question_no,
			@RequestParam(value="reaction_time",required=false) String reaction_time,
			@RequestParam("student_choice") Integer student_choice,
			@RequestParam("student_score") Integer student_score){
		try {
			MusicAppreciate musicAppreciate = new MusicAppreciate();
			User u = (User) request.getSession().getAttribute("user");
			if(u!=null){
				musicAppreciate.setUser_id(u.getId());
			}
			
			musicAppreciate.setQuestion_no(question_no);
			musicAppreciate.setReaction_time(reaction_time);
			musicAppreciate.setStudent_choice(student_choice);
			musicAppreciate.setStudent_score(student_score);
			List<Map<String, Object>> l = musicAppreciateService.executeQuery("select * from test_musicappreciate where user_id=? and question_no=?", u.getId(),question_no);
			if(l.size()==0)
			musicAppreciateService.save(musicAppreciate);
			musicAppreciateService.executeUpdate("update test_system_user set xiaotijd=? where id=?", question_no,u.getId());
			response.getWriter().print("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
