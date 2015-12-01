package com.huanduguihua.orange.question2.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.orange.question2.bean.ImageInation;
import com.huanduguihua.orange.question2.service.ImageInationService;
import com.huanduguihua.system.exception.service.ServiceException;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;

@Service
public class ImageInationServiceImpl extends DefaultServiceImpl implements ImageInationService{

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, ImageInation.class);
	}

	@Override
	public void save(ImageInation imageInation) {
		try {
			super.update(imageInation);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ImageInation> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<ImageInation> list=new ArrayList<ImageInation>();
			for(int i = 0;i<l.size();i++){
				list.add((ImageInation)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}

	
}
