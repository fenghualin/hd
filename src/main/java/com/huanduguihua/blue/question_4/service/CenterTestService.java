package com.huanduguihua.blue.question_4.service;

import java.util.List;

import com.huanduguihua.blue.question_4.bean.CenterTest;
import com.huanduguihua.system.service.DefaultService;

public interface CenterTestService extends DefaultService{
	public void save(CenterTest centerTest);
	public List<CenterTest> list(String sql,String uid,String kinds);
}
