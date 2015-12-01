package com.huanduguihua.red.question4.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.red.question4.bean.TestReasoning;
import com.huanduguihua.red.question4.service.TestReasoningService;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;

@Service
public class TestReasoningServiceImpl extends DefaultServiceImpl implements TestReasoningService{

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, TestReasoning.class);
	}

	@Override
	public void save(TestReasoning testReasoning) {
		try {
			super.update(testReasoning);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<TestReasoning> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<TestReasoning> list=new ArrayList<TestReasoning>();
			for(int i = 0;i<l.size();i++){
				list.add((TestReasoning)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}

}
