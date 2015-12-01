package com.huanduguihua.wathet.question1.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.huanduguihua.system.controller.DefaultController;
import com.huanduguihua.user.bean.User;

@Controller
@RequestMapping("/whatet")
public class WathetController extends DefaultController{

	@RequestMapping(value="gomainselect",method=RequestMethod.GET)
	public String gomainselect(Model model , HttpServletRequest request , HttpServletResponse response){
		User u = super.getSessionUser(request);
		if(u!=null){
			if (super.checkMokuai(request, "wathet/mainselect")) {
				return "wathet/mainselect";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "wathet/mainselect";
	}
	
	@RequestMapping(value="appreciate",method=RequestMethod.GET)
	public String appreciate(Model model , HttpServletRequest request , HttpServletResponse response){
		User u = super.getSessionUser(request);
		if(u!=null){
			if (super.checkTimu(request, "wathet/appreciate")) {
				return "wathet/appreciate";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "wathet/appreciate";
	}
	
	@RequestMapping(value="lenght",method=RequestMethod.GET)
	public String lenght(Model model , HttpServletRequest request , HttpServletResponse response){
		User u = super.getSessionUser(request);
		if(u!=null){
			if (super.checkTimu(request, "wathet/lenght")) {
				return "wathet/lenght";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "wathet/lenght";
	}
	
	@RequestMapping(value="memory",method=RequestMethod.GET)
	public String memory(Model model , HttpServletRequest request , HttpServletResponse response){
		User u = super.getSessionUser(request);
		if(u!=null){
			if (super.checkTimu(request, "wathet/memory")) {
				return "wathet/memory";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "wathet/memory";
	}
	
	@RequestMapping(value="rhythm",method=RequestMethod.GET)
	public String rhythm(Model model , HttpServletRequest request , HttpServletResponse response){
		User u = super.getSessionUser(request);
		if(u!=null){
			if (super.checkTimu(request, "wathet/rhythm")) {
				return "wathet/rhythm";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "wathet/rhythm";
	}
	
	@RequestMapping(value="tonality",method=RequestMethod.GET)
	public String tonality(Model model , HttpServletRequest request , HttpServletResponse response){
		User u = super.getSessionUser(request);
		if(u!=null){
			if (super.checkTimu(request, "wathet/tonality")) {
				return "wathet/tonality";
			} else {
				super.historyBack(response,request);
				return null;
			}
		}
		else{
			return "redirect:/";
		}
//		return "wathet/tonality";
	}
}
