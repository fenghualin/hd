package com.huanduguihua.system.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.huanduguihua.user.bean.User;
import com.huanduguihua.user.service.UserService;

import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController{
	
	@Autowired UserService userService;
	
	@RequestMapping(value="index",method=RequestMethod.GET)
	public String login(Model model, HttpServletRequest request,HttpServletResponse response){
		User user = (User) request.getSession().getAttribute("user");
//		System.out.println("user: " + user);
		model.addAttribute("user", user);
		user.setCreateTime(new Timestamp(System.currentTimeMillis()));
		String username = user.getUsername();
		System.out.println("username="+username);
		if(username.startsWith("7")){
			return "regstart_cr";
		}
		return "regstart";
	}
	
	@RequestMapping("navselect")
	public String navselect() {
		return "navselect";
	} 
	
	@RequestMapping("copyright")
	public String copyright(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user!=null && user.getZuotijindu()!=null && user.getZuotijindu() > 0) {
			return "redirect:/user/mokuai";
		}
		return "copyright";
	}
}
