/**
 * com.huanduguihua.user.controller
 * UserController.java
 * 
 * 2014-5-14-上午11:22:27
 *  2014成都酷信科技公司-版权所有
 * 
 */
package com.huanduguihua.user.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.huanduguihua.exception.BusinessException;
import com.huanduguihua.manager.bean.Jigou;
import com.huanduguihua.manager.service.JigouService;
import com.huanduguihua.manager.service.QuestionUrlService;
import com.huanduguihua.system.controller.DefaultController;
import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.util.AccessUtil;
import com.huanduguihua.system.util.CommonUtils;
import com.huanduguihua.system.util.SystemUtils;
import com.huanduguihua.system.util.UserUtils;
import com.huanduguihua.user.bean.Group;
import com.huanduguihua.user.bean.Mokuai;
import com.huanduguihua.user.bean.MokuaiGroup;
import com.huanduguihua.user.bean.User;
import com.huanduguihua.user.bean.UserGroup;
import com.huanduguihua.user.bean.search.UserSearch;
import com.huanduguihua.user.service.CreateTxt;
import com.huanduguihua.user.service.GroupService;
import com.huanduguihua.user.service.JinduisFinishService;
import com.huanduguihua.user.service.MokuaiGroupService;
import com.huanduguihua.user.service.MokuaiJinduisFinishService;
import com.huanduguihua.user.service.MokuaiService;
import com.huanduguihua.user.service.ReportUtils;
import com.huanduguihua.user.service.UserGroupService;
import com.huanduguihua.user.service.UserService;

