package com.huanduguihua.blue.question_1.service;

import java.util.List;

import com.huanduguihua.blue.question_1.bean.ReactionTest;
import com.huanduguihua.system.service.DefaultService;

public interface ReactionTestService extends DefaultService{
	public void save(ReactionTest reaction);
	public List<ReactionTest> list(String sql,String uid,String kinds);
}
