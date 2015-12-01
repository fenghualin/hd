package com.huanduguihua.red.question1.service;

import java.util.List;

import com.huanduguihua.red.question1.bean.TestAppearance;
import com.huanduguihua.system.service.DefaultService;

public interface TestAppearanceService extends DefaultService{

	public void save(TestAppearance testAppearance);
	
	public List<TestAppearance> list(String sql, String uid, String kinds);
}
