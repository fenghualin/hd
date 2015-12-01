package com.huanduguihua.orange.question2.service;

import java.util.List;

import com.huanduguihua.orange.question2.bean.ImageInation;
import com.huanduguihua.system.service.DefaultService;

public interface ImageInationService extends DefaultService{

	public void save(ImageInation imageInation);
	
	public List<ImageInation> list(String sql, String uid, String kinds);
}
