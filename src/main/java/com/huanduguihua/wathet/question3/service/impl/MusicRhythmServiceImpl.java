package com.huanduguihua.wathet.question3.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.system.service.impl.DefaultServiceImpl;
import com.huanduguihua.wathet.question3.bean.MusicRhythm;
import com.huanduguihua.wathet.question3.service.MusicRhythmService;

@Service
public class MusicRhythmServiceImpl extends DefaultServiceImpl implements MusicRhythmService{

	@Override
	public void save(MusicRhythm musicRhythm) {
		try {
			super.update(musicRhythm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, MusicRhythm.class);
	}

	@Override
	public List<MusicRhythm> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<MusicRhythm> list=new ArrayList<MusicRhythm>();
			for(int i = 0;i<l.size();i++){
				list.add((MusicRhythm)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}

}