/**
 * 
 * 用户控制器
 * 如果需要用户登录，链接跳转到http://域名.com/项目/user/login即可，登陆成功后会自动跳转到登录前的页面。
 * 如果用户需要注销登录，链接为：http://域名.com/项目/user/logout，调用即可，注销成功后返回注销前的页面。
 * 如何判断用户是否登录：
 *   调用方法：UserUtils.getLoginUser(request);一定会返回一个User对象，如果user的id为空表示没有登录，如果id不为空，表示已经登陆
 * 
 * 方法：
 * 	getLogin	/login	用户登录页面
 * 	postLogin	/login	用户登录请求处理
 * 	getLogout	/logout	用户注销登录
 * 	
 * 
 * 
 * 2014-5-14 上午11:22:27
 * 
 * @author KangJia
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("user")
public class UserController extends DefaultController{
	
	private final static Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired UserService userService;
	@Autowired JinduisFinishService jinduisFinishService;
	@Autowired MokuaiService mokuaiService;
	@Autowired QuestionUrlService questionUrlService;
	@Autowired GroupService groupService;
	@Autowired UserGroupService userGroupService;
	@Autowired MokuaiGroupService mokuaiGroupService;
	@Autowired MokuaiJinduisFinishService mokuaiJinduisFinishService;
	@Autowired JigouService jigouService;
	
	@RequestMapping
	public String defaultProcess(HttpServletResponse response) throws IOException {
		response.getWriter().println("DefaultController");
		return null;
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String getLogin(Model model, HttpServletRequest request, HttpServletResponse response) {
		String ref = request.getHeader("Referer");
		ref = StringUtils.isEmpty(ref) ? request.getScheme()+"://"+request.getServerName()+request.getContextPath()+"/" : ref;
		ref = CommonUtils.encodeUtf8(ref);
		model.addAttribute("ref", ref);
		model.addAttribute("user", UserUtils.getLoginUser(request));
		return "user/login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String postLogin(Model model, HttpServletRequest request, HttpServletResponse response,
			@Valid @ModelAttribute("user") User user,
			@RequestParam("ref") String ref,
			@RequestParam("checkcode") String checkcode, Errors errors) 
					throws ServletException, IOException {
		
		if (errors.hasErrors()) {
			for (ObjectError oe : errors.getAllErrors()) {
				request.setAttribute("errorMessage", oe.getDefaultMessage());
				ref = CommonUtils.encodeUtf8(ref);
				model.addAttribute("ref", ref);
				model.addAttribute("user", user);
				return "user/login";
			}
		}
		try {
			userService.update(user);
		} catch (ServiceException e1) {
			e1.printStackTrace();
		}
		String sessioncode = (String) request.getSession().getAttribute("code");
		User loginUser = UserUtils.getLoginUser(request);
		if (loginUser != null && loginUser.getId() != null) {
			return "redirect:"+ref;
		}
		if (StringUtils.equalsIgnoreCase(checkcode, sessioncode)) {
//			request.getSession().setAttribute("loginUser", user);
			
			try {
				user = userService.checkLogin(user.getUsername(), user.getPassword());
				UserUtils.setLoginUser(request, user);
				return "redirect:"+ref;	
			} catch (ServiceException e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", "账号或密码有误");
				ref = CommonUtils.encodeUtf8(ref);
				model.addAttribute("ref", ref);
				model.addAttribute("user", user);
				return "user/login";
			}
		} else {
			try {
				user = userService.checkLogin(user.getUsername(), user.getPassword());
			} catch (ServiceException e) {
				logger.info("用户登录失败");
			}
			request.setAttribute("errorMessage", "验证码有误");
			ref = CommonUtils.encodeUtf8(ref);
			model.addAttribute("ref", ref);
			model.addAttribute("user", user);
			return "user/login";
		}
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String getLogout(HttpServletRequest request, HttpServletResponse response) {
		
		UserUtils.removeLoginUser(request);
		return "redirect:" + request.getHeader("Referer");
	}
	
	
	@RequestMapping(value="edit", method=RequestMethod.GET)
	public String getEdit(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="id",required=false) Integer id) {
		
		User user = null;
		try {
			user = userService.get(id);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("user", user);
		return "user/edit";
	}
	
	@RequestMapping(value="edit", method=RequestMethod.POST)
	public String postEdit(Model model, HttpServletRequest request, HttpServletResponse response,
			@Valid @ModelAttribute("user") User user, Errors errors) 
					throws ServletException, IOException {
		
		if (errors.hasErrors()) {
			System.out.println("有错误？");
		}
		try {
			user = userService.update(user);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "redirect:edit?id="+user.getId();
	}
	/**
	 * 查询所有的机构
	 */
	@RequestMapping(value="jigoudata",method=RequestMethod.POST)
	public void jigoudata(HttpServletRequest request, HttpServletResponse response){
		List<Jigou> j = jigouService.getall();
		JSONArray jsonArray = new JSONArray();
		try {
			for(int i = 0 ; i< j.size() ; i++){
				JSONObject joo = new JSONObject();
				joo.put("name", j.get(i).getName());
				joo.put("value", j.get(i).getId());
				jsonArray.put(joo);
			}
			super.outjson(request, response, jsonArray);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 用户管理
	 */
	@RequestMapping(value="usermanager",method=RequestMethod.GET)
	public String usermanager(HttpServletRequest request, HttpServletResponse response){
		request.setAttribute("jigoulist", jigouService.getall());
		return "manager/user/usermanager";
	}
	@RequestMapping(value="userlist",method=RequestMethod.POST)
	public void userlist(Model model , HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="queryValue",required=false) Integer queryValue,
			@RequestParam(value="querykey",required=false) String querykey,
			@RequestParam(value="queryval",required=false) String queryval){
		UserSearch userSearch = new UserSearch();
		String pagestart = request.getParameter("page");
		String pagesize = request.getParameter("rows");
		String sort = request.getParameter("sort");
		String order = request.getParameter("order");
		if(queryValue!=null){
			userSearch.setQueryValue(queryValue);
		}
		if(!StringUtils.isEmpty(queryval)){
			userSearch.setSearchkey(querykey);
			userSearch.setSearchval(queryval);
			System.out.println(queryval);
		}
		try {
			UserSearch list = userService.list(userSearch,pagestart,pagesize,sort,order);
			List<User> lu = (List<User>) list.getDatas();
			Long toal = list.getCount();
			JSONObject json = new JSONObject();
			JSONArray arr2 = new JSONArray();
			json.put("total", toal);
			for(int i = 0 ; i < lu.size() ; i++){
				User u = lu.get(i);
				Jigou jigou = jigouService.get(u.getJigou());
				JSONObject objlang = new JSONObject();
				objlang.put("id", u.getId());
				objlang.put("name", u.getName());
				objlang.put("username", u.getUsername());
				objlang.put("password", u.getPassword());
				objlang.put("createTime", u.getCreateTime());
				objlang.put("xingbie", u.getXingbie());
				objlang.put("nianling", u.getNianling());
				objlang.put("minzu", u.getMinzu());
				objlang.put("xueli", u.getXueli());
				objlang.put("nianji", u.getNianji());
				objlang.put("banji", u.getBanji());
				objlang.put("xueshengleixing", u.getXueshengleixing());
				objlang.put("yuanxuexileixing", u.getYuanxuelileixing());
				objlang.put("shenfenzheng", u.getShenfenzheng());
				objlang.put("fuqinxingming", u.getFuqinxingming());
				objlang.put("muqinxingming", u.getMuqinxingming());
				objlang.put("fuqinnianling", u.getFuqinnianling());
				objlang.put("muqinnianling", u.getMuqinnianling());
				objlang.put("danwei", u.getDanwei());
				objlang.put("gudingdianhua", u.getGudingdianhua());
				objlang.put("yidongdianhua", u.getYidongdianhua());
				objlang.put("email", u.getEmail());
				objlang.put("dizhi", u.getDizhi());
				objlang.put("shili", u.getShili());
				objlang.put("tingli", u.getTingli());
				objlang.put("sejue", u.getSejue());
				objlang.put("money", u.getMoney());
				objlang.put("isuse", u.getIsuse());
				objlang.put("wancheng_time", u.getWanchengTime());
				if(jigou!=null){
					objlang.put("jigou", jigou.getName());
					objlang.put("jigouid",jigou.getId());
				}
				
				arr2.put(objlang);
			}
			json.put("rows", arr2);
			super.outjson(request, response, json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户添加
	 */
	
	@RequestMapping(value="userAddui",method=RequestMethod.GET)
	public String userAddui(Model model , HttpServletRequest request, HttpServletResponse response){
		request.setAttribute("type", request.getParameter("type"));
		request.setAttribute("jigoulist", jigouService.getall());
		request.setAttribute("grouplist", groupService.getlist());
		Integer uid = userService.chaxunuser();
		String uname = ""+(30000000+uid+1);
		request.setAttribute("u_name", uname);
		return "manager/user/useradd";
	}
	
	@RequestMapping(value="userAdd",method=RequestMethod.POST)
	public void userAdd(Model model , HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="u_jigou" ,required=false) Integer u_jigou,
			@RequestParam(value="u_group" ,required=false) Integer u_group){
		try {
			System.out.println("u_group=="+u_group);
			User u = new User();
			String name=request.getParameter("u_name");
			String password=request.getParameter("u_password");
			String username=request.getParameter("u_username");
			String xingbie=request.getParameter("u_xingbie");
			int nianling=0;
			if(request.getParameter("u_nianling") != "")
				nianling=Integer.parseInt(request.getParameter("u_nianling"));
			String minzu=request.getParameter("u_minzu");
			String xueli = request.getParameter("u_xueli");
			String nianji=request.getParameter("u_nianji");
			String banji=request.getParameter("u_banji");
			String xueshengleixing = request.getParameter("u_xueshengleixing");
			String yuanxuexileixing = request.getParameter("u_yuanxuexileixing");
			String shenfenzheng = request.getParameter("u_shenfenzheng");
			String fuqinxingming = request.getParameter("u_fuqinxingming");
			String muqinxingming = request.getParameter("u_muqinxingming");
			int fuqinnianling=0;
			if(request.getParameter("u_fuqinnianling") != "")
				fuqinnianling = Integer.parseInt(request.getParameter("u_fuqinnianling"));
			int muqinnianling=0;
			if(request.getParameter("u_muqinnianling") != "")
				muqinnianling = Integer.parseInt(request.getParameter("u_muqinnianling"));
			String danwei = request.getParameter("u_danwei");
			String gudingdianhua = request.getParameter("u_gudingdianhua");
			String yidongdianhua = request.getParameter("u_yidongdianhua");
			String email = request.getParameter("u_email");
			String dizhi = request.getParameter("u_dizhi");
			String shili = request.getParameter("u_shili");
			String tingli = request.getParameter("u_tingli");
			String sejue = request.getParameter("u_sejue");
			String money = request.getParameter("u_money");
			u.setBanji(banji);
			u.setDanwei(danwei);
			u.setDizhi(dizhi);
			u.setEmail(email);
			u.setName(name);
			u.setFuqinnianling(fuqinnianling);
			u.setFuqinxingming(fuqinxingming);
			u.setGudingdianhua(gudingdianhua);
			u.setMinzu(minzu);
			u.setMuqinnianling(muqinnianling);
			u.setMuqinxingming(muqinxingming);
			
			u.setJigou(u_jigou);
			u.setNianji(nianji);
			u.setNianling(nianling);
			u.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
			u.setSejue(sejue);
			u.setShenfenzheng(shenfenzheng);
			u.setShili(shili);
			u.setTingli(tingli);
			u.setUsername(username);
			u.setXingbie(xingbie);
			u.setXueli(xueli);
			u.setXueshengleixing(xueshengleixing);
			u.setYidongdianhua(yidongdianhua);
			u.setYuanxuelileixing(yuanxuexileixing);
			u.setMoney(money);
			u.setIsuse(0);
			u.setIswancheng(0);
			User user =userService.update(u);
			userGroupService.delete(user.getId());
			UserGroup group=new UserGroup();
			group.setGroupId(u_group);
			group.setUserId(user.getId());
			userGroupService.save(group);
			super.out(request, response, "ok");
		} catch (Exception e) {
			super.out(request, response, "no");
			e.printStackTrace();
		}
	}
	/**
	 * 用户批量生成
	 */
	@RequestMapping(value="userautoAddui",method=RequestMethod.GET)
	public String userautoAddui(Model model , HttpServletRequest request, HttpServletResponse response){
		List<Group> listgroup = groupService.getlist();
		List<Jigou> jigous = jigouService.getall();
		request.setAttribute("listgroup", listgroup);
		request.setAttribute("listjigou", jigous);
		return "manager/user/userautoadd";
	}
	
	@RequestMapping(value="userautoAdd",method=RequestMethod.POST)
	public void userautoAdd(Model model , HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="u_jigou" ,required=false) Integer u_jigou){
		String u_usernumber = request.getParameter("u_usernumber");
		String u_money = request.getParameter("u_money");
		String u_banben = request.getParameter("u_banben");
		String userquanxian = request.getParameter("userquanxian");
		Integer userid = userService.chaxunuser();
		String username = "";
		String context="授权码                         密码\r\n";
		JSONArray arrerr=new JSONArray();
		JSONObject objerr = new JSONObject();
		try {
			objerr.put("ok", "no");
			arrerr.put(objerr);
			for(int i =1;i<=Integer.parseInt(u_usernumber);i++){
				int in=(int) (Math.random()*100);
				in=in+100;
				String password=SystemUtils.generatePassword();
				userid=userid+1;
				System.out.println("banben="+u_banben);
				if("0".equals(u_banben)){//青少年
					username=""+(30000000+userid);
				}else{//成人
					username=""+(70000000+userid);
				}
				context=context+"\r\n"+username+"                    "+password;
				User u = new User();
				u.setUsername(username+"");
				u.setPassword(DigestUtils.md5DigestAsHex((password).getBytes()));
				u.setMoney(u_money);
				u.setJigou(u_jigou);
				u.setIsuse(0);
				u.setIswancheng(0);
				User user=userService.update(u);
				userGroupService.delete(user.getId());
				UserGroup userGroup= new UserGroup();
				userGroup.setUserId(user.getId());
				userGroup.setGroupId((Integer.parseInt(userquanxian)));
				userGroupService.save(userGroup);
			}
			String fileurl = ReportUtils.getwebpath()+"download/user/"+username+".txt";
			CreateTxt.createwjj(ReportUtils.getwebpath()+"download/user");
			File f=new File(fileurl);
			if(f.exists()){
				f.delete();
			}
			CreateTxt.contentToTxt(fileurl, context);
			JSONArray arr=new JSONArray();
			JSONObject obj = new JSONObject();
			obj.put("ok", "ok");
			obj.put("fileurl", "download/user/"+username+".txt");
			obj.put("filename", username+".txt");
			arr.put(obj);
			super.outjson(request, response, arr);
		} catch (Exception e) {
			super.outjson(request, response, arrerr);
			e.printStackTrace();
		}
	}
	@RequestMapping(value="fileload",method=RequestMethod.GET)
	public void fileload(Model model , HttpServletRequest request, HttpServletResponse response,
			@RequestParam("type") String type){
		if("c".equals(type)){
			String url=request.getParameter("fileurl");
			url=ReportUtils.getwebpath()+url;
			File f =new File(url);
			ReportUtils.FileDown(response, f);
			f.delete();
		}
		else if("u".equals(type)){
			String url=request.getParameter("fileurl");
			url=ReportUtils.getwebpath()+url;
			File f =new File(url);
			ReportUtils.FileDown(response, f);
		}
	}
	/**
	 * 用户查看
	 */
	
	@RequestMapping(value="userlook",method=RequestMethod.GET)
	public String userlook(Model model , HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		String type=request.getParameter("type");
		try {
			User u = userService.get(Integer.parseInt(id));
			request.setAttribute("user", u);
			request.setAttribute("jigoulist", jigouService.getall());
			request.setAttribute("usergroup", userGroupService.getUsergGroup(u));
			request.setAttribute("grouplist", groupService.getlist());
			request.setAttribute("type", type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "manager/user/useradd";
	}
	
	
	/**
	 * 用户修改
	 */
	
	@RequestMapping(value="userupdate",method=RequestMethod.POST)
	public void userupdate(Model model , HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="u_jigou" ,required=false) Integer u_jigou,
			@RequestParam(value="u_group" ,required=false) Integer u_group){
		try {
			User u = new User();
			int id=0;
			if(request.getParameter("u_id") != null){
				id=Integer.parseInt(request.getParameter("u_id"));
				u=userService.get(id);
			}
			else{
				response.getWriter().print("no");
				return;
			}
			String name=request.getParameter("u_name");
			String password=request.getParameter("u_password");
			String username=request.getParameter("u_username");
			String xingbie=request.getParameter("u_xingbie");
			int nianling=0;
			if(request.getParameter("u_nianling") != "")
				nianling=Integer.parseInt(request.getParameter("u_nianling"));
			String minzu=request.getParameter("u_minzu");
			String xueli = request.getParameter("u_xueli");
			String nianji=request.getParameter("u_nianji");
			String banji=request.getParameter("u_banji");
			String xueshengleixing = request.getParameter("u_xueshengleixing");
			String yuanxuexileixing = request.getParameter("u_yuanxuexileixing");
			String shenfenzheng = request.getParameter("u_shenfenzheng");
			String fuqinxingming = request.getParameter("u_fuqinxingming");
			String muqinxingming = request.getParameter("u_muqinxingming");
			int fuqinnianling=0;
			if(request.getParameter("u_fuqinnianling") != "")
				fuqinnianling = Integer.parseInt(request.getParameter("u_fuqinnianling"));
			int muqinnianling=0;
			if(request.getParameter("u_muqinnianling") != "")
				muqinnianling = Integer.parseInt(request.getParameter("u_muqinnianling"));
			String danwei = request.getParameter("u_danwei");
			String gudingdianhua = request.getParameter("u_gudingdianhua");
			String yidongdianhua = request.getParameter("u_yidongdianhua");
			String email = request.getParameter("u_email");
			String dizhi = request.getParameter("u_dizhi");
			String shili = request.getParameter("u_shili");
			String tingli = request.getParameter("u_tingli");
			String sejue = request.getParameter("u_sejue");
			String money = request.getParameter("u_money");
			String zuotijindu = request.getParameter("u_zuotijindu");
			String iswancheng = request.getParameter("u_iswancheng");
			u.setMoney(money);
			u.setBanji(banji);
			u.setDanwei(danwei);
			u.setDizhi(dizhi);
			u.setEmail(email);
			u.setName(name);
			u.setFuqinnianling(fuqinnianling);
			u.setFuqinxingming(fuqinxingming);
			u.setGudingdianhua(gudingdianhua);
			u.setMinzu(minzu);
			u.setJigou(u_jigou);
			u.setMuqinnianling(muqinnianling);
			u.setMuqinxingming(muqinxingming);
			u.setNianji(nianji);
			u.setNianling(nianling);
			if(password!=null&&password.length()==32) {
				System.out.println("修改用户" + username +"的资料，保持原有的密码");
				u.setPassword(password);
			} else {
				System.out.println("修改用户" + username +"的资料，更新用户的密码");
				u.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
			}
			u.setSejue(sejue);
			u.setShenfenzheng(shenfenzheng);
			u.setShili(shili);
			u.setTingli(tingli);
			u.setUsername(username);
			u.setXingbie(xingbie);
			u.setXueli(xueli);
			u.setXueshengleixing(xueshengleixing);
			u.setYidongdianhua(yidongdianhua);
			u.setYuanxuelileixing(yuanxuexileixing);
			if(zuotijindu!=null && zuotijindu.length()>0){
				u.setZuotijindu(Integer.valueOf(zuotijindu));
				u.setIswancheng(Integer.valueOf(iswancheng));
			}
			userService.update(u);
			userGroupService.delete(u.getId());
			UserGroup group=new UserGroup();
			group.setGroupId(u_group);
			group.setUserId(u.getId());
			userGroupService.save(group);
			super.out(request, response, "ok");
		} catch (Exception e) {
			super.out(request, response, "no");
			e.printStackTrace();
		}
	}
	/**
	 * 用户删除
	 */
	@RequestMapping(value="userdelete",method=RequestMethod.POST)
	public void userdelete(Model model , HttpServletRequest request, HttpServletResponse response){
		try {
			if(request.getParameter("id") != ""){
				String[] uid=request.getParameter("id").split(",");
				for(int i = 0 ; i < uid.length ; i ++){
					userService.delete(Integer.valueOf(uid[i]));
				}
				super.out(request, response, "ok");
			}
			else{
				super.out(request, response, "no");
			}
		} catch (Exception e) {
			super.out(request, response, "no");
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户登录
	 */
	
	@RequestMapping(value="userloginui",method=RequestMethod.GET)
	public String userloginui(Model model , HttpServletRequest request, HttpServletResponse response){
		return "start";
	}
	
	@RequestMapping(value="userlogin",method=RequestMethod.POST)
	public void userlogin(Model model , HttpServletRequest request, HttpServletResponse response,
			@RequestParam("username") String username,
			@RequestParam("password") String password){
		try {
			password = DigestUtils.md5DigestAsHex(password.getBytes());
			
			User user = userService.getUserByUsername(username);
			System.out.println("user: " + user);
			if (user == null) {
				response.getWriter().print("nouser");
			} else if (!user.getPassword().equalsIgnoreCase(password)) {
				response.getWriter().print("nopassword");
			}
//			else if (user.getOnline()) {
//				response.getWriter().print("online");
//			}
			else if(user.getIswancheng()==1){
					model.addAttribute("user", user);
					response.getWriter().print("iswancheng");
			} else {
				user.setIsuse(1);
				//user.setOnline(true);
				userService.endableOnline(username);
				super.out(request, response, "ok");
			}
			request.getSession().setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	   @RequestMapping(value="wzlogin")
	    public String wzlogin(Model model , HttpServletRequest request, HttpServletResponse response,
	            @RequestParam("username") String username,
	            @RequestParam("password") String password) throws Exception{
	           // password = DigestUtils.md5DigestAsHex(password.getBytes());
	            
	            User user = userService.getUserByUsername(username);
	            System.out.println("user: " + user);
	            if (user == null) {
	                throw new BusinessException("用户不存在。");
//	                response.getWriter().print("nouser");
	            } else if (!user.getPassword().equalsIgnoreCase(password)) {
	                throw new BusinessException("密码错误。");
	             //   response.getWriter().print("nopassword");
	            }
//	          else if (user.getOnline()) {
//	              response.getWriter().print("online");
//	          }
	            else if(user.getIswancheng()==1){
	                    model.addAttribute("user", user);
	                    throw new BusinessException("用户已完成测试。");
	                   //  response.getWriter().print("iswancheng");
	            } else {
	                user.setIsuse(1);
	                //user.setOnline(true);
	                userService.endableOnline(username);
	                super.out(request, response, "ok");
	                request.getSession().setAttribute("user", user);
	            }
	        return "redirect:/login/copyright";
	    }
	/**
	 * 验证授权码是否存在
	 */
	@RequestMapping(value="checkusername",method=RequestMethod.POST)
	public void checkusername(Model model , HttpServletRequest request , HttpServletResponse response){
		String username = request.getParameter("username");
		boolean b = userService.checkUsername(username);
		try {
			if(b==true){
				super.out(request, response, "ok");
			}
			else{
				super.out(request, response, "no");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 列出用户所有做题情况
	 */
	@RequestMapping(value="listquestion",method=RequestMethod.GET)
	public String listquestion(Model model , HttpServletRequest request , HttpServletResponse response){
		String userid = request.getParameter("id");
		String tablename=request.getParameter("tablename");
		String kinds=request.getParameter("kinds");
		try {
			userService.listquestionqk(userid,tablename,kinds,request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "manager/user/userfenshuinfo";
	}
	/**
	 * 一键生成文件
	 */
	@RequestMapping(value="yijiancreate",method=RequestMethod.POST)
	public void yijiancreate(HttpServletRequest request , HttpServletResponse response){
		String id = request.getParameter("id");
		String[] uid=id.split(",");
		JSONArray arrerr=new JSONArray();
		JSONObject objerr = new JSONObject();
		String shibaiuser="";
		try {
			objerr.put("ok", "err");
			arrerr.put(objerr);
			List<String> listurl=new ArrayList<String>();
			for(int i =0;i<uid.length;i++){
				User u = userService.get(Integer.parseInt(uid[i]));
				int step = userService.generateReport(u);
//				if(b){
					userService.generatedat(u,step);
					if(step==34){//全量
					    AccessUtil.getInstance().generateAccess(u, ReportUtils.getwebpath()+"download/data/"+u.getUsername()+".mdb",ReportUtils.getwebpath()+"download/data/"+u.getUsername()+".dat");
					}else{//非全量
					    AccessUtil.getInstance().generateAccessDanxiang(u, ReportUtils.getwebpath()+"download/data/"+u.getUsername()+".mdb",ReportUtils.getwebpath()+"download/data/"+u.getUsername()+".dat");
					}
					listurl.add(ReportUtils.getwebpath()+"download/data/"+u.getUsername()+".txt");
					listurl.add(ReportUtils.getwebpath()+"download/data/"+u.getUsername()+".dat");
					listurl.add(ReportUtils.getwebpath()+"download/data/"+u.getUsername()+".mdb");
//				}
//				else{
					shibaiuser=shibaiuser+u.getUsername()+"、";
//					File f=new File(ReportUtils.getwebpath()+"download/data/"+u.getUsername()+".txt");
//					if(f.exists()){
//						f.delete();
//					}
//				}
			}
			JSONArray arr=new JSONArray();
			JSONObject obj = new JSONObject();
			if(listurl.size()>0){
				CreateTxt.createZIP(listurl, ReportUtils.getwebpath()+"download/data/user.zip");
				obj.put("ok", "ok");
				obj.put("fileurl", "download/data/user.zip");
				obj.put("filename", "user.zip");
				obj.put("shibaiuser", shibaiuser);
			}
			else{
				obj.put("ok", "null");
				obj.put("fileurl", "download/data/user.zip");
				obj.put("filename", "user.zip");
				obj.put("shibaiuser", shibaiuser);
			}
			arr.put(obj);
			super.outjson(request, response, arr);
		} catch (Exception e) {
			super.outjson(request, response, arrerr);
			e.printStackTrace();
		}
	}
	/**
	 * 把学生做题生成txt
	 */
	@RequestMapping(value="createStudenttxt",method=RequestMethod.POST)
	public void createStudenttxt(HttpServletRequest request , HttpServletResponse response){
		String id = request.getParameter("id");
		String[] uid=id.split(",");
		JSONArray arrerr=new JSONArray();
		JSONObject objerr = new JSONObject();
		String shibaiuser="";
		try {
			objerr.put("ok", "err");
			arrerr.put(objerr);
			List<String> listurl=new ArrayList<String>();
			for(int i =0;i<uid.length;i++){
				User u = userService.get(Integer.parseInt(uid[i]));
				userService.generateReport(u);
//				if(b==false){
					shibaiuser=shibaiuser+u.getUsername()+"、";
//					File f=new File(ReportUtils.getwebpath()+"download/data/"+u.getUsername()+".txt");
//					if(f.exists()){
//						f.delete();
//					}
//				}
//				else{
					listurl.add(ReportUtils.getwebpath()+"download/data/"+u.getUsername()+".txt");
//				}
			}
			JSONArray arr=new JSONArray();
			JSONObject obj = new JSONObject();
			if(listurl.size()>0){
				CreateTxt.createZIP(listurl, ReportUtils.getwebpath()+"download/data/user_txt.zip");
				obj.put("ok", "ok");
				obj.put("fileurl", "download/data/user_txt.zip");
				obj.put("filename", "user.zip");
				obj.put("shibaiuser", shibaiuser);
			}
			else{
				obj.put("ok", "null");
				obj.put("fileurl", "download/data/user_txt.zip");
				obj.put("filename", "user_txt.zip");
				obj.put("shibaiuser", shibaiuser);
			}
			arr.put(obj);
			super.outjson(request, response, arr);
		} catch (Exception e) {
			super.outjson(request, response, arrerr);
			e.printStackTrace();
		}
	}
	/**
	 * 把学生做题生成dat
	 */
	@RequestMapping(value="createStudentdat",method=RequestMethod.POST)
	public void createStudentdat(HttpServletRequest request , HttpServletResponse response){
		String id = request.getParameter("id");
		String[] uid=id.split(",");
		String shibaiuser="";
		JSONArray arr=new JSONArray();
		JSONObject obj = new JSONObject();
		try {
			List<String> listurl=new ArrayList<String>();
			for(int i =0;i<uid.length;i++){
				User u = userService.get(Integer.parseInt(uid[i]));
				String str = userService.generatedat(u,34);
				if("no".equals(str)){
					shibaiuser=shibaiuser+u.getUsername()+"、";
				}
				else{
					listurl.add(ReportUtils.getwebpath()+"download/data/"+u.getUsername()+".dat");
				}
			}
		
//			User u = userService.get(Integer.parseInt(uid[0]));
//			String str = userService.generatedat(u);
			
			if(listurl.size()>0){
				CreateTxt.createZIP(listurl, ReportUtils.getwebpath()+"download/data/user_data.zip");
				obj.put("ok", "ok");
				obj.put("fileurl", "download/data/user_data.zip");
				obj.put("filename", "user.zip");
				obj.put("shibaiuser", shibaiuser);
			}
			else{
				obj.put("ok", "null");
				obj.put("fileurl", "download/data/user_data.zip");
				obj.put("filename", "user_data.zip");
				obj.put("shibaiuser", shibaiuser);
			}
			arr.put(obj);
			super.outjson(request, response, arr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 把学生做题生成access
	 */
	@RequestMapping(value="createStudentaccess",method=RequestMethod.POST)
	public void createStudentaccess(HttpServletRequest request , HttpServletResponse response){
		String id = request.getParameter("id");
		String[] uid=id.split(",");
		try {
			User u = userService.get(Integer.parseInt(uid[0]));
			String fileurl=ReportUtils.getwebpath()+"download/data/"+u.getUsername()+".mdb";
			String daturl=ReportUtils.getwebpath()+"download/data/"+u.getUsername()+".dat";
			File f=new File(daturl);
			JSONArray arr=new JSONArray();
			JSONObject obj = new JSONObject();
			if(!f.exists()){
				obj.put("ok", "no");
				obj.put("fileurl", "download/data/"+u.getUsername()+".mdb");
				obj.put("filename", u.getUsername()+".mdb");
			}
			else{
				AccessUtil.getInstance().generateAccess(u, fileurl,daturl);
				obj.put("ok", "ok");
				obj.put("fileurl", "download/data/"+u.getUsername()+".mdb");
				obj.put("filename", u.getUsername()+".mdb");
			}
			arr.put(obj);
			super.outjson(request, response, arr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value="getXiaotijd",method=RequestMethod.POST)
	public void getXiaotijd(HttpServletRequest request , HttpServletResponse response){
		try {
			User user = (User)request.getSession().getAttribute("user");
			User u = userService.get(user.getId());
			JSONArray arr=new JSONArray();
			JSONObject obj = new JSONObject();
			arr.put(obj);
			obj.put("xiaotijd", u.getXiaotijd()==null?0:u.getXiaotijd());
			super.outjson(request, response, arr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 生成excel文件
	 */
	@RequestMapping(value="createStudentexcel",method=RequestMethod.POST)
	public void createStudentexcel(HttpServletRequest request , HttpServletResponse response,
			@RequestParam("id") Integer uid,
			@RequestParam("tablename") String tablename,
			@RequestParam("kinds") String kinds,
			@RequestParam("filename") String filename){
		JSONArray arr=new JSONArray();
		JSONObject obj = new JSONObject();
		JSONArray arrerr=new JSONArray();
		JSONObject objerr = new JSONObject();
		String shibaiuser="";
		try {
			objerr.put("ok", "err");
			arrerr.put(objerr);
			User u = userService.get(uid);
			String [] tablenames = tablename.split(",");
			String [] kindss = kinds.split(",");
			String [] filenames = filename.split(",");
			List<String> listurl=new ArrayList<String>();
			for(int i = 0 ; i < tablenames.length ; i++){
				boolean b=userService.generateexcel(u, tablenames[i], Integer.parseInt(kindss[i]),filenames[i]);
				if(b){
					listurl.add(ReportUtils.getwebpath()+"download/data/"+u.getUsername()+"_"+filenames[i]+".xls");
				}
				else{
					shibaiuser=shibaiuser+filenames[i]+",";
				}
			}
			if(listurl.size()>0){
				CreateTxt.createZIP(listurl, ReportUtils.getwebpath()+"download/data/"+u.getUsername()+".zip");
				obj.put("ok", "ok");
				obj.put("fileurl", "download/data/"+u.getUsername()+".zip");
				obj.put("filename", u.getUsername()+".zip");
				obj.put("shibaiuser", shibaiuser);
			}
			else{
				obj.put("ok", "null");
				obj.put("fileurl", "download/data/"+u.getUsername()+".zip");
				obj.put("filename", u.getUsername()+".zip");
				obj.put("shibaiuser", shibaiuser);
			}
			arr.put(obj);
			super.outjson(request, response, arr);
		} catch (Exception e) {
			super.outjson(request, response, arrerr);
			e.printStackTrace();
		}
	}
	/**
	 * 判断做题进度
	 * @return 
	 */
	@RequestMapping(value="checkzuoti",method=RequestMethod.GET)
	public String checkzuoti(Model model , HttpServletRequest request , HttpServletResponse response){
		return super.pagego(model, request, response);
	}
	/**
	 * 保存做题进度
	 */
	@RequestMapping(value="savejindu",method=RequestMethod.POST)
	public void savejindu(Model model , HttpServletRequest request , HttpServletResponse response){
		try {
//			String ref = request.getHeader("Referer");
//			System.out.println("ref: " + ref);
			String vals = request.getParameter("vals");
			User users = (User)request.getSession().getAttribute("user");
			User u = userService.get(users.getId());
			List<Mokuai> mokuaiurls = (List<Mokuai>) request.getSession().getAttribute("mokuaiurls");
			if(userService.isRecordNotInDb(mokuaiurls.get(u.getZuotijindu()-1).getMokuaiUrl(), u)){
				return;
			}
			if("1".equals(vals)){
				if(u.getZuotijindu()==null || u.getZuotijindu()==0){
					u.setZuotijindu(2);
					userService.update(u);
					request.getSession().setAttribute("user", u);
				}
				else{
					u.setZuotijindu(u.getZuotijindu()+1);
					userService.update(u);
					request.getSession().setAttribute("user", u);
				}
			}
			else if("2".equals(vals)){
				if(u.getMokuaijdId()==null || u.getMokuaijdId()==0){
					u.setZuotijindu(u.getZuotijindu()+1);
					u.setMokuaijdId(2);
				}
				else{
					u.setZuotijindu(u.getZuotijindu()+1);
					u.setMokuaijdId(u.getMokuaijdId()+1);
					if(u.getZuotijindu()>mokuaiurls.size()){
						u.setIswancheng(1);
						u.setWanchengTime(new Timestamp(System.currentTimeMillis()));
					}
//					User user = userService.get(u.getId());
//					List<UserGroup> l=userGroupService.list(user);
//					ArrayList<Group> al=new ArrayList<Group>();
//					List<String> mokuaiurls = new ArrayList<String>();
//					if(l!=null){
//						//查询用户有那些权限
//						Group group = groupService.get(l.get(0).getGroupId());
////						System.out.println("name:"+group.getName()+" groupid:"+group.getId());
//							al.add(group);
//						List<MokuaiGroup> listm = mokuaiGroupService.list(al.get(0).getId());
//						for(MokuaiGroup mk:listm){
//							Mokuai mkuai = mokuaiService.get(mk.getMokuaiId());
//							mokuaiurls.add(mkuai.getMokuaiUrl());
//						}
//						if(u.getZuotijindu()>mokuaiurls.size()){
//							u.setIswancheng(1);
//							u.setWanchengTime(new Timestamp(System.currentTimeMillis()));
//						}
//					}
				}
				u.setXiaotijd(0);
				userService.update(u);
				request.getSession().setAttribute("user", u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value="navselect",method=RequestMethod.GET)
	public String navselect(Model model , HttpServletRequest request , HttpServletResponse response){
		return "navselect";
	}
	/**
	 * 资料保存
	 */
	@RequestMapping(value="userdatasave",method=RequestMethod.POST)
	public void userdatasave(Model model , HttpServletRequest request , HttpServletResponse response,
			@ModelAttribute("user") User user){
//		System.out.println("保存用户资料：" + user);
		User u=(User) request.getSession().getAttribute("user");
		try {
			u=userService.get(u.getId());
		} catch (ServiceException e1) {
			e1.printStackTrace();
		}
		if(u.getZuotijindu()==null){
			user.setZuotijindu(1);
		}
		else{
			user.setZuotijindu(u.getZuotijindu());
		}
		if(u.getMokuaijdId()==null){
			user.setMokuaijdId(1);
		}
		else{
			user.setMokuaijdId(u.getMokuaijdId());
		}
		if(u.getIswancheng()==null){
			user.setIswancheng(0);
		}
		else{
			user.setIswancheng(u.getIswancheng());
		}
		user.setIswancheng(0);
		user.setId(u.getId());
		user.setJigou(u.getJigou());
		user.setMoney(u.getMoney());
		user.setUsername(u.getUsername());
		user.setPassword(u.getPassword());
		user.setIsuse(1);
		try {
			User us = userService.update(user);
			request.getSession().setAttribute("user", us);
			response.sendRedirect(request.getContextPath()+"/user/navselect");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="mokuai")
	public String mokuai(HttpServletRequest request , HttpServletResponse response,
			@RequestParam(value="start",required=false) String start,
			@RequestParam(value="load" , required=false) String load){
		User u = (User) request.getSession().getAttribute("user");
		if(u!=null){
			try {
				User user = userService.get(u.getId());
				List<UserGroup> l=userGroupService.list(user);
				ArrayList<Group> al=new ArrayList<Group>();
				List<Mokuai> mokuaiurls = new ArrayList<Mokuai>();
				if(l!=null){
					//查询用户有那些权限
					if(request.getSession().getAttribute("mokuaiurls")==null){
						Group group = groupService.get(l.get(0).getGroupId());
//					System.out.println("name:"+group.getName()+" groupid:"+group.getId());
						al.add(group);
						List<MokuaiGroup> listm = mokuaiGroupService.list(al.get(0).getId());
						for(MokuaiGroup mk:listm){
							Mokuai mkuai = mokuaiService.get(mk.getMokuaiId());
//						System.out.println(mokuaiurls.contains(mokuaiService.getFu(mkuai.getId()).getMokuaiUrl()));
//						if(!mokuaiurls.contains(mokuaiService.getFu(mkuai.getId()).getMokuaiUrl())){
//							mokuaiurls.add(mokuaiService.getFu(mkuai.getId()).getMokuaiUrl());
//						}
							mokuaiurls.add(mkuai);
						}
						request.getSession().setAttribute("mokuaiurls", mokuaiurls);
					}else{
						mokuaiurls = (List<Mokuai>) request.getSession().getAttribute("mokuaiurls");
					}
					
					
					if(user.getMokuaijdId()==null || user.getMokuaijdId()==0){
						user.setMokuaijdId(1);
					}
					
					if(user.getZuotijindu()>mokuaiurls.size()){
						return "end";
					}
					//如果当前的模块的题目已经做完了，那么进度就需要+1，这里主要为网络问题做完题目后没有点击完成更新进度补充更正
					if(userService.isRecordInDb(mokuaiurls.get(user.getZuotijindu()-1).getMokuaiUrl(), user)){
						user.setZuotijindu(user.getZuotijindu()+1);
						user.setMokuaijdId(user.getMokuaijdId()+1);
						user.setXiaotijd(0);
						if(user.getZuotijindu()>mokuaiurls.size()){
							user.setIswancheng(1);
							user.setWanchengTime(new Timestamp(System.currentTimeMillis()));
						}
						User us = userService.update(user);
						request.getSession().setAttribute("user", us);
						System.out.println("redirect:/user/mokuai");
						return "redirect:/user/mokuai";
					}
					if(userService.isRecordNotInDb(mokuaiurls.get(user.getZuotijindu()-1).getMokuaiUrl(), u)){
						user.setXiaotijd(0);
						User us = userService.update(user);
						request.getSession().setAttribute("user", us);
					}
					Mokuai mokuai = mokuaiurls.get(user.getZuotijindu()-1);
					System.out.println("user.getZuotijindu()==="+user.getZuotijindu());
					Mokuai pMokuai = mokuaiService.getFu(mokuai.getId());
					if(user.getZuotijindu()<=1 && StringUtils.isNotEmpty(start)){
//						request.setAttribute("loadflw", mokuaiurls.get(user.getZuotijindu()-1).getLoadflw());
					}
					else if(StringUtils.isNotEmpty(load) && mokuaiurls.get(user.getZuotijindu()-1).getOrderu()==1){
//						request.setAttribute("loadflw", mokuaiurls.get(user.getZuotijindu()-1).getLoadflw());
					}
					else {
						request.setAttribute("loadflw", mokuaiurls.get(user.getZuotijindu()-1).getLoadflw());
					}
					System.out.println(pMokuai.getMokuaiUrl());
					return pMokuai.getMokuaiUrl();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
			return "redirect:/";
		}
		return "redirect:/";
	}
	/**
	 * 用户分数查看界面
	 */
	@RequestMapping(value="userfenshuui",method=RequestMethod.GET)
	public String userfenshuui(Model model , HttpServletRequest request, HttpServletResponse response){
		request.setAttribute("uid", request.getParameter("uid"));
		return "manager/user/userfenshu";
	}
	@RequestMapping(value="listview",method=RequestMethod.POST)
	public void listview(Model model , HttpServletRequest request , HttpServletResponse response){
		
		JSONArray arr=new JSONArray();
		try {
			JSONObject json1=new JSONObject();
			json1.put("view", "蓝色界面 选择反应");
			json1.put("tablename", "test_reaction");
			json1.put("filename", "xzfy");
			json1.put("kinds", 0);
			arr.put(json1);
			JSONObject json2=new JSONObject();
			json2.put("view", "蓝色界面 图形匹配");
			json2.put("tablename", "test_macthing");
			json2.put("filename", "txpp");
			json2.put("kinds", 0);
			arr.put(json2);
			JSONObject json3=new JSONObject();
			json3.put("view", "蓝色界面 语音回路");
			json3.put("tablename", "test_loop");
			json3.put("filename", "yyhl");
			json3.put("kinds", 0);
			arr.put(json3);
			JSONObject json4=new JSONObject();
			json4.put("view", "蓝色界面 中央处理器");
			json4.put("tablename", "test_center");
			json4.put("filename", "zyclq");
			json4.put("kinds", 0);
			arr.put(json4);
			JSONObject json5=new JSONObject();
			json5.put("view", "蓝色界面 视空板");
			json5.put("tablename", "test_empty");
			json5.put("filename", "skb");
			json5.put("kinds", 0);
			arr.put(json5);
			JSONObject json6=new JSONObject();
			json6.put("view", "黄色界面 数学比较");
			json6.put("tablename", "test_compare");
			json6.put("filename", "sxbj");
			json6.put("kinds", 0);
			arr.put(json6);
			JSONObject json7=new JSONObject();
			json7.put("view", "黄色界面 数学运算");
			json7.put("tablename", "test_operation");
			json7.put("filename", "sxys");
			json7.put("kinds", 0);
			arr.put(json7);
			JSONObject json8=new JSONObject();
			json8.put("view", "黄色界面 语言测试");
			json8.put("tablename", "test_resilt");
			json8.put("filename", "yycs");
			json8.put("kinds", 2);
			arr.put(json8);
			JSONObject json9=new JSONObject();
			json9.put("view", "黄色界面 走迷津");
			json9.put("tablename", "test_maze");
			json9.put("filename", "zmj");
			json9.put("kinds", 0);
			arr.put(json9);
			JSONObject json10=new JSONObject();
			json10.put("view", "绿色界面 目标搜索");
			json10.put("tablename", "test_search");
			json10.put("filename", "mbss");
			json10.put("kinds", 0);
			arr.put(json10);
			JSONObject json11=new JSONObject();
			json11.put("view", "绿色界面 目标比较");
			json11.put("tablename", "test_targetcompare");
			json11.put("filename", "mbbj");
			json11.put("kinds", 0);
			arr.put(json11);
			JSONObject json12=new JSONObject();
			json12.put("view", "绿色界面 目标拼图");
			json12.put("tablename", "test_pintu");
			json12.put("filename", "mbpt");
			json12.put("kinds", 0);
			arr.put(json12);
			JSONObject json13=new JSONObject();
			json13.put("view", "绿色界面 人际交往1");
			json13.put("tablename", "test_resilt");
			json13.put("filename", "rjjw1");
			json13.put("kinds", 4);
			arr.put(json13);
			JSONObject json14=new JSONObject();
			json14.put("view", "绿色界面 人际交往2");
			json14.put("tablename", "test_operationb");
			json14.put("filename", "rjjw2");
			json14.put("kinds", 1);
			arr.put(json14);
			JSONObject json15=new JSONObject();
			json15.put("view", "红色界面 空间操作");
			json15.put("tablename", "test_redoperation");
			json15.put("filename", "kjcz");
			json15.put("kinds", 0);
			arr.put(json15);
			JSONObject json16=new JSONObject();
			json16.put("view", "红色界面 空间推理");
			json16.put("tablename", "test_reasoning");
			json16.put("filename", "kjtl");
			json16.put("kinds", 0);
			arr.put(json16);
			JSONObject json17=new JSONObject();
			json17.put("view", "红色界面 表象能力");
			json17.put("tablename", "test_appearance");
			json17.put("filename", "bxnl");
			json17.put("kinds", 0);
			arr.put(json17);
			JSONObject json18=new JSONObject();
			json18.put("view", "红色界面 思维转换");
			json18.put("tablename", "test_thinking");
			json18.put("filename", "swzh");
			json18.put("kinds", 0);
			arr.put(json18);
			JSONObject json19=new JSONObject();
			json19.put("view", "橙色界面 空间比例判断");
			json19.put("tablename", "test_painting");
			json19.put("filename", "kjblpd");
			arr.put(json19);
			JSONObject json20=new JSONObject();
			json20.put("view", "橙色界面 艺术想象");
			json20.put("tablename", "test_imageination");
			json20.put("filename", "ysxx");
			json20.put("kinds", 0);
			arr.put(json20);
			JSONObject json21=new JSONObject();
			json21.put("view", "橙色界面 色彩对比");
			json21.put("tablename", "test_colorcontrast");
			json21.put("filename", "scdb");
			json21.put("kinds", 0);
			arr.put(json21);
			JSONObject json22=new JSONObject();
			json22.put("view", "浅蓝色界面 音调形象");
			json22.put("tablename", "test_musicform");
			json22.put("filename", "ydxx");
			json22.put("kinds", 0);
			arr.put(json22);
			JSONObject json23=new JSONObject();
			json23.put("view", "浅蓝色界面 时间音长");
			json23.put("tablename", "test_musiclength");
			json23.put("filename", "sjyc");
			json23.put("kinds", 0);
			arr.put(json23);
			JSONObject json24=new JSONObject();
			json24.put("view", "浅蓝色界面 节奏形象");
			json24.put("tablename", "test_musicrhythm");
			json24.put("filename", "jzxx");
			json24.put("kinds", 0);
			arr.put(json24);
			JSONObject json25=new JSONObject();
			json25.put("view", "浅蓝色界面 音的记忆");
			json25.put("tablename", "test_musiccemory");
			json25.put("filename", "ydjy");
			json25.put("kinds", 0);
			arr.put(json25);
			JSONObject json26=new JSONObject();
			json26.put("view", "浅蓝色界面 音的鉴赏");
			json26.put("tablename", "test_musicappreciate");
			json26.put("filename", "ydjs");
			json26.put("kinds", 0);
			arr.put(json26);
			JSONObject json27=new JSONObject();
			json27.put("view", "紫色界面 组织管理能力");
			json27.put("tablename", "test_resilt");
			json27.put("filename", "zzglnl");
			json27.put("kinds", 1);
			arr.put(json27);
			JSONObject json28=new JSONObject();
			json28.put("view", "紫色界面 概念推理");
			json28.put("tablename", "test_induction");
			json28.put("filename", "gltl");
			json28.put("kinds", 0);
			arr.put(json28);
			JSONObject json29=new JSONObject();
			json29.put("view", "紫色界面 逻辑推理");
			json29.put("tablename", "test_logical");
			json29.put("filename", "ljtl");
			json29.put("kinds", 2);
			arr.put(json29);
			JSONObject json30=new JSONObject();
			json30.put("view", "灰色界面 职业心向能力");
			json30.put("tablename", "test_operationb");
			json30.put("filename", "zyxxnl");
			json30.put("kinds", 2);
			arr.put(json30);
			JSONObject json31=new JSONObject();
			json31.put("view", "灰色界面 人格一");
			json31.put("tablename", "test_operationb");
			json31.put("filename", "rg1");
			json31.put("kinds", 3);
			arr.put(json31);
			JSONObject json32=new JSONObject();
			json32.put("view", "灰色界面 人格二");
			json32.put("tablename", "test_personality");
			json32.put("filename", "rg2");
			json32.put("kinds", 0);
			arr.put(json32);
			JSONObject json33=new JSONObject();
			json33.put("view", "灰色界面 投射一");
			json33.put("tablename", "test_operationb");
			json33.put("filename", "ts1");
			json33.put("kinds", 4);
			arr.put(json33);
			JSONObject json34=new JSONObject();
			json34.put("view", "灰色界面 投射二");
			json34.put("tablename", "test_rgtst");
			json34.put("filename", "ts2");
			json34.put("kinds", 0);
			arr.put(json34);
			response.setContentType("test/javascript;charset=utf-8");
			response.getWriter().print(arr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
