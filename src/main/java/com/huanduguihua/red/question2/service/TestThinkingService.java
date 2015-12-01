package com.huanduguihua.red.question2.service;

import java.util.List;

import com.huanduguihua.red.question2.bean.TestThinking;
import com.huanduguihua.system.service.DefaultService;

public interface TestThinkingService extends DefaultService{

	public void save(TestThinking testThinking);
	public List<TestThinking> list(String sql, String uid, String kinds) ;
}
