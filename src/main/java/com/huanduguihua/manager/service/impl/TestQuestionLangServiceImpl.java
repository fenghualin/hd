package com.huanduguihua.manager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.manager.bean.TestQuestionLang;
import com.huanduguihua.manager.bean.search.TestQuestionLangSearch;
import com.huanduguihua.manager.service.TestQuestionLangService;
import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;

@Service
public class TestQuestionLangServiceImpl extends DefaultServiceImpl implements TestQuestionLangService{

	@Override
	public void save(TestQuestionLang testQuestionLang) {
		String query = "insert into test_question_lang(id,question_text,kinds) values("+
				testQuestionLang.getId()+",'"+
				testQuestionLang.getQuestion_text()+"',"+
				testQuestionLang.getKinds()
				+")";
		super.executeUpdate(query);
	}
	@Override
	public void savecr(TestQuestionLang testQuestionLang) {
		String query = "insert into test_question_lang_cr(id,question_text,kinds) values("+
				testQuestionLang.getId()+",'"+
				testQuestionLang.getQuestion_text()+"',"+
				testQuestionLang.getKinds()
				+")";
		super.executeUpdate(query);
	}
	@Override
	public Integer getTableId(String table) {
		return super.generateId(table);
	}

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, TestQuestionLang.class);
	}

	@Override
	public List<TestQuestionLang> questionlist() {
		String query = "select id,question_text,kinds from test_question_lang"; 
		List<Map<String, Object>> datas = super.executeQuery(query);
		if (datas.size() == 0) {
			return  new ArrayList<TestQuestionLang>();
		} else {
			List<TestQuestionLang> l=new ArrayList<TestQuestionLang>();
			for(int i = 0 ; i < datas.size() ; i++){
				l.add((TestQuestionLang)this.pack(datas).get(i));
			}
			return l ;
		}
	}
	
	@Override
	public void delete(Integer id) throws ServiceException {
		TestQuestionLang lang = new TestQuestionLang();
		lang.setId(id);
		super.delete(lang);
		/*try {
			super.executeUpdate("delete from test_question_lang where id=?", id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}*/
	}
	
	@Override
	public void deletecr(Integer id) throws ServiceException {
		TestQuestionLang lang = new TestQuestionLang();
		lang.setId(id);
		super.executeUpdate("delete from test_question_lang_cr where id=?", id);
		/*try {
			super.executeUpdate("delete from test_question_lang where id=?", id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}*/
	}
	
	@Override
	public TestQuestionLang get(Integer id) throws ServiceException {
		return (TestQuestionLang) super.get(id, TestQuestionLang.class);
		/*try {
			List<Map<String, Object>> datas = super.executeQuery("select * from test_question_lang where id=?", id);
			System.out.println(datas.size());
			if (datas.size() == 0) {
				return new TestQuestionLang();
			} else {
				return (TestQuestionLang) this.pack(datas).get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}*/
	}
	@Override
	public TestQuestionLang getcr(Integer id) throws ServiceException {
		try {
			List<Map<String, Object>> datas = super.executeQuery("select * from test_question_lang_cr where id=?", id);
			if (datas.size() == 0) {
				return new TestQuestionLang();
			} else {
				return (TestQuestionLang) this.pack(datas).get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public void update(TestQuestionLang testQuestionLang)
			throws ServiceException {
		String query = "update test_question_lang set kinds=?,question_text=? where id=?";
		super.executeUpdate(query, testQuestionLang.getKinds(),testQuestionLang.getQuestion_text(),testQuestionLang.getId());
	}
	@Override
	public void updatecr(TestQuestionLang testQuestionLang)
			throws ServiceException {
		String query = "update test_question_lang_cr set kinds=?,question_text=? where id=?";
		super.executeUpdate(query, testQuestionLang.getKinds(),testQuestionLang.getQuestion_text(),testQuestionLang.getId());
	}

	@Override
	public List<TestQuestionLang> questionlistquery(String pama) {
		String query = "select * from test_question_lang where kinds=?";
		List<Map<String, Object>> datas = super.executeQuery(query, pama);
		if (datas.size() == 0) {
			return new ArrayList<TestQuestionLang>();
		} else {
			List<TestQuestionLang> l=new ArrayList<TestQuestionLang>();
			for(int i = 0 ; i < datas.size() ; i++){
				l.add((TestQuestionLang)this.pack(datas).get(i));
			}
			return l ;
		}
	}
	
	public TestQuestionLang questiondata(String kinds,String pagestart,String pagesize){
		String query = "select * from test_question_lang where kinds=? limit ?,?";
		List<Map<String, Object>> datas = super.executeQuery(query,kinds,pagestart,pagesize);
		if (datas.size() == 0) {
			return new TestQuestionLang();
		} else {
			List<TestQuestionLang> l=new ArrayList<TestQuestionLang>();
				l.add((TestQuestionLang)this.pack(datas).get(0));
				
			return l.get(0) ;
		}
	}

	@Override
	public TestQuestionLangSearch list(TestQuestionLangSearch search,String pagestart,String pagesize)
			throws ServiceException {
		String query = " select * ";
		
		//条件语句
		String where = " from test_question_lang where 1 ";
		
//		如果这里有条件，则where += " and xxx = xxxx";
		if (search.getKinds() != null) {
			where += " and kinds = " + search.getKinds();
		}
		//排序
		String order = " order by id asc ";
		search.setQuery(query);
		search.setWhere(where);
		search.setOrder(order);
		search.setPage(Integer.parseInt(pagestart));
		search.setPageSize(Integer.parseInt(pagesize));
		//调用super.queryBySearch之后会重置query、where、order、param参数
		return (TestQuestionLangSearch) super.queryBySearch(search);
	}
	@Override
	public TestQuestionLangSearch listcr(TestQuestionLangSearch search,String pagestart,String pagesize)
			throws ServiceException {
		String query = " select * ";
		
		//条件语句
		String where = " from test_question_lang_cr where 1 ";
		
//		如果这里有条件，则where += " and xxx = xxxx";
		if (search.getKinds() != null) {
			where += " and kinds = " + search.getKinds();
		}
		//排序
		String order = " order by id asc ";
		search.setQuery(query);
		search.setWhere(where);
		search.setOrder(order);
		search.setPage(Integer.parseInt(pagestart));
		search.setPageSize(Integer.parseInt(pagesize));
		//调用super.queryBySearch之后会重置query、where、order、param参数
		return (TestQuestionLangSearch) super.queryBySearch(search);
	}
}
