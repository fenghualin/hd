package com.huanduguihua.wathet.question3.controller;

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
import com.huanduguihua.wathet.question3.bean.MusicRhythm;
import com.huanduguihua.wathet.question3.service.MusicRhythmService;

@Controller
@RequestMapping("/whatet/musicrhythm")
public class MusicRhythmController extends DefaultController {

	@Autowired
	MusicRhythmService musicRhythmService;
	
	@RequestMapping(value="musicRhythmsave",method=RequestMethod.POST)
	public void musicRhythmsave(Model model , HttpServletRequest request , HttpServletResponse response,
			@RequestParam("question_no") Integer question_no,
			@RequestParam("reaction_time") String reaction_time,
			@RequestParam("question_right") Integer question_right,
			@RequestParam("student_choice") Integer student_choice,
			@RequestParam("student_score") Integer student_score){
		try {
			MusicRhythm musicRhythm = new MusicRhythm();
			User u = super.getSessionUser(request);
			if (u != null) {
				musicRhythm.setUser_id(u.getId());
			}
			
			musicRhythm.setQuestion_no(question_no);
			musicRhythm.setReaction_time(reaction_time);
			musicRhythm.setQuestion_right(question_right);
			musicRhythm.setStudent_choice(student_choice);
			musicRhythm.setStudent_score(student_score);
			List<Map<String, Object>> l = musicRhythmService.executeQuery("select * from test_musicrhythm where user_id=? and question_no=?", u.getId(),question_no);
			if(l.size()==0)
			musicRhythmService.save(musicRhythm);
			musicRhythmService.executeUpdate("update test_system_user set xiaotijd=? where id=?", question_no,u.getId());
			response.getWriter().print("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
