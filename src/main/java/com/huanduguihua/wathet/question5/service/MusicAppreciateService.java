package com.huanduguihua.wathet.question5.service;

import java.util.List;

import com.huanduguihua.system.service.DefaultService;
import com.huanduguihua.wathet.question5.bean.MusicAppreciate;

public interface MusicAppreciateService extends DefaultService{

	public void save(MusicAppreciate musicAppreciate);
	public List<MusicAppreciate> list(String sql, String uid, String kinds);
}
