//======================================================================
//
//        Copyright (C) 2013-2014 成都酷信科技有限公司
//        All rights reserved
//
//        文件名 ：com.huanduguihua.system.controller.SessionListenerLife.java
//
//        创建时间：2014-6-13-上午9:58:55
//		      作者：康佳
//        http://www.cdkuxin.com
//
//======================================================================
package com.huanduguihua.system.controller;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.user.bean.User;
import com.huanduguihua.user.service.UserService;
import com.huanduguihua.user.service.impl.UserServiceImpl;

/**
 * 名称：
 * 功能：
 * 
 * @author 康佳
 * @version 1.0.0
 * 
 */
public class SessionListenerLife implements HttpSessionListener,HttpSessionAttributeListener {

	UserService userService = null;
	
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("sessionCreated");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		if (userService == null) userService = new UserServiceImpl();
		System.out.println("sessionDestroyed");
		User user = (User) se.getSession().getAttribute("user");
		if (user != null) {
			try {
				System.out.println("用户下线：" + user.getUsername());
				userService.disableOnline(user.getUsername());
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
	}

}
