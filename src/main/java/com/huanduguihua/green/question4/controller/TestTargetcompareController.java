package com.huanduguihua.green.question4.controller;

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

import com.huanduguihua.green.question4.bean.TestTargetcompare;
import com.huanduguihua.green.question4.service.TestTargetcompareService;
import com.huanduguihua.user.bean.User;

@Controller
@RequestMapping("/green/testTargetcompare")
public class TestTargetcompareController {
	
	@Autowired
	TestTargetcompareService testTargetcompareService;
	
	@RequestMapping(value="testTargetcomparesave",method=RequestMethod.POST)
	public void testTargetcomparesave(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam("test_no") Integer test_no,
			@RequestParam("click") Boolean click){
//		Integer count_click=0;
		Integer success_click=0;
		String zuobiao="";
		String is_true="";
		TestTargetcompare testTargetcompare = new TestTargetcompare();
		if(request.getParameter("success_click")!=null && !"".equals(request.getParameter("success_click"))){
			success_click = Integer.parseInt(request.getParameter("success_click"));
			testTargetcompare.setSuccess_click(success_click);
		}
		if(request.getParameter("count_click")!=null && !"".equals(request.getParameter("count_click"))){
			testTargetcompare.setFail_click(Integer.parseInt(request.getParameter("count_click")));
		}
		if(request.getParameter("zuobiao")!=null && !"".equals(request.getParameter("zuobiao"))){
			zuobiao=request.getParameter("zuobiao");
			testTargetcompare.setZuobiao(zuobiao);
			zuobiao=request.getParameter("zuobiao");
		}
		if(request.getParameter("is_true")!=null && !"".equals(request.getParameter("is_true"))){
			is_true=request.getParameter("is_true");
			testTargetcompare.setIs_true(is_true);
		}
		String reaction_time = request.getParameter("reaction_time");
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			testTargetcompare.setUser_id(u.getId());
//			testTargetcompareService.delete(u.getId());
		}
		List<Map<String, Object>> l = testTargetcompareService.executeQuery("select * from test_targetcompare where user_id=? and test_no=?", u.getId(),test_no);
//		System.out.println("testNo: " + test_no);
		testTargetcompare.setTestNo(test_no);
		testTargetcompare.setReactionTime(reaction_time);
//		System.out.println("click: " + request.getParameter("click"));
		if(click == true) {
			testTargetcompare.setTestNo(9);
		}
		if(l.size()==0) {
			testTargetcompareService.save(testTargetcompare);
		}
	}

}
