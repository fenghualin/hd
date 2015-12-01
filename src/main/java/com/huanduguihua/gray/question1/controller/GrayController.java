package com.huanduguihua.gray.question1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huanduguihua.system.controller.DefaultController;
import com.huanduguihua.user.bean.User;

@Controller
@RequestMapping("/gray")
public class GrayController extends DefaultController{

	@RequestMapping(value="gomainselect",method=RequestMethod.GET)
	public String gomainselect(Model model , HttpServletResponse response , HttpServletRequest request){
		
		//User u = super.getSessionUser(request);//使用父类获取session中的用户
		User u = super.getSessionUser(request);
		if(u!=null){
			if (super.checkMokuai(request, "gray/mainselect")) {
				return "gray/mainselect";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "gray/mainselect";
	}
	
	@RequestMapping(value="personalityA",method=RequestMethod.GET)
	public String personalityA(Model model , HttpServletResponse response , HttpServletRequest request){
		User u = super.getSessionUser(request);
		if(u!=null){
			if (super.checkTimu(request, "gray/personalityA")) {
				return "gray/personalityA";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "gray/personalityA";
	}
	
	@RequestMapping(value="personalityD",method=RequestMethod.GET)
	public String personalityD(Model model , HttpServletResponse response , HttpServletRequest request){
		User u = super.getSessionUser(request);
		if(u!=null){
			if (super.checkTimu(request, "gray/personalityD")) {
				return "gray/personalityD";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "gray/personalityD";
	}
	
	@RequestMapping(value="personalityC",method=RequestMethod.GET)
	public String personalityC(Model model , HttpServletResponse response , HttpServletRequest request){
		User u = super.getSessionUser(request);
		if(u!=null){
			if (super.checkTimu(request, "gray/personalityC")) {
				return "gray/personalityC";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "gray/personalityC";
	}
	
	@RequestMapping(value="personalityB",method=RequestMethod.GET)
	public String personalityB(Model model , HttpServletResponse response , HttpServletRequest request){
		User u = super.getSessionUser(request);
		if(u!=null){
			if (super.checkTimu(request, "gray/personalityB")) {
				return "gray/personalityB";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "gray/personalityB";
	}
}
