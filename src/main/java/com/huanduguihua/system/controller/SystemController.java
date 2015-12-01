/**
 * com.huanduguihua.system.controller
 * SystemController.java
 * 
 * 2014-5-12-下午2:49:18
 *  2014成都酷信科技公司-版权所有
 * 
 */
package com.huanduguihua.system.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.huanduguihua.user.bean.User;
import com.huanduguihua.user.controller.UserController;
import com.huanduguihua.user.service.UserService;

/**
 * 
 * SystemController
 * 
 * kin
 * kin
 * 2014-5-12 下午2:49:18
 * 
 * @author KangJia
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/system")
public class SystemController {
	
	@Autowired UserController userController;
	@Autowired UserService userService;
	
	@RequestMapping(value = "demo", method = RequestMethod.GET)
	public String getConfig(Model model, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			return "system/demo";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "allselect", method = RequestMethod.GET)
	public String allselect(Model model, HttpServletRequest request, HttpServletResponse response){
		return "allselect";
	}
	
	@RequestMapping("select")
	public String select(Model model , HttpServletRequest request, HttpServletResponse response,
			@RequestParam("zuotijindu") Integer zuotijindu) {
		
		try {
			//request.getSession().invalidate();
			//User user = userService.get(0);
			User user = (User) request.getSession().getAttribute("user");
			user.setZuotijindu(zuotijindu);
			user.setMokuaijdId(0);
			userService.update(user);
			userController.userlogin(model, request, response, String.valueOf(user.getId()), "password");
			
			return "redirect:/user/mokuai";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/";
		}
	}
}
