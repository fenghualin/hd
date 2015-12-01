package com.huanduguihua.yellow.question2.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.system.service.impl.DefaultServiceImpl;
import com.huanduguihua.yellow.question2.bean.TestOperation;
import com.huanduguihua.yellow.question2.service.TestOperationService;

@Service
public class TestOperationServiceImpl extends DefaultServiceImpl implements TestOperationService{


	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		// TODO Auto-generated method stub
		return super.pack(datas, TestOperation.class);
	}


	@Override
	public Integer getTableId(String table) {
		return super.generateId(table);
	}


	@Override
	public void save(TestOperation testOperation) {
		String query = "insert into test_operation(id,test_no,user_id,question_no,reaction_time,step,is_true,correct_answer,student_answer) values("+
				testOperation.getId()+","+
				testOperation.getTest_no()+","+
				testOperation.getUser_id()+","+
				testOperation.getQuestion_no()+","+
				testOperation.getReaction_time()+","+
				testOperation.getStep()+","+
				testOperation.getIs_true()+","+
				testOperation.getCorrect_answer()+","+
				testOperation.getStudent_answer()
				+")";
		super.executeUpdate(query);
		
	}


	@Override
	public List<TestOperation> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<TestOperation> list=new ArrayList<TestOperation>();
			for(int i = 0;i<l.size();i++){
				list.add((TestOperation)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}

}
