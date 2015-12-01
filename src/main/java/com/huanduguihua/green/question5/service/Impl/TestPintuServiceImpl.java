package com.huanduguihua.green.question5.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.green.question5.bean.TestPintu;
import com.huanduguihua.green.question5.service.TestPintuService;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;

@Service
public class TestPintuServiceImpl extends DefaultServiceImpl implements TestPintuService{

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, TestPintu.class);
	}

	@Override
	public void save(TestPintu testPintu) {
		try {
			super.update(testPintu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<TestPintu> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<TestPintu> list=new ArrayList<TestPintu>();
			for(int i = 0;i<l.size();i++){
				list.add((TestPintu)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}

}
