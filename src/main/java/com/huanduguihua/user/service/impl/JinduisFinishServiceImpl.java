package com.huanduguihua.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;
import com.huanduguihua.user.bean.JinduisFinish;
import com.huanduguihua.user.service.JinduisFinishService;

@Service
public class JinduisFinishServiceImpl extends DefaultServiceImpl implements JinduisFinishService{

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, JinduisFinish.class);
	}

	@Override
	public JinduisFinish get(Integer id) {
		String sql = "select * from jinduisfinish where id=?";
		try {
			List<Map<String, Object>> l = super.executeQuery(sql, id);
			if(l.size()==0){
				return new JinduisFinish();
			}
			else {
				return (JinduisFinish)this.pack(l).get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public JinduisFinish save(JinduisFinish jinduisFinish) {
		try {
			return (JinduisFinish) super.update(jinduisFinish);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return jinduisFinish;
	}

}
