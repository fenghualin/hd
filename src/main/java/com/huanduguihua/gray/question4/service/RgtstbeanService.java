package com.huanduguihua.gray.question4.service;

import java.util.List;

import com.huanduguihua.gray.question4.bean.Rgtstbean;
import com.huanduguihua.system.service.DefaultService;

public interface RgtstbeanService extends DefaultService{

	/**
	 * 保存
	 */
	public void save(Rgtstbean rgtstbean);
	
	public List<Rgtstbean> list(String sql, String uid, String kinds);
}
