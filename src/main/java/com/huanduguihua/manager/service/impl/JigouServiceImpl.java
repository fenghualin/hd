package com.huanduguihua.manager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.manager.bean.Jigou;
import com.huanduguihua.manager.bean.search.JigouSearch;
import com.huanduguihua.manager.service.JigouService;
import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;

@Service
public class JigouServiceImpl extends DefaultServiceImpl implements JigouService{

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, Jigou.class);
	}
	public JigouSearch list(JigouSearch search,Integer pagestart,Integer pagesize)
			throws ServiceException {
		String query = " select * ";
		
		//条件语句
		String where = " from jigou where 1 ";
		
//		如果这里有条件，则where += " and xxx = xxxx";
		//排序
		String order = " order by id desc ";
		search.setQuery(query);
		search.setWhere(where);
		search.setOrder(order);
		search.setPage(pagestart);
		search.setPageSize(pagesize);
		//调用super.queryBySearch之后会重置query、where、order、param参数
		return (JigouSearch) super.queryBySearch(search);
	}
	@Override
	public Jigou save(Jigou j){
		try {
			return (Jigou) super.update(j);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return j;
	}
	@Override
	public void delete(Integer id) {
		String sql="delete from jigou where id=?";
		super.executeUpdate(sql, id);
	}
	@Override
	public Jigou get(Integer id) {
		String sql="select * from jigou where id=?";
		List<Map<String, Object>> l = super.executeQuery(sql, id);
		if(l.size()==0){
			return null;
		}
		else{
			return (Jigou) this.pack(l).get(0);
		}
	}
	@Override
	public Jigou update(Jigou jigou) {
		String sql = "update jigou set name=?,`describe`=? where id=?";
		super.executeUpdate(sql, jigou.getName(),jigou.getDescribe(),jigou.getId());
		return null;
	}
	@Override
	public List<Jigou> getall() {
		String sql = "select * from jigou";
		List<Map<String, Object>> l = super.executeQuery(sql);
		if(l.size()==0)
			return new ArrayList<Jigou>();
		else{
			ArrayList<Jigou> al = new ArrayList<Jigou>();
			for(int i = 0 ; i < l.size();i ++){
				al.add((Jigou)this.pack(l).get(i));
			}
			return al;
		}
	}
	
}
