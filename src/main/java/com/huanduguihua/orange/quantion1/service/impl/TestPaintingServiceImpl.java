package com.huanduguihua.orange.quantion1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.orange.quantion1.bean.TestPainting;
import com.huanduguihua.orange.quantion1.service.TestPaintingService;
import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;

@Service
public class TestPaintingServiceImpl extends DefaultServiceImpl implements TestPaintingService{

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, TestPainting.class);
	}

	@Override
	public void save(TestPainting testPainting) {
		try {
			super.update(testPainting);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<TestPainting> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<TestPainting> list=new ArrayList<TestPainting>();
			for(int i = 0;i<l.size();i++){
				list.add((TestPainting)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}

}
