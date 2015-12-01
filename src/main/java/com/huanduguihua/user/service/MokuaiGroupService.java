package com.huanduguihua.user.service;

import java.util.List;

import com.huanduguihua.system.service.DefaultService;
import com.huanduguihua.user.bean.MokuaiGroup;

public interface MokuaiGroupService extends DefaultService {

	public List<MokuaiGroup> list(Integer id);
	
	public void save(MokuaiGroup m);
	/**
	 * 删除groupid的数据
	 */
	public void deleteg(Integer gid);
}
