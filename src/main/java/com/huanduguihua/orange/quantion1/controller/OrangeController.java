package com.huanduguihua.orange.quantion1.controller;

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
@RequestMapping("/orange")
public class OrangeController extends DefaultController {

	@RequestMapping(value="/testclick",method=RequestMethod.POST)
	public void testclick(HttpServletRequest request,HttpServletResponse response){
		super.checkTimu(request, "");
	}
	@RequestMapping(value="/gomainselect",method=RequestMethod.GET)
	public String gomainselect(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
//			System.out.println(super.checkMokuai(request, "orange/mainselect"));
			if (super.checkMokuai(request, "orange/mainselect")) {
				return "orange/mainselect";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/colorcontrast",method=RequestMethod.GET)
	public String colorcontrast(Model model,HttpServletRequest request,HttpServletResponse response){
//		return "orange/colorcontrast";
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "orange/colorcontrast")) {
				return "orange/colorcontrast";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/imagination",method=RequestMethod.GET)
	public String imagination(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "orange/imagination")) {
				return "orange/imagination";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "orange/imagination";
	}
	@RequestMapping(value="/proportion",method=RequestMethod.GET)
	public String proportion(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			if (super.checkTimu(request, "orange/proportion")) {
				return "orange/proportion";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "orange/proportion";
	}
}
