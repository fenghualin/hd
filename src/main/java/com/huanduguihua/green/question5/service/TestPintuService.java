package com.huanduguihua.green.question5.service;

import java.util.List;

import com.huanduguihua.green.question5.bean.TestPintu;
import com.huanduguihua.system.service.DefaultService;

public interface TestPintuService extends DefaultService{

	public void save(TestPintu testPintu);
	public List<TestPintu> list(String sql, String uid, String kinds);
}
