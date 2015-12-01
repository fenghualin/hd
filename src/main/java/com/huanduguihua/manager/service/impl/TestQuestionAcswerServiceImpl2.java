package com.huanduguihua.manager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.manager.bean.TestQuestionAnswer2;
import com.huanduguihua.manager.service.TestQuestionAcswerService2;
import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;

@Service
public class TestQuestionAcswerServiceImpl2 extends DefaultServiceImpl implements TestQuestionAcswerService2{

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, TestQuestionAnswer2.class);
	}

	@Override
	public void save(TestQuestionAnswer2 testQuestionAnswer2) {
		try {
			super.update(testQuestionAnswer2);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void savecr(TestQuestionAnswer2 testQuestionAnswer2) {
		String query = "insert into test_question_answer2_cr(id,option_s,option_text,option_score,question_id) values("+
				testQuestionAnswer2.getId()+",'"+
				testQuestionAnswer2.getOption_s()+"','"+
				testQuestionAnswer2.getOption_text()+"',"+
				testQuestionAnswer2.getOption_score()+","+
				testQuestionAnswer2.getQuestion_id()
				+")";
//		System.out.println(query);
		super.executeUpdate(query);
		
	}
	
	public List<TestQuestionAnswer2> questionlists(String query) {
		List<Map<String, Object>> datas = super.executeQuery(query);
		if (datas.size() == 0) {
			return  new ArrayList<TestQuestionAnswer2>();
		} else {
			List<TestQuestionAnswer2> l=new ArrayList<TestQuestionAnswer2>();
			for(int i = 0 ; i < datas.size() ; i++){
				l.add((TestQuestionAnswer2)this.pack(datas).get(i));
			}
			return l ;
		}
	}

	@Override
	public void delete(Integer id) throws ServiceException {
		TestQuestionAnswer2 testQuestionAnswer = new TestQuestionAnswer2();
		testQuestionAnswer.setId(id);
		super.delete(testQuestionAnswer);
	}
	
	@Override
	public void deletes(Integer id) throws ServiceException{
		try {
			super.executeUpdate("delete from test_question_answer2 where question_id=?", id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}
	@Override
	public void deletescr(Integer id) throws ServiceException{
		try {
			super.executeUpdate("delete from test_question_answer2_cr where question_id=?", id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}
	
	@Override
	public void update(TestQuestionAnswer2 testQuestionAnswer) throws ServiceException {
		super.executeUpdate("update test_question_answer2 set option_text=?,option_score=? where question_id=? and option_s=?",testQuestionAnswer.getOption_text(),testQuestionAnswer.getOption_score(),testQuestionAnswer.getQuestion_id(),testQuestionAnswer.getOption_s());
	}
	@Override
	public void updatecr(TestQuestionAnswer2 testQuestionAnswer) throws ServiceException {
		super.executeUpdate("update test_question_answer2_cr set option_text=?,option_score=? where question_id=? and option_s=?",testQuestionAnswer.getOption_text(),testQuestionAnswer.getOption_score(),testQuestionAnswer.getQuestion_id(),testQuestionAnswer.getOption_s());
	}

	@Override
	public List<TestQuestionAnswer2>  getlist(Object pama){
		String query = "select * from test_question_answer2 where question_id=?";
		List<Map<String, Object>> datas = super.executeQuery(query, pama);
		if (datas.size() == 0) {
			return new ArrayList<TestQuestionAnswer2>();
		} else {
			List<TestQuestionAnswer2> l=new ArrayList<TestQuestionAnswer2>();
			for(int i = 0 ; i < datas.size() ; i++){
				l.add((TestQuestionAnswer2)this.pack(datas).get(i));
			}
			return l ;
		}
	}
	@Override
	public List<TestQuestionAnswer2>  getlistcr(Object pama){
		String query = "select * from test_question_answer2_cr where question_id=?";
		List<Map<String, Object>> datas = super.executeQuery(query, pama);
		if (datas.size() == 0) {
			return new ArrayList<TestQuestionAnswer2>();
		} else {
			List<TestQuestionAnswer2> l=new ArrayList<TestQuestionAnswer2>();
			for(int i = 0 ; i < datas.size() ; i++){
				l.add((TestQuestionAnswer2)this.pack(datas).get(i));
			}
			return l ;
		}
	}
}
