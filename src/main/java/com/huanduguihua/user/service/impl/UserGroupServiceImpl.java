package com.huanduguihua.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.system.service.impl.DefaultServiceImpl;
import com.huanduguihua.user.bean.User;
import com.huanduguihua.user.bean.UserGroup;
import com.huanduguihua.user.service.UserGroupService;

@Service
public class UserGroupServiceImpl extends DefaultServiceImpl implements
		UserGroupService {

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, UserGroup.class);
	}

	@Override
	public List<UserGroup> list(User u) {
		String sql="select * from usergroup where user_id=?";
		try {
			List<Map<String, Object>> l = super.executeQuery(sql, u.getId());
			if(l.size()==0){
				return new ArrayList<UserGroup>();
			}
			else{
				ArrayList<UserGroup> arr=new ArrayList<UserGroup>();
				for(int i = 0 ; i < l.size() ; i ++){
					arr.add((UserGroup)this.pack(l).get(i));
				}
				return arr;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  new ArrayList<UserGroup>();
	}

	
	@Override
	public void save(UserGroup u) {
		try {
			super.update(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public UserGroup getUsergGroup(User u) {
		String sql="select * from usergroup where user_id=?";
		try {
			List<Map<String, Object>> l = super.executeQuery(sql, u.getId());
			if(l.size()==0){
				return null;
			}
			else{
					return (UserGroup)this.pack(l).get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Integer uid) {
		String sql="delete from usergroup where user_id=?";
		super.executeUpdate(sql, uid);
	}

}
