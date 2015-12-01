package com.huanduguihua.blue.question_2.service.imple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.blue.question_2.bean.MatchingTest;
import com.huanduguihua.blue.question_2.service.MatchingTestService;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;
@Service
public class MatchingTestServiceImpl extends DefaultServiceImpl implements MatchingTestService{

	@Override
	public void save(MatchingTest matching) {
		String query = "insert into test_macthing (test_no,user_id,question_no,reaction_time,reaction_choice,delay,is_true,position) values(?,?,?,?,?,?,?,?)";
		super.executeUpdate(query,
							matching.getTestNo(),
							matching.getUserId(),
							matching.getQuestionNo(),
							matching.getReactionTime(),
							matching.getReactionChoice(),
							matching.getDelay(),
							matching.getIsTrue() ? 1 : 0,
							matching.getPosition());
	}

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, MatchingTest.class);
	}

	@Override
	public List<MatchingTest> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<MatchingTest> list=new ArrayList<MatchingTest>();
			for(int i = 0;i<l.size();i++){
				list.add((MatchingTest)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}

}
