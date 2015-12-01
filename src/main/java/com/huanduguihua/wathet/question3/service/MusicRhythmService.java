package com.huanduguihua.wathet.question3.service;

import java.util.List;

import com.huanduguihua.system.service.DefaultService;
import com.huanduguihua.wathet.question3.bean.MusicRhythm;

public interface MusicRhythmService extends DefaultService{
	public void save(MusicRhythm musicRhythm);
	public List<MusicRhythm> list(String sql, String uid, String kinds);

}
