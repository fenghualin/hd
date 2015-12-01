package com.huanduguihua.yellow.question2.service;

import java.util.List;

import com.huanduguihua.system.service.DefaultService;
import com.huanduguihua.yellow.question2.bean.TestOperation;

public interface TestOperationService  extends DefaultService{
	
	public void save(TestOperation testOperation);
	public Integer getTableId(String table);
	public List<TestOperation> list(String sql,String uid,String kinds);
}
