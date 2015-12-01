package com.huanduguihua.violet.question2.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.system.service.impl.DefaultServiceImpl;
import com.huanduguihua.violet.question2.bean.Logical;
import com.huanduguihua.violet.question2.service.LogicalService;

@Service
public class LogicalServiceImpl extends DefaultServiceImpl implements LogicalService{

	@Override
	public void save(Logical logical) {
		try {
			super.update(logical);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, Logical.class);
	}

	@Override
	public List<Logical> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<Logical> list=new ArrayList<Logical>();
			for(int i = 0;i<l.size();i++){
				list.add((Logical)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}

}
