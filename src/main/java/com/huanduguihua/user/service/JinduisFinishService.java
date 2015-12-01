package com.huanduguihua.user.service;

import com.huanduguihua.system.service.DefaultService;
import com.huanduguihua.user.bean.JinduisFinish;

public interface JinduisFinishService extends DefaultService{

	public JinduisFinish get(Integer id);
	public JinduisFinish save(JinduisFinish jinduisFinish);
}
