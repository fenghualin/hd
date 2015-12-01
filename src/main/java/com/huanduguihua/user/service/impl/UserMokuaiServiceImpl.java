package com.huanduguihua.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.system.service.impl.DefaultServiceImpl;
import com.huanduguihua.user.bean.User;
import com.huanduguihua.user.bean.UserMokuai;
import com.huanduguihua.user.service.UserMokuaiService;

@Service
public class UserMokuaiServiceImpl extends DefaultServiceImpl implements UserMokuaiService{

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, UserMokuai.class);
	}

	@Override
	public List<UserMokuai> list(User u) {
		String sql="select * from usermokuai where user_id=?";
		try {
			List<Map<String, Object>> datas = super.executeQuery(sql, u.getId());
			if (datas.size() == 0) {
				return new ArrayList<UserMokuai>();
			} else {
				ArrayList<UserMokuai> l = new ArrayList<UserMokuai>();
				for(int i = 0 ; i < datas.size() ; i++){
					l.add((UserMokuai) this.pack(datas).get(i));
				}
				return l;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<UserMokuai>();
	}

	@Override
	public void save(UserMokuai u) {
		try {
			super.update(u);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
