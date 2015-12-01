package com.huanduguihua.manager.service;

import java.util.List;

import com.huanduguihua.manager.bean.TestQuestionAnswer2;
import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.DefaultService;

public interface TestQuestionAcswerService2 extends DefaultService{

	public void save(TestQuestionAnswer2 testQuestionAnswer2);
	public void savecr(TestQuestionAnswer2 testQuestionAnswer2);
	
	public List<TestQuestionAnswer2> questionlists(String query);
	
	public void delete(Integer id) throws ServiceException;
	public void deletes(Integer id) throws ServiceException;
	public void deletescr(Integer id) throws ServiceException;
	
	public void update(TestQuestionAnswer2 testQuestionAnswer) throws ServiceException;
	public void updatecr(TestQuestionAnswer2 testQuestionAnswer) throws ServiceException;
	
	public List<TestQuestionAnswer2> getlist(Object pama);
	public List<TestQuestionAnswer2> getlistcr(Object pama);
}
