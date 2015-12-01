package com.huanduguihua.user.service;

import java.util.List;

import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.DefaultService;
import com.huanduguihua.user.bean.Group;
import com.huanduguihua.user.bean.search.GroupSearch;

public interface GroupService extends DefaultService {
	
	/**
	 * 根据id返回对象
	 * @param id
	 * @return
	 */
	public Group get(Integer id);
	/**
	 * 分页查询
	 * @param search
	 * @param pagestart
	 * @param pagesize
	 * @return
	 * @throws ServiceException
	 */
	public GroupSearch list(GroupSearch search,String pagestart,String pagesize) throws ServiceException;
	/**
	 * 保存对象
	 * @param g
	 * @throws ServiceException
	 */
	public void save(Group g)throws ServiceException;
	/**
	 * 获取所有的权限
	 * @return
	 */
	public List<Group> getlist();
	/**
	 * 删除
	 */
	public void delete(Integer id);
	/**
	 * 修改
	 */
	public void update(Group g);
}
