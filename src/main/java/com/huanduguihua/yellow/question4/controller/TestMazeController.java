package com.huanduguihua.yellow.question4.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huanduguihua.user.bean.User;
import com.huanduguihua.yellow.question4.bean.TestMaze;
import com.huanduguihua.yellow.question4.service.TestMazeService;

@Controller
@RequestMapping("/yellow/maze")
public class TestMazeController {

	@Autowired
	TestMazeService testMazeService;
	
	@RequestMapping(value="saveMaze",method=RequestMethod.POST)
	public void saveMaze(Model model,HttpServletRequest request,HttpServletResponse response){
		TestMaze testMaze=new TestMaze();
		testMaze.setWall_number(Integer.parseInt(request.getParameter("wall_number")));
		testMaze.setBlindness_number(Integer.parseInt(request.getParameter("blindness_number")));
		testMaze.setReaction_time(request.getParameter("reaction_time"));
		User u = (User) request.getSession().getAttribute("user");
		if(u != null)
			testMaze.setUser_id(u.getId());
		List<Map<String, Object>> l = testMazeService.executeQuery("select * from test_maze where user_id=?",u.getId());
		if(l.size()==0)
		testMazeService.save(testMaze);
	}
}
