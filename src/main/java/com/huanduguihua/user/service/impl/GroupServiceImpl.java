package com.huanduguihua.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;
import com.huanduguihua.user.bean.Group;
import com.huanduguihua.user.bean.search.GroupSearch;
import com.huanduguihua.user.service.GroupService;

@Service
public class GroupServiceImpl extends DefaultServiceImpl implements
		GroupService {

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, Group.class);
	}

	@Override
	public Group get(Integer id) {
		try {
			String sql = "select * from `group` where id=?";
			List<Map<String, Object>> l = super.executeQuery(sql, id);
			if(l.size()==0){
				return null;
			}
			else{
				return (Group)this.pack(l).get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public GroupSearch list(GroupSearch search, String pagestart,
			String pagesize) throws ServiceException {
		//内容查询
				String query = " select * ";
				
				//条件语句
				String where = " from `group` where 1";
				
				//如果这里有条件，则where += " and xxx = xxxx";
//				where += " and account_id = " + search.getAccountId();
//				if (search.getPid() != null) {
//					where += " and pid = " + search.getPid();
//				}
				//排序
				String order = " order by id asc";
				search.setQuery(query);
				search.setWhere(where);
				search.setOrder(order);
				search.setPage(Integer.parseInt(pagestart));
				search.setPageSize(Integer.parseInt(pagesize));
				//调用super.queryBySearch之后会重置query、where、order、param参数
				return (GroupSearch) super.queryBySearch(search);
	}

	@Override
	public void save(Group g) throws ServiceException {
		String sql = "insert into `group`(id,name) values(?,?)";
		try {
			super.executeUpdate(sql, g.getId(),g.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public List<Group> getlist() {
		String sql="select * from `group`";
		List<Map<String, Object>> l = super.executeQuery(sql);
		if(l.size()==0){
			return new ArrayList<Group>();
		}
		else{
			ArrayList<Group> arr=new ArrayList<Group>();
			for(int i = 0;i<l.size();i++){
				arr.add((Group)this.pack(l).get(i));
			}
			return arr;
		}
	}

	@Override
	public void delete(Integer id) {
		String sql="delete from `group` where id=?";
		super.executeUpdate(sql, id);
		
	}

	@Override
	public void update(Group g) {
			String sql="update `group` set name=? where id=?";
			super.executeUpdate(sql, g.getName(),g.getId());
	}

}
