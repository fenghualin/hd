package com.huanduguihua.green.question1.service;

import java.util.List;

import com.huanduguihua.green.question1.bean.TestSearch;
import com.huanduguihua.system.service.DefaultService;

public interface TestSearchService extends DefaultService{

	public void save(TestSearch testSearch);
	public List<TestSearch> list(String sql, String uid, String kinds);
}
