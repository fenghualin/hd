package com.huanduguihua.wathet.question4.service;

import java.util.List;

import com.huanduguihua.system.service.DefaultService;
import com.huanduguihua.wathet.question4.bean.MusicCemory;

public interface MusicCemoryService extends DefaultService{

	public void save(MusicCemory musicCemory);
	public List<MusicCemory> list(String sql, String uid, String kinds) ;
}
