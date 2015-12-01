package com.huanduguihua.red.question3.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.red.question3.bean.TestredOperation;
import com.huanduguihua.red.question3.service.TestredOperationService;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;

@Service
public class TestredOperationServiceImpl extends DefaultServiceImpl implements TestredOperationService{

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		// TODO Auto-generated method stub
		return super.pack(datas, TestredOperation.class);
	}

	@Override
	public void save(TestredOperation operation){
		try {
			super.update(operation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<TestredOperation> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<TestredOperation> list=new ArrayList<TestredOperation>();
			for(int i = 0;i<l.size();i++){
				list.add((TestredOperation)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}
}
