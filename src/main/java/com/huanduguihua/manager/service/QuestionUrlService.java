package com.huanduguihua.manager.service;

import java.util.List;

import com.huanduguihua.manager.bean.QuestionUrl;
import com.huanduguihua.system.service.DefaultService;

public interface QuestionUrlService extends DefaultService{

	public List<QuestionUrl> list();
	public QuestionUrl getquestionurl(Integer val);
	public QuestionUrl get(Integer id);
	
	/**
	 * 通过url查询
	 */
	public QuestionUrl getQeurl(String val);
}
