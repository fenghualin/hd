package com.huanduguihua.user.service;


import com.huanduguihua.system.service.DefaultService;
import com.huanduguihua.user.bean.MokuaiJinduisFinish;

public interface MokuaiJinduisFinishService extends DefaultService {

	public MokuaiJinduisFinish save(MokuaiJinduisFinish finish);
	public MokuaiJinduisFinish get(Integer id);
	public MokuaiJinduisFinish userget(Integer id);
}
