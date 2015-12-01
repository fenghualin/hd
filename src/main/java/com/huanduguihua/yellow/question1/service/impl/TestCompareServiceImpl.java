package com.huanduguihua.yellow.question1.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.system.service.impl.DefaultServiceImpl;
import com.huanduguihua.yellow.question1.bean.TestCompare;
import com.huanduguihua.yellow.question1.service.TestCompareService;

/**
 * 
 * TestCompareServiceImpl
 * 
 * kin
 * kin
 * 2014-5-12 下午2:36:09
 * 
 * @author liusen
 * @version 1.0.0
 * 
 */
@Service
public class TestCompareServiceImpl extends DefaultServiceImpl implements TestCompareService{

	@Override 
	public void save(TestCompare testCpmpare){
		String query = "insert into test_compare(id,test_no,user_id,question_no,reaction_time,reaction_choice,is_true,correct_answer,student_answer) values("+
				testCpmpare.getId()+","+
				testCpmpare.getTest_no()+","+
				testCpmpare.getUser_id()+","+
				testCpmpare.getQuestion_no()+","+
				testCpmpare.getReaction_time()+","+
				testCpmpare.getReaction_choice()+","+
				testCpmpare.getIs_true()+","+
				testCpmpare.getCorrect_answer()+","+
				testCpmpare.getStudent_answer()
				+")";
		super.executeUpdate(query);
		
	}
	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, TestCompare.class);
	}
	
	public Integer getTableId(String table){
		return super.generateId(table);
	}
	@Override
	public List<TestCompare> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<TestCompare> list=new ArrayList<TestCompare>();
			for(int i = 0;i<l.size();i++){
				list.add((TestCompare)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}

}
