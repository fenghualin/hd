package com.huanduguihua.manager.service;

import java.util.List;

import com.huanduguihua.manager.bean.Jigou;
import com.huanduguihua.manager.bean.search.JigouSearch;
import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.DefaultService;

public interface JigouService extends DefaultService{
	/**
	 * 分页查询
	 * @param search
	 * @param pagestart
	 * @param pagesize
	 * @return
	 * @throws ServiceException
	 */
	public JigouSearch list(JigouSearch search,Integer pagestart,Integer pagesize)
			throws ServiceException;
	/**
	 * 保存
	 * @param j
	 * @return
	 */
	public Jigou save(Jigou j);
	/**
	 * 删除
	 * @param id
	 */
	public void delete(Integer id);
	/**
	 * 根据id返回对象
	 * @param id
	 * @return
	 */
	public Jigou get(Integer id);
	/**
	 * 修改
	 * @param jigou
	 * @return
	 */
	public Jigou update(Jigou jigou);
	/**
	 * 获取所有的机构
	 */
	public List<Jigou> getall();
}
