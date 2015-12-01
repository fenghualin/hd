package com.huanduguihua.red.question4.service;

import java.util.List;

import com.huanduguihua.red.question4.bean.TestReasoning;
import com.huanduguihua.system.service.DefaultService;

public interface TestReasoningService extends DefaultService{

	public void save(TestReasoning testReasoning);
	public List<TestReasoning> list(String sql, String uid, String kinds) ;
}
