package com.huanduguihua.violet.question1.service;

import java.util.List;

import com.huanduguihua.system.service.DefaultService;
import com.huanduguihua.violet.question1.bean.Induction;

public interface InductionService extends DefaultService{

	public void save(Induction induction);
	public List<Induction> list(String sql, String uid, String kinds);
}
