/**
 * com.huanduguihua.system.service.impl
 * DefaultService.java
 * 
 * 2014-5-12-下午2:35:13
 *  2014成都酷信科技公司-版权所有
 * 
 */
package com.huanduguihua.system.service;

import java.util.List;
import java.util.Map;

import com.huanduguihua.system.bean.DefaultBean;
import com.huanduguihua.system.exception.service.ServiceException;

/**
 * 
 * DefaultService
 * 
 * kin
 * kin
 * 2014-5-12 下午2:35:13
 * 
 * @author KangJia
 * @version 1.0.0
 * 
 */
public interface DefaultService {

	/**
	 * 功能：
	 * 	核心·更新方法，可以对数据库执行修改，例如：update、delete、insert
	 * @param sql	需要执行的sql语句
	 * @param params	问好参数，如果没有则不填
	 * @return	返回影响的行数
	 */
	public int executeUpdate(String sql, Object...params);
	/**
	 * 功能：
	 * 	核心·查询方法，对数据库的数据进行查询，例如：select
	 * @param sql	需要执行的查询语句
	 * @param params	问号参数，如果没有则不填
	 * @return	返回查询后的结果集
	 */
	public List<Map<String, Object>> executeQuery(String sql, Object...params);
	/**
	 * 获取一个对象，传入id即可
	 * @param id
	 * @param clazz
	 * @return
	 * @throws ServiceException
	 */
	public Object get(Integer id, Class<?> clazz) throws ServiceException;
	/**
	 * 删除一个对象，需要在bean里面设置id
	 * @param bean
	 * @throws ServiceException
	 */
	public void delete(DefaultBean bean) throws ServiceException;
	/**
	 * 更新一个bean对象，返回更新后的对象
	 * @param bean
	 * @return
	 * @throws ServiceException
	 */
	public Object update(DefaultBean bean) throws ServiceException;
	/**
	 * 生成一个id
	 * @param table
	 * @return
	 */
	public Integer generateId(String table);
	/**
	 * 验证进度
	 */
	
}
