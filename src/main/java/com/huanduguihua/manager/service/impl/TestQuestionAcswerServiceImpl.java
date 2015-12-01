package com.huanduguihua.manager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.manager.bean.TestQuestionAnswer;
import com.huanduguihua.manager.service.TestQuestionAcswerService;
import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;

@Service
public class TestQuestionAcswerServiceImpl extends DefaultServiceImpl implements TestQuestionAcswerService{

	@Override
	public void save(TestQuestionAnswer testQuestionAnswer) {
		String query = "insert into test_question_answer(id,option_s,option_text,option_score,question_id) values("+
				testQuestionAnswer.getId()+",'"+
				testQuestionAnswer.getOption_s()+"','"+
				testQuestionAnswer.getOption_text()+"',"+
				testQuestionAnswer.getOption_score()+","+
				testQuestionAnswer.getQuestion_id()
				+")";
//		System.out.println(query);
		super.executeUpdate(query);
	}
	@Override
	public void savecr(TestQuestionAnswer testQuestionAnswer) {
		String query = "insert into test_question_answer_cr(id,option_s,option_text,option_score,question_id) values("+
				testQuestionAnswer.getId()+",'"+
				testQuestionAnswer.getOption_s()+"','"+
				testQuestionAnswer.getOption_text()+"',"+
				testQuestionAnswer.getOption_score()+","+
				testQuestionAnswer.getQuestion_id()
				+")";
//		System.out.println(query);
		super.executeUpdate(query);
	}
	public List<TestQuestionAnswer> questionlists(String query) {
		List<Map<String, Object>> datas = super.executeQuery(query);
		if (datas.size() == 0) {
			return  new ArrayList<TestQuestionAnswer>();
		} else {
			List<TestQuestionAnswer> l=new ArrayList<TestQuestionAnswer>();
			for(int i = 0 ; i < datas.size() ; i++){
				l.add((TestQuestionAnswer)this.pack(datas).get(i));
			}
			return l ;
		}
	}
	
	@Override
	public Integer getTableId(String table) {
		return super.generateId(table);
	}

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, TestQuestionAnswer.class);
	}

	@Override
	public List<TestQuestionAnswer> questionlist() {
		String query = "select id,option_s,option_text,option_score,question_id from test_question_answer"; 
		List<Map<String, Object>> datas = super.executeQuery(query);
		if (datas.size() == 0) {
			return  new ArrayList<TestQuestionAnswer>();
		} else {
			List<TestQuestionAnswer> l=new ArrayList<TestQuestionAnswer>();
			for(int i = 0 ; i < datas.size() ; i++){
				l.add((TestQuestionAnswer)this.pack(datas).get(i));
			}
			return l ;
		}
	}
	
	@Override
	public void delete(Integer id) throws ServiceException {
		TestQuestionAnswer testQuestionAnswer = new TestQuestionAnswer();
		testQuestionAnswer.setId(id);
		super.delete(testQuestionAnswer);
	}
	
	public void deletes(Integer id) throws ServiceException{
		try {
			super.executeUpdate("delete from test_question_answer where question_id=?", id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}
	public void deletescr(Integer id) throws ServiceException{
		try {
			super.executeUpdate("delete from test_question_answer_cr where question_id=?", id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}
	
	@Override
	public TestQuestionAnswer get(Integer id) throws ServiceException {
		return (TestQuestionAnswer) super.get(id, TestQuestionAnswer.class);
	}

	@Override
	public void update(TestQuestionAnswer testQuestionAnswer) throws ServiceException {
		super.executeUpdate("update test_question_answer set option_text=?,option_score=? where question_id=? and option_s=?",testQuestionAnswer.getOption_text(),testQuestionAnswer.getOption_score(),testQuestionAnswer.getQuestion_id(),testQuestionAnswer.getOption_s());
	}
	@Override
	public void updatecr(TestQuestionAnswer testQuestionAnswer) throws ServiceException {
		super.executeUpdate("update test_question_answer_cr set option_text=?,option_score=? where question_id=? and option_s=?",testQuestionAnswer.getOption_text(),testQuestionAnswer.getOption_score(),testQuestionAnswer.getQuestion_id(),testQuestionAnswer.getOption_s());
	}

	public List<TestQuestionAnswer>  getlist(String pama){
		String query = "select * from test_question_answer where question_id=?";
		List<Map<String, Object>> datas = super.executeQuery(query, pama);
		if (datas.size() == 0) {
			return new ArrayList<TestQuestionAnswer>();
		} else {
			List<TestQuestionAnswer> l=new ArrayList<TestQuestionAnswer>();
			for(int i = 0 ; i < datas.size() ; i++){
				l.add((TestQuestionAnswer)this.pack(datas).get(i));
			}
			return l ;
		}
	}
	public List<TestQuestionAnswer>  getlistcr(String pama){
		String query = "select * from test_question_answer_cr where question_id=?";
		List<Map<String, Object>> datas = super.executeQuery(query, pama);
		if (datas.size() == 0) {
			return new ArrayList<TestQuestionAnswer>();
		} else {
			List<TestQuestionAnswer> l=new ArrayList<TestQuestionAnswer>();
			for(int i = 0 ; i < datas.size() ; i++){
				l.add((TestQuestionAnswer)this.pack(datas).get(i));
			}
			return l ;
		}
	}
}
