package com.huanduguihua.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huanduguihua.system.controller.DefaultController;
import com.huanduguihua.user.bean.Group;
import com.huanduguihua.user.bean.MokuaiGroup;
import com.huanduguihua.user.bean.search.GroupSearch;
import com.huanduguihua.user.service.GroupService;
import com.huanduguihua.user.service.MokuaiGroupService;

@Controller
@RequestMapping("/group")
public class GroupController extends DefaultController{
	@Autowired GroupService groupService;
	@Autowired MokuaiGroupService mokuaiGroupService;

	@RequestMapping(value="quanxianman",method=RequestMethod.GET)
	public String quanxianman(HttpServletRequest request,HttpServletResponse response){
		return "manager/userquanxian/userquanxianman";
	}
	@RequestMapping(value="userquanxianadd",method=RequestMethod.GET)
	public String userquanxianadd(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("chaozhuo", "add");
		return "manager/userquanxian/userquanxianadd";
	}
	@RequestMapping(value="userquanxianadata",method=RequestMethod.POST)
	public void userquanxianadata(HttpServletRequest request,HttpServletResponse response){
		GroupSearch groupSearch=new GroupSearch();
		String pagestart = request.getParameter("page");
		String pagesize = request.getParameter("rows");
		try {
			GroupSearch gs = groupService.list(groupSearch, pagestart, pagesize);
			List<Group> lu = (List<Group>) gs.getDatas();
			Long toal = gs.getCount();
			JSONObject json = new JSONObject();
			JSONArray arr2 = new JSONArray();
			json.put("total", toal);
			for(int i = 0 ; i < lu.size() ; i++){
				Group group = lu.get(i);
				JSONObject objlang = new JSONObject();
				objlang.put("id", group.getId());
				objlang.put("name", group.getName());
				arr2.put(objlang);
			}
			json.put("rows", arr2);
			super.outjson(request, response, json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 保存
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="userquanxiasave",method=RequestMethod.POST)
	public void userquanxiasave(HttpServletRequest request,HttpServletResponse response){
		int id = groupService.generateId("`group`");
		String mokuaiid = request.getParameter("mokuaiid");
		String groupname = request.getParameter("groupname");
		String mokuaiids[]=mokuaiid.split(",");
		Group group = new Group();
		group.setId(id);
		group.setName(groupname);
		try {
			if(mokuaiids.length>0){
				for(int i= 0 ; i<mokuaiids.length;i++){
					MokuaiGroup mokuaiGroup=new MokuaiGroup();
					mokuaiGroup.setGroupId(id);
					mokuaiGroup.setMokuaiId(Integer.parseInt(mokuaiids[i]));
					mokuaiGroupService.save(mokuaiGroup);
				}
			}
			groupService.save(group);
			response.getWriter().print("ok");
		} catch (Exception e) {
			super.out(request, response, "no");
			e.printStackTrace();
		}
		
	}
	/**
	 * 权限修改
	 * @param request
	 * @return
	 */
	@RequestMapping(value="groupupdateui",method=RequestMethod.GET)
	public String groupupdateui(HttpServletRequest request){
		Integer gid=Integer.parseInt(request.getParameter("gid"));
		String chaozuo = request.getParameter("chaozuo");
		List<MokuaiGroup> l = mokuaiGroupService.list(gid);
		String mgid="";
		for(MokuaiGroup mg:l){
			mgid=mgid+mg.getMokuaiId()+",";
		}
		mgid = mgid.substring(0, mgid.length()-1);
		Group g=groupService.get(gid);
		request.setAttribute("group", g);
//		System.out.println(mgid);
		request.setAttribute("mokuaigroup", mgid);
		if("update".equals(chaozuo)){
			request.setAttribute("chaozhuo", "update");
		}
		else{
			request.setAttribute("chaozhuo", "look");
		}
		return "manager/userquanxian/userquanxianadd";
	}
	@RequestMapping(value="groupupdate",method=RequestMethod.POST)
	public void groupupdate(HttpServletRequest request,HttpServletResponse response){
		Integer id = Integer.parseInt(request.getParameter("groupid"));
		String mokuaiid = request.getParameter("mokuaiid");
		String groupname = request.getParameter("groupname");
		String mokuaiids[]=mokuaiid.split(",");
		Group group = new Group();
		group.setId(id);
		group.setName(groupname);
		mokuaiGroupService.deleteg(id);
		try {
			if(mokuaiids.length>0){
				for(int i= 0 ; i<mokuaiids.length;i++){
					MokuaiGroup mokuaiGroup=new MokuaiGroup();
					mokuaiGroup.setGroupId(id);
					mokuaiGroup.setMokuaiId(Integer.parseInt(mokuaiids[i]));
					mokuaiGroupService.save(mokuaiGroup);
				}
			}
			groupService.update(group);
			response.getWriter().print("ok");
		} catch (Exception e) {
			super.out(request, response, "no");
			e.printStackTrace();
		}
		
	}
	/**
	 * 删除
	 */
	@RequestMapping(value="groupdelete",method=RequestMethod.POST)
	public void groupdelete(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("groupid");
		String [] ids = id.split(",");
		if(ids.length>0){
			for(int i = 0 ; i < ids.length ; i++){
				groupService.delete(Integer.parseInt(ids[i]));
				mokuaiGroupService.deleteg(Integer.parseInt(ids[i]));
			}
		}
		try {
			response.getWriter().print("ok");
		} catch (IOException e) {
			super.out(request, response, "no");
			e.printStackTrace();
		}
		
	}
}
