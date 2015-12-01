package com.huanduguihua.violet.question1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.system.service.impl.DefaultServiceImpl;
import com.huanduguihua.violet.question1.bean.Induction;
import com.huanduguihua.violet.question1.service.InductionService;

@Service
public class InductionServiceImpl extends DefaultServiceImpl implements InductionService{

	@Override
	public void save(Induction induction) {
		try {
			super.update(induction);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, Induction.class);
	}

	@Override
	public List<Induction> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<Induction> list=new ArrayList<Induction>();
			for(int i = 0;i<l.size();i++){
				list.add((Induction)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}

}
