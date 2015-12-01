package com.huanduguihua.green.question4.service;

import java.util.List;

import com.huanduguihua.green.question4.bean.TestTargetcompare;
import com.huanduguihua.system.service.DefaultService;

public interface TestTargetcompareService extends DefaultService {
	public void save(TestTargetcompare testTargetcompare);

	public List<TestTargetcompare> list(String sql, String uid, String kinds);
	
	public void delete(Integer uid);
}
