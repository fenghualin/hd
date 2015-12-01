package com.huanduguihua.green.question1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.green.question1.bean.TestSearch;
import com.huanduguihua.green.question1.service.TestSearchService;
import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;

@Service
public class TestSearchServiceImpl extends DefaultServiceImpl implements TestSearchService{

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		// TODO Auto-generated method stub
		return super.pack(datas, TestSearch.class);
	}

	@Override
	public void save(TestSearch testSearch) {
		try {
			super.update(testSearch);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<TestSearch> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<TestSearch> list=new ArrayList<TestSearch>();
			for(int i = 0;i<l.size();i++){
				list.add((TestSearch)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}
}
