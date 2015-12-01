package com.huanduguihua.gray.question3.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.gray.question3.bean.Personality;
import com.huanduguihua.gray.question3.service.PersonalityService;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;

@Service
public class PersonalityServiceImpl extends DefaultServiceImpl implements PersonalityService{

	@Override
	public void save(Personality personality) {
		try {
			super.update(personality);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, Personality.class);
	}

	@Override
	public List<Personality> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<Personality> list=new ArrayList<Personality>();
			for(int i = 0;i<l.size();i++){
				list.add((Personality)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}

}
