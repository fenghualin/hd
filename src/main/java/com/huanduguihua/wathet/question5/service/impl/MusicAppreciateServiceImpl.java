package com.huanduguihua.wathet.question5.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.system.service.impl.DefaultServiceImpl;
import com.huanduguihua.wathet.question5.bean.MusicAppreciate;
import com.huanduguihua.wathet.question5.service.MusicAppreciateService;

@Service
public class MusicAppreciateServiceImpl extends DefaultServiceImpl implements MusicAppreciateService{

	@Override
	public void save(MusicAppreciate musicAppreciate) {
		try {
			super.update(musicAppreciate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, MusicAppreciate.class);
	}

	@Override
	public List<MusicAppreciate> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<MusicAppreciate> list=new ArrayList<MusicAppreciate>();
			for(int i = 0;i<l.size();i++){
				list.add((MusicAppreciate)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}

}
