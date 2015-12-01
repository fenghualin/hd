package com.huanduguihua.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.system.service.impl.DefaultServiceImpl;
import com.huanduguihua.user.bean.Mokuai;
import com.huanduguihua.user.service.MokuaiService;

@Service
public class MokuaiServiceImpl extends DefaultServiceImpl implements MokuaiService{

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, Mokuai.class);
	}

	@Override
	public List<Mokuai> list(Integer mid) {
		String sql="select * from mokuai where id=?";
		try {
			List<Map<String, Object>> datas = super.executeQuery(sql,mid);
			if (datas.size() == 0) {
				return new ArrayList<Mokuai>();
			} else {
				ArrayList<Mokuai> l = new ArrayList<Mokuai>();
				for(int i = 0 ; i < datas.size() ; i++){
					l.add((Mokuai) this.pack(datas).get(i));
				}
				return l;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Mokuai get(Integer id) {
		String sql="select * from mokuai where id=?";
		try {
			List<Map<String, Object>> datas = super.executeQuery(sql,id);
			if (datas.size() == 0) {
				return new Mokuai();
			} else {
				return (Mokuai) this.pack(datas).get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Mokuai> zilist(Integer fid) {
		String sql="select * from mokuai where fid=?";
		try {
			List<Map<String, Object>> datas = super.executeQuery(sql,fid);
			if (datas.size() == 0) {
				return new ArrayList<Mokuai>();
			} else {
				ArrayList<Mokuai> l = new ArrayList<Mokuai>();
				for(int i = 0 ; i < datas.size() ; i++){
					l.add((Mokuai) this.pack(datas).get(i));
				}
				return l;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Mokuai>();
	}

	@Override
	public List<Mokuai> getzi(Integer id, Integer order) {
		String sql="select * from mokuai where fid=? and orderu=?";
		try {
			List<Map<String, Object>> datas = super.executeQuery(sql,id,order);
			if (datas.size() == 0) {
				return new ArrayList<Mokuai>();
			} else {
				ArrayList<Mokuai> al = new ArrayList<Mokuai>();
				al.add((Mokuai) this.pack(datas).get(0));
				return al ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Mokuai getmokuai(String mokuaiurl) {
		try {
			String sql="select * from mokuai where mokuai_url=?";
			List<Map<String, Object>> datas = super.executeQuery(sql,mokuaiurl);
			if (datas.size() == 0) {
				return null;
			} else {
				return (Mokuai) this.pack(datas).get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Mokuai> getzilist(Integer id) {
		String sql="select * from mokuai where fid=?";
		List<Map<String, Object>> l = super.executeQuery(sql, id);
		if(l.size()==0){
			return new ArrayList<Mokuai>();
		}
		else {
			List<Mokuai> lm = new ArrayList<Mokuai>();
			for(int i = 0 ; i < l.size() ; i++){
				lm.add((Mokuai)this.pack(l).get(i));
			}
			return lm;
		}
	}

	@Override
	public Mokuai getFu(Integer zid) {
		String sql="select * from mokuai where id=?";
		String sqlf="select * from mokuai where id=?";
		List<Map<String, Object>> l = super.executeQuery(sql, zid);
		if(l.size()==0){
			return null;
		}
		else {
			Mokuai mokuai = (Mokuai) this.pack(l).get(0);
			List<Map<String, Object>> datas = super.executeQuery(sqlf, mokuai.getFid());
			if(datas.size()==0){
				return null;
			}
			else{
				return (Mokuai) this.pack(datas).get(0);
			}
		}
	}

}
