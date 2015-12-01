package com.huanduguihua.blue.question_2.service;

import java.util.List;

import com.huanduguihua.blue.question_2.bean.MatchingTest;
import com.huanduguihua.system.service.DefaultService;

public interface MatchingTestService extends DefaultService{
	public void save(MatchingTest matching);
	public List<MatchingTest> list(String sql,String uid,String kinds);
}
