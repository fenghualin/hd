package com.huanduguihua.wathet.question4.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.system.service.impl.DefaultServiceImpl;
import com.huanduguihua.wathet.question4.bean.MusicCemory;
import com.huanduguihua.wathet.question4.service.MusicCemoryService;

@Service
public class MusicCemoryServiceImpl extends DefaultServiceImpl implements MusicCemoryService{

	@Override
	public void save(MusicCemory musicCemory) {
		try {
			super.update(musicCemory);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, MusicCemory.class);
	}

	@Override
	public List<MusicCemory> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<MusicCemory> list=new ArrayList<MusicCemory>();
			for(int i = 0;i<l.size();i++){
				list.add((MusicCemory)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}

}
