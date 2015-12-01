package com.huanduguihua.user.service;

import java.util.List;

import com.huanduguihua.system.service.DefaultService;
import com.huanduguihua.user.bean.User;
import com.huanduguihua.user.bean.UserMokuai;

public interface UserMokuaiService extends DefaultService{

	public List<UserMokuai> list(User u);
	
	public void save(UserMokuai u);
}
