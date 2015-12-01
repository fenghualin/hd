package com.huanduguihua.wathet.question1.service;

import java.util.List;

import com.huanduguihua.system.service.DefaultService;
import com.huanduguihua.wathet.question1.bean.MusicForm;

public interface MusicFormService extends DefaultService{

	public void save(MusicForm musicForm);
	public List<MusicForm> list(String sql, String uid, String kinds);
}
