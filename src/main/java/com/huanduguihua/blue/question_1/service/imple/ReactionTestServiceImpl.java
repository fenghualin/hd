package com.huanduguihua.blue.question_1.service.imple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.blue.question_1.bean.ReactionTest;
import com.huanduguihua.blue.question_1.service.ReactionTestService;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;
@Service
public class ReactionTestServiceImpl extends DefaultServiceImpl implements ReactionTestService {
	@Override
	public void save(ReactionTest reaction) {
		String query = "insert into test_reaction(test_no,user_id,question_no,reaction_time,reaction_choice,delay,is_true,position) values("+
						reaction.getTest_no()+","+
						reaction.getUser_id()+","+
						reaction.getQuestion_no()+","+
						reaction.getReaction_time()+","+
						reaction.getReaction_choice()+","+
						reaction.getDelay()+","+
						reaction.getIs_true()+","+
						reaction.getPosition()+")";
		super.executeUpdate(query);
	}

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, ReactionTest.class);
	}

	@Override
	public List<ReactionTest> list(String sql,String uid,String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<ReactionTest> list=new ArrayList<ReactionTest>();
			for(int i = 0;i<l.size();i++){
				list.add((ReactionTest)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}
}
