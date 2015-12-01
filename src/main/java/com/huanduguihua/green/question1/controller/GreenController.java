package com.huanduguihua.green.question1.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huanduguihua.system.controller.DefaultController;
import com.huanduguihua.user.bean.User;

@Controller
@RequestMapping("/green")
public class GreenController extends DefaultController{

	@RequestMapping(value="gomainselect",method=RequestMethod.GET)
	public String gomainselect(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkMokuai(request, "green/mainselect")) {
				return "green/mainselect";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "green/mainselect";
	}
	@RequestMapping(value="gosearching",method=RequestMethod.GET)
	public String gosearching(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "green/question1/searching")) {
				return "green/question1/searching";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "green/question1/searching";
	}
	@RequestMapping(value="gocomparing",method=RequestMethod.GET)
	public String gocomparing(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "green/comparing")) {
				return "green/comparing";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "green/comparing";
	}
	@RequestMapping(value="gointeractionA",method=RequestMethod.GET)
	public String gointeractionA(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "green/interactionA")) {
				return "green/interactionA";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "green/interactionA";
	}
	@RequestMapping(value="gointeractionB",method=RequestMethod.GET)
	public String gointeractionB(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "green/interactionB")) {
				return "green/interactionB";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "green/interactionB";
	}
	@RequestMapping(value="gomatching",method=RequestMethod.GET)
	public String gomatching(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "green/matching")) {
				return "green/matching";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "green/matching";
	}
	@RequestMapping(value="gomatchinglx",method=RequestMethod.GET)
	public String gomatchinglx(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "green/matching")) {
				return "green/matchinglx";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "green/matchinglx";
	}
}
