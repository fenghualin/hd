package com.huanduguihua.red.question1.controller;

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
@RequestMapping("/red")
public class RedController extends DefaultController{

	@RequestMapping(value="mainselect",method=RequestMethod.GET)
	public String mainselect(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkMokuai(request, "red/mainselect")) {
				return "red/mainselect";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "red/mainselect";
	}
	
	@RequestMapping(value="deduction",method=RequestMethod.GET)
	public String deduction(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "red/deduction")) {
				return "red/deduction";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "red/deduction";
	}
	@RequestMapping(value="operation",method=RequestMethod.GET)
	public String operation(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "red/operation")) {
				return "red/operation";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "red/operation";
	}
	@RequestMapping(value="operationlx",method=RequestMethod.GET)
	public String operationlx(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "red/operation")) {
				return "red/operationlx";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "red/operationlx";
	}
	@RequestMapping(value="operationys",method=RequestMethod.GET)
	public String operationys(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "red/operation")) {
				return "red/operationys";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "red/operationys";
	}
	
	@RequestMapping(value="presentational",method=RequestMethod.GET)
	public String presentational(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "red/presentational")) {
				return "red/presentational";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "red/presentational";
	}
	@RequestMapping(value="thinking",method=RequestMethod.GET)
	public String thinking(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "red/thinking")) {
				return "red/thinking";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "red/thinking";
	}
	
	@RequestMapping(value="deductionlx",method=RequestMethod.GET)
	public String deductionlx(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "red/deduction")) {
				return "red/deductionlx";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "red/deductionlx";
	}
	
	@RequestMapping(value="presentationallx",method=RequestMethod.GET)
	public String presentationallx(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "red/presentational")) {
				return "red/presentationallx";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "red/presentationallx";
	}
	@RequestMapping(value="thinkinglx",method=RequestMethod.GET)
	public String thinkinglx(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "red/thinking")) {
				return "red/thinkinglx";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "red/thinkinglx";
	}
}
