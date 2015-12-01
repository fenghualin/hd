package com.huanduguihua.violet.question1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huanduguihua.system.controller.DefaultController;
import com.huanduguihua.user.bean.User;

@Controller
@RequestMapping("/violet")
public class VioletController extends DefaultController{
	
	@RequestMapping(value="gomainselect",method=RequestMethod.GET)
	public String gomainselect(Model model , HttpServletRequest request , HttpServletResponse response){
		
		User user = super.getSessionUser(request);
		
		if(user != null){
			if (super.checkMokuai(request, "violet/mainselect")) {
				return "violet/mainselect";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "violet/mainselect";
	}
	
	@RequestMapping(value="induction",method=RequestMethod.GET)
	public String induction(Model model , HttpServletRequest request , HttpServletResponse response){
		User u = super.getSessionUser(request);
		if(u!=null){
			if (super.checkTimu(request, "violet/induction")) {
				return "violet/induction";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "violet/induction";
	}
	
	@RequestMapping(value="inductionlx",method=RequestMethod.GET)
	public String inductionlx(Model model , HttpServletRequest request , HttpServletResponse response){
		User u = super.getSessionUser(request);
		if(u!=null){
			if (super.checkTimu(request, "violet/induction")) {
				return "violet/inductionlx";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "violet/inductionlx";
	}
	
	@RequestMapping(value="logical",method=RequestMethod.GET)
	public String logical(Model model , HttpServletRequest request , HttpServletResponse response){
		User u = super.getSessionUser(request);
		if(u!=null){
			if (super.checkTimu(request, "violet/logical")) {
				return "violet/logical";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "violet/logical";
	}
	@RequestMapping(value="logicallx",method=RequestMethod.GET)
	public String logicallx(Model model , HttpServletRequest request , HttpServletResponse response){
		User u = super.getSessionUser(request);
		if(u!=null){
			if (super.checkTimu(request, "violet/logical")) {
				return "violet/logicallx";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "violet/logicallx";
	}
	
	@RequestMapping(value="management",method=RequestMethod.GET)
	public String management(Model model , HttpServletRequest request , HttpServletResponse response){
		User u = super.getSessionUser(request);
		if(u!=null){
			if (super.checkTimu(request, "violet/management")) {
				return "violet/management";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "violet/management";
	}
}
