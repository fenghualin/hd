package com.huanduguihua.gray.question4.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.huanduguihua.gray.question4.bean.Rgtstbean;
import com.huanduguihua.gray.question4.service.RgtstbeanService;
import com.huanduguihua.system.controller.DefaultController;
import com.huanduguihua.user.bean.User;

@Controller
@RequestMapping("/rgtst")
public class RgtstbeanController extends DefaultController{

	@Autowired RgtstbeanService rgtstbeanService;
	
	@RequestMapping(value="rgtstsave",method=RequestMethod.POST)
	public void rgtstsave(HttpServletRequest request,
			@RequestParam("content") String content){
		Rgtstbean rgtstbean=new Rgtstbean();
		User u=super.getSessionUser(request);
		rgtstbean.setContent(content);
		rgtstbean.setUserId(u.getId());
		List<Map<String, Object>> l = rgtstbeanService.executeQuery("select * from test_rgtst where user_id=?", u.getId());
		if(l.size()==0)
			rgtstbeanService.save(rgtstbean);
	}
}
