package com.huanduguihua.yellow.question3.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;
import com.huanduguihua.yellow.question3.bean.TestResult;
import com.huanduguihua.yellow.question3.service.TestResultService;

@Service
public class TestResultServiceImpl extends DefaultServiceImpl implements TestResultService{

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, TestResult.class);
	}

	@Override
	public void save(TestResult testResult) {
		try {
			super.update(testResult);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Integer getTableId(String table) {
		return super.generateId(table);
	}

	@Override
	public List<TestResult> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<TestResult> list=new ArrayList<TestResult>();
			for(int i = 0;i<l.size();i++){
				list.add((TestResult)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}

}
