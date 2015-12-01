/**
 * com.huanduguihua.system.util
 * UserUtils.java
 * 
 * 2014-5-14-上午11:30:15
 *  2014成都酷信科技公司-版权所有
 * 
 */
package com.huanduguihua.system.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.huanduguihua.user.bean.User;

/**
 * 
 * UserUtils
 * 
 * kin
 * kin
 * 2014-5-14 上午11:30:15
 * 
 * @author KangJia
 * @version 1.0.0
 * 
 */
public class UserUtils {
	
	private static Logger logger = Logger.getLogger(UserUtils.class);
	
	private final static String USER_SESSION_KEY = "loginUser";
	
	/**
	 * 获取当前登录的用户，如果没有获取到，说明用户没有进行登录
	 * @param request	必须的
	 * @return	返回登陆的用户，如果没有返回null
	 */
	public static User getLoginUser(HttpServletRequest request) {
		Object obj = request.getSession().getAttribute(USER_SESSION_KEY);
		return (User) (obj == null ? new User() : obj);
	}
	
	/**
	 * 设置用户的登陆信息到session中
	 * @param request	必须的
	 * @param user		必须的
	 */
	public static void setLoginUser(HttpServletRequest request, User user) {
		request.getSession().setAttribute(USER_SESSION_KEY, user);
		logger.info("用户登录状态设置，key: " + USER_SESSION_KEY +"，value: " + user);
	}
	
	/**
	 * 注销用户登录
	 * @param request
	 */
	public static void removeLoginUser(HttpServletRequest request) {
		request.getSession().removeAttribute(USER_SESSION_KEY);
		request.getSession().invalidate();
		logger.info("用户注销登录状态");
	}
}
