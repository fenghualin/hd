package com.huanduguihua.green.question5.Controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huanduguihua.green.question5.bean.TestPintu;
import com.huanduguihua.green.question5.service.TestPintuService;
import com.huanduguihua.user.bean.User;

@Controller
@RequestMapping("/green/testPintu")
public class TestPintuController {

	@Autowired
	TestPintuService testPintuService;
	
	@RequestMapping(value="testPintusave",method=RequestMethod.POST)
	public void testPintusave(Model model,HttpServletRequest request,HttpServletResponse response){
		TestPintu testPintu = new TestPintu();
		User u = (User) request.getSession().getAttribute("user");
		String reaction_time = request.getParameter("reaction_time");
		Integer question_no = Integer.parseInt(request.getParameter("question_no"));
		Integer sum_step = Integer.parseInt(request.getParameter("sum_step"));
		String start_think = request.getParameter("start_think");
		Integer student_score = Integer.parseInt(request.getParameter("student_score"));
		testPintu.setQuestion_no(question_no);
		testPintu.setReaction_time(reaction_time);
		testPintu.setStart_think(start_think);
		testPintu.setStudent_score(student_score);
		testPintu.setSum_step(sum_step);
		if(u != null)
			testPintu.setUser_id(u.getId());
		List<Map<String, Object>> l = testPintuService.executeQuery("select * from test_pintu where user_id=? and question_no=?", u.getId(),question_no);
		if(l.size()==0)
			testPintuService.save(testPintu);
	}
	
	@RequestMapping(value="matching2",method=RequestMethod.GET)
	public String matching2(Model model,HttpServletRequest request,HttpServletResponse response){
		return "green/matching2";
	}
}
