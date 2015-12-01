package com.huanduguihua.red.question1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.huanduguihua.red.question1.bean.TestAppearance;
import com.huanduguihua.red.question1.service.TestAppearanceService;
import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;

@Service
public class TestAppearanceServiceImpl extends DefaultServiceImpl implements TestAppearanceService{

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, TestAppearance.class);
	}

	@Override
	public void save(TestAppearance testAppearance) {
		try {
			super.update(testAppearance);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<TestAppearance> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<TestAppearance> list=new ArrayList<TestAppearance>();
			for(int i = 0;i<l.size();i++){
				list.add((TestAppearance)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}

}
