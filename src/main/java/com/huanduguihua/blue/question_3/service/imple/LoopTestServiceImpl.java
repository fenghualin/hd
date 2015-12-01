package com.huanduguihua.blue.question_3.service.imple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.blue.question_3.bean.LoopTest;
import com.huanduguihua.blue.question_3.service.LoopTestService;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;
@Service
public class LoopTestServiceImpl extends DefaultServiceImpl implements LoopTestService{

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, LoopTest.class);
	}

	@Override
	public void save(LoopTest loopTest) {
		String query = "insert into test_loop(test_no,user_id,question_no,reaction_time,reaction_choice,`range`,accuracy,correct_answer,student_answer) values(?,?,?,?,?,?,?,?,?)";
		
		List<Object> params = new ArrayList<Object>();
		
		params.add(loopTest.getTestNo());
		params.add(loopTest.getUserId());
		params.add(loopTest.getQuestionNo());
		params.add(loopTest.getReactionTime());
		params.add(loopTest.getReactionChoice());
		params.add(loopTest.getRange());
		params.add(loopTest.getAccuracy());
		params.add(loopTest.getCorrectAnswer());
		params.add(loopTest.getStudentAnswer());
	
		super.executeUpdate(query, params.toArray());
	}

	@Override
	public List<LoopTest> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<LoopTest> list=new ArrayList<LoopTest>();
			for(int i = 0;i<l.size();i++){
				list.add((LoopTest)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}
}
