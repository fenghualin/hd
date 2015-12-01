package com.huanduguihua.orange.quantion1.service;

import java.util.List;

import com.huanduguihua.orange.quantion1.bean.TestPainting;
import com.huanduguihua.system.service.DefaultService;

public interface TestPaintingService extends DefaultService{

	public void save(TestPainting testPainting);
	public List<TestPainting> list(String sql, String uid, String kinds);
}
