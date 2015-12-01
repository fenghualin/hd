/**
 * com.huanduguihua.system.service.impl
 * DefaultServiceImpl.java
 * 
 * 2014-5-12-下午2:36:09
 *  2014成都酷信科技公司-版权所有
 * 
 */
package com.huanduguihua.system.service.impl;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.myjdbc.core.Session;
import org.myjdbc.core.SessionFactory;

import com.huanduguihua.system.bean.DefaultBean;
import com.huanduguihua.system.bean.search.Search;
import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.DefaultService;

/**
 * 
 * DefaultServiceImpl
 * 
 * kin
 * kin
 * 2014-5-12 下午2:36:09
 * 
 * @author KangJia
 * @version 1.0.0
 * 
 */
public abstract class DefaultServiceImpl implements DefaultService {
private static Logger logger = Logger.getLogger(DefaultServiceImpl.class);
	
	//内容查询
	//protected String query = null;
	
	//条数查询
	private String count = "select count(id) count ";
	
	//条件语句
	//protected String where = null;
	
	//排序
	//protected String order = null;
	
	protected List<Object> params = new ArrayList<Object>(0);
	
	public List<Map<String, Object>> executeQuery(String sql, String...params) {
		Session session = SessionFactory.getSessionFactory().buildShortSession();
		List<Map<String, Object>> datas = session.executeQuery(sql, params);
		if (datas == null) datas = new ArrayList<Map<String,Object>>();
		session.close();
		return datas;
		
	}
	
