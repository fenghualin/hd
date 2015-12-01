package com.huanduguihua.blue.question_5.service.imple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.blue.question_4.bean.CenterTest;
import com.huanduguihua.blue.question_5.bean.EmptyTest;
import com.huanduguihua.blue.question_5.service.EmptyTestService;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;
@Service
public class EmptyTestServiceImpl extends DefaultServiceImpl implements
		EmptyTestService {

	@Override
	public void save(EmptyTest emptyTest) {
		String query = "insert into test_empty(test_no,user_id,question_no,reaction_time,reaction_choice,`range`,accuracy,correct_answer,student_answer) values(?,?,?,?,?,?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(emptyTest.getTestNo());
		params.add(emptyTest.getUserId());
		params.add(emptyTest.getQuestionNo());
		params.add(emptyTest.getReactionTime());
		params.add(emptyTest.getReactionChioce());
		params.add(emptyTest.getRange());
		params.add(emptyTest.getAccuracy());
		params.add(emptyTest.getCorrectAnswer());
		params.add(emptyTest.getStudentAnswer());
		
//		System.out.println(query);
//		System.out.println(params.toString());
		
		super.executeUpdate(query, params.toArray());
	}

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		// TODO Auto-generated method stub
		return super.pack(datas, EmptyTest.class);
	}

	@Override
	public List<EmptyTest> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<EmptyTest> list=new ArrayList<EmptyTest>();
			for(int i = 0;i<l.size();i++){
				list.add((EmptyTest)this.pack(l).get(i));
			}
			return list;
		}
		else{
			return new ArrayList<EmptyTest>();
		}
	}

}
