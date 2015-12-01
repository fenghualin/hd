package com.huanduguihua.blue.question_5.service;

import java.util.List;

import com.huanduguihua.blue.question_5.bean.EmptyTest;
import com.huanduguihua.system.service.DefaultService;

public interface EmptyTestService extends DefaultService {
	public void save(EmptyTest emptyTest);
	public List<EmptyTest> list(String sql,String uid,String kinds);
}
