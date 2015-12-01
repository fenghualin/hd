package com.huanduguihua.manager.service;

import java.util.List;

import com.huanduguihua.green.question3.bean.search.TestOperationbSearch;
import com.huanduguihua.manager.bean.TestQuestionLang2;
import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.DefaultService;

public interface TestQuestionLangService2 extends DefaultService{

	public List<TestQuestionLang2> questionlist();
	
	public void delete(Integer id) throws ServiceException;
	public void deletecr(Integer id) throws ServiceException;
	
	public Integer getTableId(String table);
	
	public void save(TestQuestionLang2 testQuestionLang2);
	public void savecr(TestQuestionLang2 testQuestionLang2);
	
	public TestQuestionLang2 get(Integer id) throws ServiceException;
	public TestQuestionLang2 getcr(Integer id) throws ServiceException;
	
	public TestOperationbSearch list(TestOperationbSearch langSearch,Integer pagestart,Integer pagesize)
			throws ServiceException;
	public TestOperationbSearch listcr(TestOperationbSearch langSearch,Integer pagestart,Integer pagesize)
			throws ServiceException;
	
	/**
	 * 更新问题
	 */
	public void updatecr(TestQuestionLang2 testQuestionLang2) throws ServiceException;
}
