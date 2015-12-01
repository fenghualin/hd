package com.huanduguihua.wathet.question2.controller;

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
import com.huanduguihua.wathet.question2.bean.MusicLength;
import com.huanduguihua.wathet.question2.service.MusicLengthService;

@Controller
@RequestMapping("/whatet/musiclength")
public class MusicLengthController extends DefaultController {

	@Autowired
	MusicLengthService musicLengthService;
	
	@RequestMapping(value="musicLengthsave",method=RequestMethod.POST)
	public void musicLengthsave(Model model , HttpServletRequest request , HttpServletResponse response,
			@RequestParam("question_no") Integer question_no,
			@RequestParam("reaction_time") String reaction_time,
			@RequestParam("question_right") Integer question_right,
			@RequestParam("student_choice") Integer student_choice,
			@RequestParam("student_score") Integer student_score){
		try {
			MusicLength musicLength =new MusicLength();
			User u = super.getSessionUser(request);
			if(u!=null)
				musicLength.setUser_id(u.getId());
			
			musicLength.setQuestion_no(question_no);
			musicLength.setReaction_time(reaction_time);
			musicLength.setQuestion_right(question_right);
			musicLength.setStudent_choice(student_choice);
			musicLength.setStudent_score(student_score);
			List<Map<String, Object>> l = musicLengthService.executeQuery("select * from test_musiclength where user_id=? and question_no=?", u.getId(),question_no);
			if(l.size()==0)
			musicLengthService.save(musicLength);
			musicLengthService.executeUpdate("update test_system_user set xiaotijd=? where id=?", question_no,u.getId());
			response.getWriter().print("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
