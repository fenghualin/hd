package com.huanduguihua.wathet.question2.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.system.service.impl.DefaultServiceImpl;
import com.huanduguihua.wathet.question2.bean.MusicLength;
import com.huanduguihua.wathet.question2.service.MusicLengthService;

@Service
public class MusicLengthServiceImpl extends DefaultServiceImpl implements MusicLengthService{

	@Override
	public void save(MusicLength musicLength) {
		try {
			super.update(musicLength);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, MusicLength.class);
	}

	@Override
	public List<MusicLength> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<MusicLength> list=new ArrayList<MusicLength>();
			for(int i = 0;i<l.size();i++){
				list.add((MusicLength)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}

}
