package com.huanduguihua.gray.question4.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.huanduguihua.gray.question4.bean.Rgtstbean;
import com.huanduguihua.gray.question4.service.RgtstbeanService;
import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;

@Service
public class RgtstbeanServiceImpl extends DefaultServiceImpl implements RgtstbeanService{

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, Rgtstbean.class);
	}

	@Override
	public void save(Rgtstbean rgtstbean) {
		try {
			super.update(rgtstbean);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Rgtstbean> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<Rgtstbean> list=new ArrayList<Rgtstbean>();
			for(int i = 0;i<l.size();i++){
				list.add((Rgtstbean)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}
}
