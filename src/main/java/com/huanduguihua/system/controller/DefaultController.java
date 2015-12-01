package com.huanduguihua.system.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.huanduguihua.manager.bean.QuestionUrl;
import com.huanduguihua.manager.service.QuestionUrlService;
import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.user.bean.Group;
import com.huanduguihua.user.bean.JinduisFinish;
import com.huanduguihua.user.bean.Mokuai;
import com.huanduguihua.user.bean.MokuaiGroup;
import com.huanduguihua.user.bean.MokuaiJinduisFinish;
import com.huanduguihua.user.bean.User;
import com.huanduguihua.user.bean.UserGroup;
import com.huanduguihua.user.service.GroupService;
import com.huanduguihua.user.service.JinduisFinishService;
import com.huanduguihua.user.service.MokuaiGroupService;
import com.huanduguihua.user.service.MokuaiJinduisFinishService;
import com.huanduguihua.user.service.MokuaiService;
import com.huanduguihua.user.service.UserGroupService;
import com.huanduguihua.user.service.UserMokuaiService;
import com.huanduguihua.user.service.UserService;

@Component
public class DefaultController {
	@Autowired
	QuestionUrlService questionUrlService;
	@Autowired
	UserService userService;
	@Autowired
	UserMokuaiService userMokuaiService;
	@Autowired
	MokuaiService mokuaiService;
	@Autowired
	JinduisFinishService jinduisFinishService;
	@Autowired UserGroupService userGroupService;
	@Autowired GroupService groupService;
	@Autowired MokuaiGroupService mokuaiGroupService;
	@Autowired MokuaiJinduisFinishService mokuaiJinduisFinishService;
	
