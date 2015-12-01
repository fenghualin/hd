package com.huanduguihua.red.question2.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.red.question2.bean.TestThinking;
import com.huanduguihua.red.question2.service.TestThinkingService;
import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;

@Service
public class TestThinkingServiceImpl extends DefaultServiceImpl implements TestThinkingService{

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, TestThinking.class);
	}

	@Override
	public void save(TestThinking testThinking) {
		try {
			super.update(testThinking);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<TestThinking> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<TestThinking> list=new ArrayList<TestThinking>();
			for(int i = 0;i<l.size();i++){
				list.add((TestThinking)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}

}
