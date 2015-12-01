package com.huanduguihua.wathet.question4.controller;

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
import com.huanduguihua.wathet.question4.bean.MusicCemory;
import com.huanduguihua.wathet.question4.service.MusicCemoryService;

@Controller
@RequestMapping("/whatet/musiccemory")
public class MusicCemoryController extends DefaultController {

	@Autowired
	MusicCemoryService musicCemoryService;
	
	@RequestMapping(value="musicCemorySave",method=RequestMethod.POST)
	public void musicCemorySave(Model model , HttpServletRequest request , HttpServletResponse response,
			@RequestParam("question_no") Integer question_no,
			@RequestParam("reaction_time") String reaction_time,
			@RequestParam("question_right") Integer question_right,
			@RequestParam("student_choice") Integer student_choice,
			@RequestParam("student_score") Integer student_score){
		try {
			MusicCemory musicCemory = new MusicCemory();
			User u = super.getSessionUser(request);
			if(u!=null) {
				musicCemory.setUser_id(u.getId());
			}
			
			musicCemory.setQuestion_no(question_no);
			musicCemory.setReaction_time(reaction_time);
			musicCemory.setQuestion_right(question_right);
			musicCemory.setStudent_choice(student_choice);
			musicCemory.setStudent_score(student_score);
			List<Map<String, Object>> l = musicCemoryService.executeQuery("select * from test_musiccemory where user_id=? and question_no=?", u.getId(),question_no);
			if(l.size()==0)
			musicCemoryService.save(musicCemory);
			musicCemoryService.executeUpdate("update test_system_user set xiaotijd=? where id=?", question_no,u.getId());
			response.getWriter().print("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
