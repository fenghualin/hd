/**
 * com.huanduguihua.system.controller
 * WebContext.java
 * 
 * 2014-5-12-下午2:44:14
 *  2014成都酷信科技公司-版权所有
 * 
 */
package com.huanduguihua.system.controller;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.myjdbc.core.SessionFactory;

import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.user.service.UserService;
import com.huanduguihua.user.service.impl.UserServiceImpl;

/**
 * 
 * WebContext
 * 
 * kin
 * kin
 * 2014-5-12 下午2:44:14
 * 
 * @author KangJia
 * @version 1.0.0
 * 
 */
public class WebContext extends HttpServlet {

	UserService userService = new UserServiceImpl();
	@Override
	public void init() throws ServletException {
		//
		System.out.println("初始化系统变量");
		SessionFactory.getSessionFactory();
		//SystemConfig.init();
		System.out.println("所有用户离线模式");
		try {
			userService.disableOnlineAll();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		super.init();
	}
	
	@Override
	public void destroy() {
		//
		SessionFactory.getSessionFactory().closeSessionFacotory();
		//SessionManager.get().destroy();
		
		super.destroy();
	}
}
