package com.huanduguihua.yellow.question4.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;
import com.huanduguihua.yellow.question4.bean.TestMaze;
import com.huanduguihua.yellow.question4.service.TestMazeService;

@Service
public class TestMazeServiceImpl extends DefaultServiceImpl implements TestMazeService{

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, TestMaze.class);
	}

	@Override
	public void save(TestMaze testMaze) {
		try {
			super.update(testMaze);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<TestMaze> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<TestMaze> list=new ArrayList<TestMaze>();
			for(int i = 0;i<l.size();i++){
				list.add((TestMaze)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}

}
