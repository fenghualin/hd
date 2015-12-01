package com.huanduguihua.green.question4.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.green.question4.bean.TestTargetcompare;
import com.huanduguihua.green.question4.service.TestTargetcompareService;
import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;

@Service
public class TestTargetcompareServiceImpl extends DefaultServiceImpl implements TestTargetcompareService{

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, TestTargetcompare.class);
	}

	@Override
	public void save(TestTargetcompare testTargetcompare) {
		try {
//			System.out.println("save.bean: " + testTargetcompare);
			super.update(testTargetcompare);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<TestTargetcompare> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<TestTargetcompare> list=new ArrayList<TestTargetcompare>();
			for(int i = 0;i<l.size();i++){
				list.add((TestTargetcompare)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}

	@Override
	public void delete(Integer uid) {
		String sql="delete from test_targetcompare where user_id=?";
		super.executeUpdate(sql, uid);
		
	}

}