	public void out(HttpServletRequest request,HttpServletResponse response,String context){
		try {
			response.getWriter().print(context);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void outjson(HttpServletRequest request,HttpServletResponse response,Object j){
		try {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(j);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean checkTimu(HttpServletRequest request, String url) {
		try {
			User u = (User) request.getSession().getAttribute("user");
			//获取用户总共需要回答哪些模块的URL
			User user = userService.get(u.getId());
			//查询出user和group关联表数据
			List<UserGroup> l=userGroupService.list(user);
			ArrayList<Group> al=new ArrayList<Group>();
			List<String> xiaotiurls = new ArrayList<String>();
			//List<String> loadflw=new ArrayList<String>();
			if(l!=null){
				//查询用户有那些权限
				Group group = groupService.get(l.get(0).getGroupId());
//				System.out.println("name:"+group.getName()+" groupid:"+group.getId());
					al.add(group);
				List<MokuaiGroup> listm = mokuaiGroupService.list(al.get(0).getId());
				for(MokuaiGroup mk:listm){
					Mokuai mkuai = mokuaiService.get(mk.getMokuaiId());
					xiaotiurls.add(mkuai.getMokuaiUrl());
					//loadflw.add(mkuai.getLoadflw());
//					List<Mokuai> listmokuai = mokuaiService.getzilist(mkuai.getId());
//					for(Mokuai mk2:listmokuai){
//						xiaotiurls.add(mk2.getMokuaiUrl());
//					}
				}
			if(user.getZuotijindu()==null || user.getZuotijindu()==0){
				user.setZuotijindu(1);
			}
			//如果当前的模块的题目已经做完了，那么进度就需要+1，这里主要为网络问题做完题目后没有点击完成更新进度补充更正
			if(userService.isRecordInDb(xiaotiurls.get(user.getZuotijindu()-1), user)){
				user.setZuotijindu(user.getZuotijindu()+1);
				user.setMokuaijdId(user.getMokuaijdId()+1);
				user.setXiaotijd(0);
				User us = userService.update(user);
				request.getSession().setAttribute("user", us);
				return false;
			}
			if(xiaotiurls.get(user.getZuotijindu()-1).equals(url)){
				return true;
			}
			else return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	public boolean checkMokuai(HttpServletRequest request, String url) {
		try {
			User u = (User) request.getSession().getAttribute("user");
			//获取用户总共需要回答哪些模块的URL
			User user = userService.get(u.getId());
			//查询出user和group关联表数据
			List<UserGroup> l=userGroupService.list(user);
			ArrayList<Group> al=new ArrayList<Group>();
			List<Mokuai> mokuaiurls = new ArrayList<Mokuai>();
			if(l!=null){
				//查询用户有那些权限
				Group group = groupService.get(l.get(0).getGroupId());
//				System.out.println("name:"+group.getName()+" groupid:"+group.getId());
					al.add(group);
				List<MokuaiGroup> listm = mokuaiGroupService.list(al.get(0).getId());
				for(MokuaiGroup mk:listm){
					Mokuai mkuai = mokuaiService.get(mk.getMokuaiId());
//					if(!mokuaiurls.contains(mokuaiService.getFu(mkuai.getId()).getMokuaiUrl())){
//						mokuaiurls.add(mokuaiService.getFu(mkuai.getId()).getMokuaiUrl());
//					}
					mokuaiurls.add(mkuai);
				}
				if(user.getMokuaijdId()==null || user.getMokuaijdId()==0){
					user.setMokuaijdId(1);
				}
				Mokuai mokuai = mokuaiService.getFu(mokuaiurls.get(user.getZuotijindu()-1).getId());
				if(mokuai.getMokuaiUrl().equals(url)){
					if(mokuaiurls.get(user.getZuotijindu()-1).getOrderu()!=1){
						request.setAttribute("loadflw",mokuaiurls.get(user.getZuotijindu()-1).getLoadflw());
					}
					return true;
				}
				else{
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean pagegopd(HttpServletRequest request,HttpServletResponse response){
		return false;
	}
	public String pagego(Model model,HttpServletRequest request,HttpServletResponse response){
		User u = (User)request.getSession().getAttribute("user");
		try {
			if(u!=null){
					User user = userService.get(u.getId());
					//List<UserMokuai> l = userMokuaiService.list(user);
					//查询出user和group关联表数据
					List<UserGroup> l=userGroupService.list(user);
					Mokuai m = mokuaiService.get(user.getZuotijindu());
					QuestionUrl qu=questionUrlService.getQeurl(m.getMokuaiUrl());
					ArrayList<Group> al=new ArrayList<Group>();
					ArrayList<MokuaiGroup> am=new ArrayList<MokuaiGroup>();
					ArrayList<Mokuai> lmokuai=new ArrayList<Mokuai>();
					if(l!=null){
						//查询用户有那些权限
						Group group = groupService.get(l.get(0).getGroupId());
//						System.out.println("name:"+group.getName()+" groupid:"+group.getId());
							al.add(group);
						//查询group和模块的关联数据
						List<MokuaiGroup> listm = mokuaiGroupService.list(al.get(0).getId());
						for(int y=0;y<listm.size();y++){
							MokuaiGroup mokuaiGroup=listm.get(y);
//							System.out.println(mokuaiGroup.getGroupId());
							am.add(mokuaiGroup);
						}
						for(int i =0;i<am.size();i++){
							//查询出用户拥有模块
							MokuaiGroup mokuaiGroup=am.get(i);
							Mokuai mokuai = mokuaiService.get(mokuaiGroup.getMokuaiId());
//							System.out.println(mokuai.getMokuaiUrl());
							lmokuai.add(mokuai);
						}
						if("0".equals(user.getZuotijindu())){
//							System.out.println("大小："+lmokuai.size());
								if(lmokuai.size()>0){
									Mokuai mokuai = lmokuai.get(0);
//									System.out.println(mokuai.getMokuaiUrl());
									user.setZuotijindu(1);
									userService.update(user);
									return mokuai.getMokuaiUrl();
								}
								else {
									request.setAttribute("tishimsg", "你没有权限答题。");
									return "redirect:/";
								}
							}
						}
					JinduisFinish jinduisFinish = jinduisFinishService.get(user.getId());
					MokuaiJinduisFinish finish=mokuaiJinduisFinishService.userget(user.getId());
					List<Mokuai> lm = new ArrayList<Mokuai>();
					for(int i = 0;i<lmokuai.size();i++){
						Mokuai mokuai =lmokuai.get(i);
						lm.add(mokuai);
					}
					if(lm.size()>0){
						for(int y = 0 ; y < lm.size();y++){
							Mokuai mokuai2=lm.get(y);
							List<Mokuai> mokuai4 = mokuaiService.getzilist(mokuai2.getId());
							String ganglogin = (String) request.getSession().getAttribute("ganglogin");
//							System.out.println(ganglogin);
							if(!StringUtils.isEmpty(ganglogin) && "ok".equals(ganglogin)){
								request.getSession().removeAttribute("ganglogin");
								for(Mokuai mokuai5:mokuai4){
									if(qu.getQuestionurl().equals(mokuai5.getMokuaiUrl()) && jinduisFinish.getIsFinish()==1){
										//该小题已做完
										List<Mokuai> mokuai3 = mokuaiService.getzi(mokuai2.getId(),mokuai5.getOrderu()+1);
										if(mokuai3.size()==0){
											Mokuai mok =  lm.get(y+1);
											JinduisFinish jinduisFinish2 = new JinduisFinish();
											jinduisFinish2.setIsFinish(0);
											jinduisFinish2.setJinduId(mokuai3.get(0).getId());
											jinduisFinish2.setUserId(user.getId());
											JinduisFinish j  = jinduisFinishService.save(jinduisFinish2);
											MokuaiJinduisFinish jinduisFinish3 = new MokuaiJinduisFinish();
											jinduisFinish3.setIsFinish(0);
											jinduisFinish3.setUserId(u.getId());
											jinduisFinish3.setJinduId(mok.getFid());
											mokuaiJinduisFinishService.save(jinduisFinish3);
											MokuaiJinduisFinish mf = mokuaiJinduisFinishService.save(jinduisFinish3);
											user.setJdfId(j.getId());
											user.setMokuaijdId(mf.getId());
//											System.out.println("该模块做完，去下一个模块");
											userService.update(user);
											request.getSession().setAttribute("user", user);
											return mok.getMokuaiUrl();
										}
										else{
//											System.out.println("已经做完,去下一道");
											return mokuai3.get(0).getMokuaiUrl();
										}
									}
									else if(qu.getQuestionurl().equals(mokuai5.getMokuaiUrl()) && jinduisFinish.getIsFinish()==0){
										//该小题未做完
										if(u.getIswancheng()==0){
											user.setIswancheng(1);
											userService.update(user);
											request.getSession().setAttribute("user", user);
											return mokuai2.getMokuaiUrl();
										}
										else{
											List<Mokuai> mokuai3 = mokuaiService.getzi(mokuai2.getId(),mokuai5.getOrderu());
//											System.out.println("未做完");
											return mokuai3.get(0).getMokuaiUrl();
										}
									}
									else{
//										System.out.println("请按顺序做题，做完后的题不能重做！");
										QuestionUrl q = questionUrlService.getQeurl(qu.getQuestionurl());
										return q.getVal();
									}
								}
							}
							else{
								if(finish.getIsFinish()==1){
									if(mokuai2.getId()==finish.getJinduId()){
										Mokuai mok =  lm.get(y+1);
										MokuaiJinduisFinish jinduisFinish2 = new MokuaiJinduisFinish();
										jinduisFinish2.setIsFinish(0);
										jinduisFinish2.setUserId(u.getId());
										jinduisFinish2.setJinduId(mok.getFid());
										mokuaiJinduisFinishService.save(jinduisFinish2);
										return mok.getMokuaiUrl();
									}
								}
								else{
									Mokuai mk = mokuaiService.get(finish.getId());
									for(Mokuai mokuai5:mokuai4){
										if(qu.getQuestionurl().equals(mokuai5.getMokuaiUrl())){
											List<Mokuai> mokuai3 = mokuaiService.getzi(mokuai2.getId(),mokuai5.getOrderu()+1);
											JinduisFinish jinduisFinish2 = new JinduisFinish();
											jinduisFinish2.setIsFinish(0);
											jinduisFinish2.setJinduId(mokuai3.get(0).getId());
											jinduisFinish2.setUserId(user.getId());
											if(mokuai3.size()==0){
//												System.out.println("该模块做完，去下一个模块");
												Mokuai mok =  lm.get(y+1);
												return mok.getMokuaiUrl();
											}
											else{
//												System.out.println("已经做完,去下一道");
												return mokuai2.getMokuaiUrl();
											}
										}
										else{
//											System.out.println("请按顺序做题，做完后的题不能重做！");
											QuestionUrl q = questionUrlService.getQeurl(qu.getQuestionurl());
											return q.getVal();
										}
									}
									return mk.getMokuaiUrl();
								}
							}
						}
					}
				}
				else {
					return "redirect:/";
				}
		}catch (Exception e) {
				e.printStackTrace();
			}
		return "redirect:/";
			
	}
	
	protected User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute("user");
	}
	
	/**
	 * 返回前台页面alert(msg);提示，并且跳转到历史记录的上一页
	 * @param response	传入即可
	 * @param msg		指定提示的消息，不传入参数，则默认提示：请按照顺序答题
	 */
	protected void historyBack(HttpServletResponse response,HttpServletRequest request) {
		try {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().println("<script type='text/javascript'>window.location.href='"+request.getContextPath()+"/user/mokuai';</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 返回前台页面alert("请按照顺序答题");提示，并且跳转到历史记录的上一页
	 * @param response	传入即可
	 */
//	protected void historyBack(HttpServletResponse response) {
//		this.historyBack(response, "请按照顺序答题");
//	}
	
	public String gettishiMSG(HttpServletRequest request){
		User u = (User) request.getSession().getAttribute("user");
		//获取用户总共需要回答哪些模块的URL
		try {
			User user = userService.get(u.getId());
			//查询出user和group关联表数据
			List<UserGroup> l=userGroupService.list(user);
			ArrayList<Group> al=new ArrayList<Group>();
			List<Mokuai> mokuaiurls = new ArrayList<Mokuai>();
			if(l!=null){
				//查询用户有那些权限
				Group group = groupService.get(l.get(0).getGroupId());
//				System.out.println("name:"+group.getName()+" groupid:"+group.getId());
					al.add(group);
				List<MokuaiGroup> listm = mokuaiGroupService.list(al.get(0).getId());
				for(MokuaiGroup mk:listm){
					Mokuai mkuai = mokuaiService.get(mk.getMokuaiId());
//					if(!mokuaiurls.contains(mokuaiService.getFu(mkuai.getId()).getMokuaiUrl())){
//						mokuaiurls.add(mokuaiService.getFu(mkuai.getId()).getMokuaiUrl());
//					}
					mokuaiurls.add(mkuai);
				}
				if(user.getMokuaijdId()==null || user.getMokuaijdId()==0){
					user.setMokuaijdId(1);
				}
				return mokuaiurls.get(user.getZuotijindu()-1).getTimucont();
			}
				
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "";
	}
}
