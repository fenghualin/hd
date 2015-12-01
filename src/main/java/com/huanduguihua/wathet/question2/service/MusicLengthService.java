package com.huanduguihua.wathet.question2.service;

import java.util.List;

import com.huanduguihua.system.service.DefaultService;
import com.huanduguihua.wathet.question2.bean.MusicLength;


public interface MusicLengthService extends DefaultService{

	public void save(MusicLength musicLength);
	public List<MusicLength> list(String sql, String uid, String kinds);
}
