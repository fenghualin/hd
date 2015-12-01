/**
 * com.huanduguihua.user.service
 * UserService.java
 * 
 * 2014-5-14-下午4:43:33
 *  2014成都酷信科技公司-版权所有
 * 
 */
package com.huanduguihua.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.huanduguihua.blue.question_1.bean.ReactionTest;
import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.DefaultService;
import com.huanduguihua.user.bean.Mokuai;
import com.huanduguihua.user.bean.User;
import com.huanduguihua.user.bean.search.UserSearch;

/**
 * 
 * UserService
 * 
 * kin
 * kin
 * 2014-5-14 下午4:43:33
 * 
 * @author KangJia
 * @version 1.0.0
 * 
 */
public interface UserService extends DefaultService {

	/**
	 * 用户登录验证，如果验证通过，返回登陆的用户，验证失败抛出异常
	 * @param username	用户名
	 * @param password	密码（如果不是32位，则加密为32为MD5，如果是32位，则直接验证）
	 * @return
	 * @throws ServiceException
	 */
	public User checkLogin(String username, String password) throws ServiceException;
	
	/**
	 * 更新用户对象，id为空，添加用户对象，不为空则更新
	 * @param user	需要更新的用户
	 * @return
	 * @throws ServiceException
	 */
	public User update(User user) throws ServiceException;
	
	/**
	 * 获取一个用户
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public User get(Integer id) throws ServiceException;
	
	/**
	 * 删除一个用户
	 * @param id
	 * @throws ServiceException
	 */
	public void delete(Integer id) throws ServiceException;
	/**
	 * 分页查询用户
	 */
	public UserSearch list(UserSearch search,String pagestart,String pagesize,String sort,String order) throws ServiceException;
	
	/**
	 * 验证授权码是否唯一
	 */
	public boolean checkUsername(String uname);
	/**
	 * 列出用户做题得分情况
	 */
	public List<ReactionTest> listquestionqk(String uid,String tablename,String kinds,HttpServletRequest request);
	
	public int generateReport(User uid);
	/**
	 * 查看用户表是否为空，不为空返回最后一条
	 */
	public Integer chaxunuser();
	
	/**
	 * 通过用户名查询用户对象
	 * @param username	用户名
	 * @return	如果没有找到，返回null
	 * @throws ServiceException
	 */
	public User getUserByUsername(String username) throws ServiceException;
	
	/**
	 * 设置某个用户在线状态
	 * @param username
	 * @throws ServiceException
	 */
	public void endableOnline(String username) throws ServiceException;
	/**
	 * 设置某个用户状态为离线
	 * @param username
	 * @throws ServiceException
	 */
	public void disableOnline(String username) throws ServiceException;
	
	/**
	 * 设置所有用户在线状态为离线（重启tomcat的时候使用）
	 * @throws ServiceException
	 */
	public void disableOnlineAll() throws ServiceException;
	/**
	 * 生成dat
	 */
	public String generatedat(User u,Integer step);
	/**
	 * 生成excel
	 * 
	 */
	public boolean generateexcel(User u,String tablename,Integer kinds,String filename);
	/**
	 * 判断模块对应的题目是否记录
	 * @param mokuai
	 * @return
	 */
	public boolean isRecordInDb(String url,User user);
	public boolean isRecordNotInDb(String url,User user);
}