	public List<Map<String, Object>> executeQuery(String sql, Object...params) {
		Session session = SessionFactory.getSessionFactory().buildShortSession();
		String[] ps = null;
		try {
			if (params != null) {
				ps = new String[params.length];
				for (int i=0; i<params.length; i++) {
					ps[i] = params[i] == null ? null : params[i].toString();
				}
			}
			List<Map<String, Object>> datas = session.executeQuery(sql, ps);
			if (datas == null) datas = new ArrayList<Map<String,Object>>();
			session.close();
			return datas;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
	public List<Map<String, Object>> executeQuery(String sql, List<Object> params) {
		Session session = SessionFactory.getSessionFactory().buildShortSession();
		String[] ps = null;
		try {
			if (params != null) {
				ps = new String[params.size()];
				for (int i=0; i<params.size(); i++) {
					ps[i] = params.get(i) == null ? null : params.get(i).toString();
				}
			}
			List<Map<String, Object>> datas = session.executeQuery(sql, ps);
			if (datas == null) datas = new ArrayList<Map<String,Object>>();
			session.close();
			return datas;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
	
	public int executeUpdate(String sql, String...params) {
		Session session = SessionFactory.getSessionFactory().buildShortSession();
		int s = -1;
		try {
			s = session.executeUpdate(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.close();
		return s;
	}
	public int executeUpdate(String sql, Object...params) {
		Session session = SessionFactory.getSessionFactory().buildShortSession();
		String[] ps = null;
		int s = -1;
		try {
			if (params != null) {
				ps = new String[params.length];
				for (int i=0; i<params.length; i++) {
					ps[i] = params[i] == null ? null : params[i].toString();
				}
			}
			s = session.executeUpdate(sql, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.close();
		return s;
	}
	
	//生成一个id
	public Integer generateId(String table) {
		String sql = "select max(id) maxId from " + table;
		List<Map<String, Object>> datas = this.executeQuery(sql);
		Integer maxId = null;
		if (datas.size() > 0) {
			maxId = (Integer) datas.get(0).get("maxId");
		}
		return maxId == null ? 1 : maxId.intValue() + 1;
	}
	
	/**
	 * 生成某个表的id，并且insert一条数据进去，前提是其他字段可以为空
	 * @param table
	 * @return
	 */
	public Integer generateAndCreateId(String table, Integer accountId) {
		Integer id = this.generateId(table);
		this.executeUpdate("insert into " + table +"(id, account_id) values(?,?)", id, accountId);
		return id;
	}
	
	public Integer generateNumber(String table, String key) {
		String sql = "select max("+key+") maxId from " + table;
		Integer maxId = (Integer) this.executeQuery(sql).get(0).get("maxId");
		return maxId == null ? 1 : maxId.intValue() + 1;
	}
	
	public Object getObjectValue(List<Map<String, Object>> datas, String key) {
		if (datas != null && datas.size() > 0) {
			return datas.get(0).get(key);
		} else {
			return null;
		}
	}
	
	/***检查某个表的某个值是否存在*/
	public Boolean checkIsExist(String table, String key, String val) {
		String sql = "select " + key + " from " + table +" where " + key + " = ?";
		String[] params = {val};
		return this.executeQuery(sql, params).size() > 0 ? true : false;
	}
	
	abstract protected List<?> pack(List<Map<String, Object>> datas);
	
	protected Search queryBySearch(Search search) {
		String query = search.getQuery();
		String where = search.getWhere();
		String order = search.getOrder();
		if (search == null) {
			logger.info("search不能为空");
			return null;
		}
		if (query == null || where == null || order == null) {
			logger.info("参数不够，query="+query+",where="+where+",order="+order);
		}
		String page = " ";
		if (search.getPageSize()!=-1) {
			page = " limit " + (search.getPage()-1)*search.getPageSize() +","+search.getPageSize();
		}
		//获取总条数
		logger.info("query: " + count + where);
		Long dataCount = (Long) this.getObjectValue(this.executeQuery(count + where, params), "count");
		search.setCount(dataCount == null ? 0 : dataCount);
		
		logger.info("query: " + query + where + order + page);
		System.out.println(query + where + order + page);
		List<Map<String, Object>> datas = this.executeQuery(query + where + order + page, params);
		
		//上面这部分不用改动!------------->
		
		List<?> objects = pack(datas);
		search.setDatas(objects);
		
		//重置
//		query = null;
//		where = null;	//条件语句
//		order = null;	//排序
		
		params = new ArrayList<Object>(0);
		return search;
	}
	
	
	//数据集合转换为对象集合
	public List<?> pack(List<Map<String, Object>> datas, Class<?> clazz) {
		String name = null;
		Object dbData = null;
		try {
			//获取clazz的所有方法，如果是set开头的方法，则表名是设置数据的方法
			Method[] methods = clazz.getMethods();
			List<Object> objs = new ArrayList<Object>();
			
			for (Map<String, Object> data : datas) {
				Object obj = clazz.newInstance();
				for (Method method : methods) {
					if (method.getName().indexOf("set") == 0) {
						name = method.getName();
						
						//截取set后面的名字，根据约定的规则获取数据库中的字段名字，然后从数据集中取出来set到bean对象中
						String field = method.getName().substring("set".length());
						String mapping = getMapping(field);
						dbData = data.get(mapping);
//						System.out.println("method: " + method.getName()+",data: " + data.get(mapping));
						Class<?>[] params = method.getParameterTypes();
						if (Boolean.class.getName().equals(params[0].getName()) ) {
							Integer boolInt = (Integer)data.get(mapping);
							method.invoke(obj, (boolInt == null || boolInt == 0) ? false : true);
						} else if (Long.class.getName().equals(params[0].getName())) {
							Long intLong = data.get(mapping) == null ? null : Long.parseLong(data.get(mapping).toString());
							method.invoke(obj, intLong);
						} else {
							method.invoke(obj, data.get(mapping));
						}
					}
				}
				objs.add(obj);
			}
			//System.out.println("objs: " + objs);
			return objs;
		} catch (Exception e) {
			System.out.println("method.name: " + name + ", method.data: " + dbData);
			e.printStackTrace();
			return null;
		}
	}

	//约定的规则
	//WxTest会被转换为wx_test，大写字母会被转换为小写字母并在前面带上下划线
	//例如一个用户表名字为db_user，里面的字段有username、password、register_time
	//   则bean对象的名字应为DbUser,属性有username、password、registerTime;
	public static String getMapping(String s) {
		try {
			String ss = s.replaceAll("[A-Z]", "_$0");
			ss = ss.substring(1);
			return ss.toLowerCase();
		} catch (Exception e) {
			e.printStackTrace();
			return s;
		}
	}
	
	//封装更新
	public Object update(DefaultBean bean) throws ServiceException{
		try {
			Class<? extends DefaultBean> clazz = bean.getClass();
			if (bean.getId() == null) {
				//添加
				bean.setId(this.generateId(bean.__getMyjdbcTableName()));
				
				String sql = "insert into " + bean.__getMyjdbcTableName() + " (";
				
				//获取clazz的所有方法，如果是set开头的方法，则表名是设置数据的方法
				Method[] methods = clazz.getMethods();
				String column = "";
				List<String> nameList = new ArrayList<String>();
				for (Method method : methods) {
					if (method.getName().indexOf("get") == 0) {
						String returnName = method.getReturnType().getName();
						if ( !allowReturnName(returnName) ) {
							System.out.println("不支持的数据类型：" + returnName);
							break;
						}
						//returnType
						//截取set后面的名字，根据约定的规则获取数据库中的字段名字，然后从数据集中取出来set到bean对象中
						String field = method.getName().substring("set".length());
						String mapping = getMapping(field);
						sql += "`"+mapping +"`,";
						column += "?,";
						nameList.add(method.getName());
						//method.invoke(obj, data.get(mapping));
					}
				}
				sql = sql.endsWith(",") ? sql.substring(0, sql.length()-1) : sql;
				column = column.endsWith(",") ? column.substring(0, column.length()-1) : column;
				sql += ") values("+column+")";
				List<Object> params = new ArrayList<Object>();
				for (String name : nameList) {
					Object param = clazz.getMethod(name).invoke(bean);
					if (param != null && Boolean.class.getName().equals(param.getClass().getName())) {
						Boolean param_bool = (Boolean) param;
						params.add(param_bool ? 1 : 0);
					} else {
						params.add(param);
					}
					System.out.println("method: " + name + ", param: " + param);
				}
				System.out.println("sql: " + sql);
				System.out.println("params: " + params);
				this.executeUpdate(sql, params.toArray());
			} else {
				//更新
				String sql = "update " + bean.__getMyjdbcTableName() + " set ";
				
				//获取clazz的所有方法，如果是set开头的方法，则表名是设置数据的方法
				Method[] methods = clazz.getMethods();
				List<String> nameList = new ArrayList<String>();
				for (Method method : methods) {
					if (method.getName().indexOf("get") == 0) {
						String returnName = method.getReturnType().getName();
						if ( !allowReturnName(returnName) ) {
							System.out.println("不支持的数据类型：" + returnName);
							break;
						}
						//returnType
						//截取set后面的名字，根据约定的规则获取数据库中的字段名字，然后从数据集中取出来set到bean对象中
						String field = method.getName().substring("set".length());
						String mapping = getMapping(field);
						sql += "`"+mapping +"`=?,";
						nameList.add(method.getName());
					}
				}
				sql = sql.endsWith(",") ? sql.substring(0, sql.length()-1) : sql;
				//column = column.endsWith(",") ? column.substring(0, column.length()-1) : column;
				sql += " where id=?";
				List<Object> params = new ArrayList<Object>();
				for (String name : nameList) {
					Object param = clazz.getMethod(name).invoke(bean);
					if (param != null && Boolean.class.getName().equals(param.getClass().getName())) {
						Boolean param_bool = (Boolean) param;
						params.add(param_bool ? 1 : 0);
					} else {
						params.add(param);
					}
				}
				params.add(bean.getId());
				System.out.println("bean: " + bean);
				System.out.println("sql: " + sql);
				System.out.println("params: " + params);
				this.executeUpdate(sql, params.toArray());
			}
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	private static List<String> allowReturnNameList = null;
	private static boolean allowReturnName(String returnName) {
		if (allowReturnNameList == null) {
			allowReturnNameList = new ArrayList<String>();
			allowReturnNameList.add(Integer.class.getName());
			allowReturnNameList.add(Double.class.getName());
			allowReturnNameList.add(String.class.getName());
			allowReturnNameList.add(Boolean.class.getName());
			allowReturnNameList.add(Timestamp.class.getName());
			allowReturnNameList.add("int");
			allowReturnNameList.add(Long.class.getName());
		}
		return allowReturnNameList.contains(returnName);
	}
	
	/**
	 * 删除一个Bean数据
	 * @param bean	必须要传入id，否则删除失败
	 * @throws ServiceException
	 */
	public void delete(DefaultBean bean) throws ServiceException {
		try {
			this.executeUpdate("delete from " + bean.__getMyjdbcTableName() +" where id=?", bean.getId());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}
	
	/**
	 * 获取一个对象
	 * @param id
	 * @param clazz
	 * @return
	 * @throws ServiceException
	 */
	public Object get(Integer id, Class<?> clazz) throws ServiceException {
		try {
			DefaultBean bean = (DefaultBean) clazz.newInstance();
			List<Map<String, Object>> datas = this.executeQuery("select * from " + bean.__getMyjdbcTableName() +" where id=?", id);
			if (datas.size() == 0) {
				bean.setId(id);
				return bean;
			} else {
				return this.pack(datas, clazz).get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}
}
