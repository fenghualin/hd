package com.huanduguihua.yellow.question1.service;

import java.util.List;

import com.huanduguihua.system.service.DefaultService;
import com.huanduguihua.yellow.question1.bean.TestCompare;

public interface TestCompareService extends DefaultService{
	public void save(TestCompare testCpmpare);
	public Integer getTableId(String table);
	public List<TestCompare> list(String sql,String uid,String kinds);
}
