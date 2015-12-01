package com.huanduguihua.user.service;

import java.util.List;

import com.huanduguihua.system.service.DefaultService;
import com.huanduguihua.user.bean.User;
import com.huanduguihua.user.bean.UserGroup;

public interface UserGroupService extends DefaultService {

	/**
	 * 通过用户id查询
	 * @param u
	 * @return
	 */
	public List<UserGroup> list(User u);
	public UserGroup getUsergGroup(User u);
	public void save(UserGroup u);
	/**
	 * 通过用户id删除关联数据
	 */
	public void delete(Integer uid);
}
