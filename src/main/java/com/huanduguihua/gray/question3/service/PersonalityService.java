package com.huanduguihua.gray.question3.service;

import java.util.List;

import com.huanduguihua.gray.question3.bean.Personality;
import com.huanduguihua.system.service.DefaultService;

public interface PersonalityService extends DefaultService{

	/**
	 * 保存
	 * @param personality
	 */
	public void save(Personality personality);
	public List<Personality> list(String sql, String uid, String kinds);
}
