package com.huanduguihua.yellow.question3.service;

import java.util.List;

import com.huanduguihua.system.service.DefaultService;
import com.huanduguihua.yellow.question3.bean.TestResult;

public interface TestResultService extends DefaultService{
	public void save(TestResult testResult);
	public Integer getTableId(String table);
	public List<TestResult> list(String sql, String uid, String kinds);
}
