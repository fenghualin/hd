package com.huanduguihua.manager.service;

import java.util.List;

import com.huanduguihua.manager.bean.TestQuestionAnswer;
import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.DefaultService;

public interface TestQuestionAcswerService extends DefaultService{
	
	public void save(TestQuestionAnswer testQuestionAnswer);
	public void savecr(TestQuestionAnswer testQuestionAnswer);
	public Integer getTableId(String table);
	public List<TestQuestionAnswer> questionlists(String query);
	public List<TestQuestionAnswer>  getlist(String pama);
	public List<TestQuestionAnswer>  getlistcr(String pama);
	public List<TestQuestionAnswer> questionlist();
	public void delete(Integer id) throws ServiceException;
	/**
	 * 查询一条数据
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public TestQuestionAnswer get(Integer id) throws ServiceException;
	public void deletes(Integer id) throws ServiceException;
	public void deletescr(Integer id) throws ServiceException;
	/**
	 * 更新问题
	 */
	public void update(TestQuestionAnswer testQuestionAnswer) throws ServiceException ;
	public void updatecr(TestQuestionAnswer testQuestionAnswer) throws ServiceException ;

}