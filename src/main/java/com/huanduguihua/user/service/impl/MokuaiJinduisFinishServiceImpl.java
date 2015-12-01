package com.huanduguihua.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;
import com.huanduguihua.user.bean.MokuaiJinduisFinish;
import com.huanduguihua.user.service.MokuaiJinduisFinishService;

@Service
public class MokuaiJinduisFinishServiceImpl extends DefaultServiceImpl
		implements MokuaiJinduisFinishService {

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, MokuaiJinduisFinish.class);
	}

	@Override
	public MokuaiJinduisFinish save(MokuaiJinduisFinish finish) {
		try {
			return (MokuaiJinduisFinish) super.update(finish);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return finish;
		
	}

	@Override
	public MokuaiJinduisFinish get(Integer id) {
		String sql="select * from mokuaijinduisfinish where id=?";
		List<Map<String, Object>> l = super.executeQuery(sql, id);
		if(l.size()==0){
			return null;
		}
		else{
			return (MokuaiJinduisFinish) this.pack(l).get(0);
		}
	}

	@Override
	public MokuaiJinduisFinish userget(Integer id) {
		String sql="select * from mokuaijinduisfinish where user_id=?";
		List<Map<String, Object>> l = super.executeQuery(sql, id);
		if(l.size()==0){
			return null;
		}
		else{
			return (MokuaiJinduisFinish) this.pack(l).get(0);
		}
	}
}
