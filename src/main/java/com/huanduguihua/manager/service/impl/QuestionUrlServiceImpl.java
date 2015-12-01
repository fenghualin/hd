package com.huanduguihua.manager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.manager.bean.QuestionUrl;
import com.huanduguihua.manager.service.QuestionUrlService;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;

@Service
public class QuestionUrlServiceImpl extends DefaultServiceImpl implements QuestionUrlService{

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, QuestionUrl.class);
	}

	@Override
	public List<QuestionUrl> list() {
		String query="select * from questionurl";
		List<Map<String, Object>> datas = super.executeQuery(query);
		if (datas.size() == 0) {
			return  new ArrayList<QuestionUrl>();
		} else {
			List<QuestionUrl> l=new ArrayList<QuestionUrl>();
			for(int i = 0 ; i < datas.size() ; i++){
				l.add((QuestionUrl)this.pack(datas).get(i));
			}
			return l ;
		}
	}

	@Override
	public QuestionUrl getquestionurl(Integer val) {
		String sql="select * from questionurl where id=?";
		List<Map<String, Object>> datas = super.executeQuery(sql,val);
		if (datas.size() == 0) {
			return  new QuestionUrl();
		} else {
			return (QuestionUrl)this.pack(datas).get(0);
		}
	}

	@Override
	public QuestionUrl get(Integer id) {
		
		return null;
	}

	@Override
	public QuestionUrl getQeurl(String val) {
		String sql="select * from questionurl where questionurl=?";
		List<Map<String, Object>> l = super.executeQuery(sql, val);
		if(l.size()==0){
			return null;
		}
		else{
			return (QuestionUrl) this.pack(l).get(0);
		}
	}

	
}
