package com.huanduguihua.wathet.question1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.system.service.impl.DefaultServiceImpl;
import com.huanduguihua.wathet.question1.bean.MusicForm;
import com.huanduguihua.wathet.question1.service.MusicFormService;

@Service
public class MusicFormServiceImpl extends DefaultServiceImpl implements MusicFormService{

	@Override
	public void save(MusicForm musicForm) {
		try {
			super.update(musicForm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, MusicForm.class);
	}

	@Override
	public List<MusicForm> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<MusicForm> list=new ArrayList<MusicForm>();
			for(int i = 0;i<l.size();i++){
				list.add((MusicForm)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}

	
	
}
