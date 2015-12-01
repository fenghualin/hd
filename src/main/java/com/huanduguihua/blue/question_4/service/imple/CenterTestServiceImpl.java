package com.huanduguihua.blue.question_4.service.imple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.blue.question_3.bean.LoopTest;
import com.huanduguihua.blue.question_4.bean.CenterTest;
import com.huanduguihua.blue.question_4.service.CenterTestService;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;
@Service
public class CenterTestServiceImpl extends DefaultServiceImpl implements
		CenterTestService {
	
	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, CenterTest.class);
	}

	@Override
	public void save(CenterTest centerTest) {
		String query = "insert into test_center(test_no,user_id,question_no,reaction_time,reaction_choice,`range`,accuracy,correct_answer,student_answer) values(?,?,?,?,?,?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		
		params.add(centerTest.getTestNo());
		params.add(centerTest.getUserId());
		params.add(centerTest.getQuestionNo());
		params.add(centerTest.getReactionTime());
		params.add(centerTest.getReactionChoice());
		params.add(centerTest.getRange());
		params.add(centerTest.getAccuracy());
		params.add(centerTest.getCorrectAnswer());
		params.add(centerTest.getStudentAnswer());
		
		super.executeUpdate(query, params.toArray());
	}

	@Override
	public List<CenterTest> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<CenterTest> list=new ArrayList<CenterTest>();
			for(int i = 0;i<l.size();i++){
				list.add((CenterTest)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}
}
