package com.huanduguihua.user.service;

import java.util.List;

import com.huanduguihua.system.service.DefaultService;
import com.huanduguihua.user.bean.Mokuai;
import com.huanduguihua.user.bean.User;

public interface MokuaiService extends DefaultService{

	/**
	 * 通过id查询
	 * @param mid
	 * @return
	 */
	public List<Mokuai> list(Integer mid);
	/**
	 * 通过id返回一个对象
	 * @param mid
	 * @return
	 */
	public Mokuai get(Integer id);
	/**
	 * 通过父id返回子类集合
	 * @param mid
	 * @return
	 */
	public List<Mokuai> zilist(Integer fid);
	/**
	 * 通过父id和order返回一个子类对象
	 * @param id
	 * @param order
	 * @return
	 */
	public List<Mokuai> getzi(Integer id,Integer order);
	/**
	 * 通过url返回一个对象
	 * @param midp
	 * @return
	 */
	public Mokuai getmokuai(String sql);
	public List<Mokuai> getzilist(Integer id);
	/**
	 * 通过子id返回父对象
	 */
	public Mokuai getFu(Integer zid);
	
}
