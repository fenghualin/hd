package com.huanduguihua.blue.question_3.service;

import java.util.List;

import com.huanduguihua.blue.question_3.bean.LoopTest;
import com.huanduguihua.system.service.DefaultService;

public interface LoopTestService extends DefaultService {
	public void save(LoopTest loopTest);
	public List<LoopTest> list(String sql,String uid,String kinds);
}
