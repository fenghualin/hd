package com.huanduguihua.violet.question2.service;

import java.util.List;

import com.huanduguihua.system.service.DefaultService;
import com.huanduguihua.violet.question2.bean.Logical;

public interface LogicalService extends DefaultService{

	public void save(Logical logical);
	public List<Logical> list(String sql, String uid, String kinds);
}
