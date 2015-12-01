package com.huanduguihua.green.question3.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.green.question3.bean.TestOperationb;
import com.huanduguihua.green.question3.service.TestOperationbService;
import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;

@Service
public class TestOperationbServiceImpl extends DefaultServiceImpl implements TestOperationbService{

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, TestOperationb.class);
	}


	@Override
	public void save(TestOperationb testOperationb) {
		try {
			super.update(testOperationb);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}


	@Override
	public List<TestOperationb> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<TestOperationb> list=new ArrayList<TestOperationb>();
			for(int i = 0;i<l.size();i++){
				list.add((TestOperationb)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}
}
