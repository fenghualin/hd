package com.huanduguihua.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;
import com.huanduguihua.user.bean.MokuaiGroup;
import com.huanduguihua.user.service.MokuaiGroupService;

@Service
public class MokuaiGroupServiceImpl extends DefaultServiceImpl implements
		MokuaiGroupService {

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, MokuaiGroup.class);
	}

	@Override
	public List<MokuaiGroup> list(Integer id) {
		try {
			String sql="select * from mokuaigroup where group_id=?";
			List<Map<String, Object>> l = super.executeQuery(sql, id);
			if(l.size()==0){
				return new ArrayList<MokuaiGroup>();
			}
			else{
				ArrayList<MokuaiGroup> arr=new ArrayList<MokuaiGroup>();
				for(int i = 0 ; i < l.size() ; i++){
					arr.add((MokuaiGroup)this.pack(l).get(i));
				}
				return arr;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public void save(MokuaiGroup m) {
		try {
			super.update(m);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteg(Integer gid) {
		String sql="delete from mokuaigroup where group_id=?";
		super.executeUpdate(sql, gid);
	}

}
