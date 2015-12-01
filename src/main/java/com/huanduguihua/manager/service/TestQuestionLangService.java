package com.huanduguihua.manager.service;

import java.util.List;

import com.huanduguihua.manager.bean.TestQuestionLang;
import com.huanduguihua.manager.bean.search.TestQuestionLangSearch;
import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.DefaultService;

public interface TestQuestionLangService extends DefaultService{
	
	public void save(TestQuestionLang testQuestionLang);
	public void savecr(TestQuestionLang testQuestionLang);
	public Integer getTableId(String table);

	public List<TestQuestionLang> questionlist();
	
	public List<TestQuestionLang> questionlistquery(String pama);
	
	public TestQuestionLang questiondata(String kinds,String pagestart,String pagesize);
	
	public void delete(Integer id) throws ServiceException;
	public void deletecr(Integer id) throws ServiceException;
	/**
	 * 查询一条数据
	 */
	public TestQuestionLang get(Integer id) throws ServiceException;
	public TestQuestionLang getcr(Integer id) throws ServiceException;
	/**
	 * 更新问题
	 */
	public void update(TestQuestionLang testQuestionLang) throws ServiceException;
	public void updatecr(TestQuestionLang testQuestionLang) throws ServiceException;
	
	public TestQuestionLangSearch list(TestQuestionLangSearch search,String pagestart,String pagesize) throws ServiceException;
	public TestQuestionLangSearch listcr(TestQuestionLangSearch search,String pagestart,String pagesize) throws ServiceException;
}