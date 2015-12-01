package com.huanduguihua.green.question3.service;

import java.util.List;

import com.huanduguihua.green.question3.bean.TestOperationb;
import com.huanduguihua.system.service.DefaultService;

public interface TestOperationbService extends DefaultService{

	public void save(TestOperationb testOperationb);
	
	public List<TestOperationb> list(String sql, String uid, String kinds);
}
