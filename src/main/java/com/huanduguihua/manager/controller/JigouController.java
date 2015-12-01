package com.huanduguihua.manager.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.huanduguihua.manager.bean.Jigou;
import com.huanduguihua.manager.bean.search.JigouSearch;
import com.huanduguihua.manager.service.JigouService;
import com.huanduguihua.system.controller.DefaultController;

@Controller
@RequestMapping("/jigou")
public class JigouController extends DefaultController{

	@Autowired JigouService jigouService;
	
	@RequestMapping(value="jigoudata",method=RequestMethod.POST)
	public void jigoudata(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("page") Integer page,@RequestParam("rows") Integer rows){
//		Integer page = Integer.parseInt(request.getParameter("page"));
//		Integer rows = Integer.parseInt(request.getParameter("rows"));
		JigouSearch jigouSearch=new JigouSearch();
		try {
			JigouSearch jigouSearch2 = jigouService.list(jigouSearch, page, rows);
			Long toal = jigouSearch2.getCount();
			List<Jigou> l=(List<Jigou>) jigouSearch2.getDatas();
			JSONObject json = new JSONObject();
			JSONArray arr2 = new JSONArray();
			json.put("total", toal);
			for(int i = 0 ; i < l.size(); i ++ ){
				JSONObject obj = new JSONObject();
				Jigou jigou = (Jigou) l.get(i);
				obj.put("id", jigou.getId());
				obj.put("name",jigou.getName());
				obj.put("describe",jigou.getDescribe());
				arr2.put(obj);
			}
			json.put("rows", arr2);
			super.outjson(request, response, json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value="jigouman",method=RequestMethod.GET)
	public String jigouman(HttpServletRequest request){
		return "manager/jigou/jigouman";
	}
	
	@RequestMapping(value="jigouadd",method=RequestMethod.GET)
	public String jigouadd(HttpServletRequest request,
			@RequestParam("chaozuo") String chaozuo,
			@RequestParam(value="id",required=false) Integer id){
		if("add".equals(chaozuo)){
			request.setAttribute("chaozuo", "add");
		}
		else if("update".equals(chaozuo)){
			Jigou jigou = jigouService.get(id);
			request.setAttribute("chaozuo", "update");
			request.setAttribute("jigou", jigou);
		}
		else if("look".equals(chaozuo)){
			Jigou jigou = jigouService.get(id);
			request.setAttribute("chaozuo", "look");
			request.setAttribute("jigou", jigou);
		}
		return "manager/jigou/jigouadd";
	}
	@RequestMapping(value="jigouadddata",method=RequestMethod.POST)
	public void jigouadddata(HttpServletRequest request,HttpServletResponse response,@RequestParam("jigou_name") String jigou_name,@RequestParam("jigou_describe") String jigou_describe){
		try {
			Jigou jigou = new Jigou();
			jigou.setDescribe(jigou_describe);
			jigou.setName(jigou_name);
			jigouService.save(jigou);
			super.out(request, response, "ok");
		} catch (Exception e) {
			super.out(request, response, "no");
			e.printStackTrace();
		}
	}
	@RequestMapping(value="jigouupdate",method=RequestMethod.POST)
	public void jigouupdate(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="jigou_name",required=false) String jigou_name,
			@RequestParam(value="jigou_describe",required=false) String jigou_describe,
			@RequestParam(value="jigou_id",required=false) Integer id){
		try {
			Jigou jigou = new Jigou();
			jigou.setDescribe(jigou_describe);
			jigou.setId(id);
			jigou.setName(jigou_name);
			jigouService.update(jigou);
			super.out(request, response, "ok");
		} catch (Exception e) {
			super.out(request, response, "no");
			e.printStackTrace();
		}
	}
	@RequestMapping(value="jigoudelete",method=RequestMethod.POST)
	public void jigoudelete(HttpServletRequest request,HttpServletResponse response,@RequestParam("id") String id){
		try {
			String[] ids=id.split(",");
			for(int i = 0 ; i<ids.length ; i ++){
				jigouService.delete(Integer.parseInt(ids[i]));
			}
			super.out(request, response, "ok");
		} catch (Exception e) {
			super.out(request, response, "no");
			e.printStackTrace();
		}
		
	}
}
