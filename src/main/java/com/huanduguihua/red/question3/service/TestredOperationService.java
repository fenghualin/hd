package com.huanduguihua.red.question3.service;

import java.util.List;

import com.huanduguihua.red.question3.bean.TestredOperation;
import com.huanduguihua.system.service.DefaultService;

public interface TestredOperationService extends DefaultService{

	public void save(TestredOperation operation);
	public List<TestredOperation> list(String sql, String uid, String kinds);
}
