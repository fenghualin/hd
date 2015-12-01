package com.huanduguihua.gray.question2;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.huanduguihua.green.question3.bean.search.TestOperationbSearch;
import com.huanduguihua.manager.bean.TestQuestionAnswer2;
import com.huanduguihua.manager.bean.TestQuestionLang2;
import com.huanduguihua.manager.service.TestQuestionAcswerService2;
import com.huanduguihua.manager.service.TestQuestionLangService2;
import com.huanduguihua.user.bean.User;

@Controller
@RequestMapping("/gray/personalityB")
public class PersonalityBController {

	@Autowired
	TestQuestionLangService2 testQuestionLangService2;
	@Autowired
	TestQuestionAcswerService2 testQuestionAcswerService2;
	@RequestMapping(value="Questiondatas",method=RequestMethod.POST)
	public void Questiondatas(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam("pagestart") Integer pagestart,
			@RequestParam("pagesize") Integer pagesize){
		TestOperationbSearch tqs = new TestOperationbSearch();
		User u = (User) request.getSession().getAttribute("user");
		tqs.setKinds(4);
		try {
			TestOperationbSearch search;
			if(u.getUsername().startsWith("3")){
				search = testQuestionLangService2.list(tqs,pagestart,pagesize);
			}else{
				search = testQuestionLangService2.listcr(tqs,pagestart,pagesize);
			}
			
			if(search.getCount()>0){
				List<TestQuestionLang2> list = (List<TestQuestionLang2>) search.getDatas();
				TestQuestionLang2 testQuestionLang=(TestQuestionLang2) list.get(0);
				List<TestQuestionAnswer2> l ;
				if(u.getUsername().startsWith("3")){
					l =testQuestionAcswerService2.getlist(testQuestionLang.getId()+"");
				}else{
					l =testQuestionAcswerService2.getlistcr(testQuestionLang.getId()+"");
				}
				JSONArray arr = new JSONArray();
					JSONObject objlang = new JSONObject();
					objlang.put("question_text", testQuestionLang.getQuestion_text());
					objlang.put("question_no", testQuestionLang.getId());
					objlang.put("datacountnumber", search.getCount());
					objlang.put("invberte", testQuestionLang.getInverted());
					arr.put(objlang);
					for(int y = 0 ; y < l.size() ; y++){
						TestQuestionAnswer2 tqa = l.get(y);
						JSONObject obj = new JSONObject();
							obj.put("option_text", tqa.getOption_text());
							obj.put("option_score", tqa.getOption_score());
							obj.put("option_s", tqa.getOption_s());
							arr.put(obj);
					}
					response.setContentType("test/javascript;charset=utf-8");
					response.getWriter().print(arr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
