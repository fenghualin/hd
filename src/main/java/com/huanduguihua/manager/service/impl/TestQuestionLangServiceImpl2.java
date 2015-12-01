package com.huanduguihua.manager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.green.question3.bean.search.TestOperationbSearch;
import com.huanduguihua.manager.bean.TestQuestionLang2;
import com.huanduguihua.manager.service.TestQuestionLangService2;
import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;

@Service
public class TestQuestionLangServiceImpl2 extends DefaultServiceImpl implements TestQuestionLangService2{

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, TestQuestionLang2.class);
	}
	
	@Override
	public List<TestQuestionLang2> questionlist() {
		String query = "select * from test_question_lang2"; 
		List<Map<String, Object>> datas = super.executeQuery(query);
		if (datas.size() == 0) {
			return  new ArrayList<TestQuestionLang2>();
		} else {
			List<TestQuestionLang2> l=new ArrayList<TestQuestionLang2>();
			for(int i = 0 ; i < datas.size() ; i++){
				l.add((TestQuestionLang2)this.pack(datas).get(i));
			}
			return l ;
		}
	}

	@Override
	public void delete(Integer id) throws ServiceException {
		TestQuestionLang2 lang = new TestQuestionLang2();
		lang.setId(id);
		super.delete(lang);
		
	}
	@Override
	public void deletecr(Integer id) throws ServiceException {
		this.executeUpdate("delete from test_question_lang2_cr where id=?", id);
		
	}

	@Override
	public Integer getTableId(String table) {
		return super.generateId(table);
	}

	
	@Override
	public void save(TestQuestionLang2 testQuestionLang2) {
		String query = "insert into test_question_lang2(id,question_text,kinds,inverted) values("+
				testQuestionLang2.getId()+",'"+
				testQuestionLang2.getQuestion_text()+"',"+
				testQuestionLang2.getKinds()+","+
				testQuestionLang2.getInverted()
				+")";
		super.executeUpdate(query);
	}
	@Override
	public void savecr(TestQuestionLang2 testQuestionLang2) {
		String query = "insert into test_question_lang2_cr(id,question_text,kinds,inverted) values("+
				testQuestionLang2.getId()+",'"+
				testQuestionLang2.getQuestion_text()+"',"+
				testQuestionLang2.getKinds()+","+
				testQuestionLang2.getInverted()
				+")";
		super.executeUpdate(query);
	}
	
	public TestQuestionLang2 get(Integer id) throws ServiceException {
		return (TestQuestionLang2) super.get(id, TestQuestionLang2.class);
	}
	public TestQuestionLang2 getcr(Integer id) throws ServiceException {
		try {
			List<Map<String, Object>> datas = super.executeQuery("select * from test_question_lang2_cr where id=?", id);
			if (datas.size() == 0) {
				return new TestQuestionLang2();
			} else {
				return (TestQuestionLang2) this.pack(datas).get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}
	
	@Override
	public TestOperationbSearch list(TestOperationbSearch search,Integer pagestart,Integer pagesize)
			throws ServiceException {
		String query = " select * ";
		
		//条件语句
		String where = " from test_question_lang2 where 1 ";
		
//		如果这里有条件，则where += " and xxx = xxxx";
		if (search.getKinds() != null) {
			where += " and kinds = " + search.getKinds();
		}
		//排序
		String order = " order by `order` asc ";
		search.setQuery(query);
		search.setWhere(where);
		search.setOrder(order);
		search.setPage(pagestart);
		search.setPageSize(pagesize);
		//调用super.queryBySearch之后会重置query、where、order、param参数
		return (TestOperationbSearch) super.queryBySearch(search);
	}
	@Override
	public TestOperationbSearch listcr(TestOperationbSearch search,Integer pagestart,Integer pagesize)
			throws ServiceException {
		String query = " select * ";
		
		//条件语句
		String where = " from test_question_lang2_cr where 1 ";
		
//		如果这里有条件，则where += " and xxx = xxxx";
		if (search.getKinds() != null) {
			where += " and kinds = " + search.getKinds();
		}
		//排序
		String order = " order by `order` asc ";
		search.setQuery(query);
		search.setWhere(where);
		search.setOrder(order);
		search.setPage(pagestart);
		search.setPageSize(pagesize);
		//调用super.queryBySearch之后会重置query、where、order、param参数
		return (TestOperationbSearch) super.queryBySearch(search);
	}
	@Override
	public void updatecr(TestQuestionLang2 testQuestionLang2)
			throws ServiceException {
		String query = "update test_question_lang2_cr set kinds=?,question_text=? where id=?";
		super.executeUpdate(query, testQuestionLang2.getKinds(),testQuestionLang2.getQuestion_text(),testQuestionLang2.getId());
	}
}
