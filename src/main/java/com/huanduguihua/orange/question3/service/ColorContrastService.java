package com.huanduguihua.orange.question3.service;

import java.util.List;

import com.huanduguihua.orange.question3.bean.ColorContrast;
import com.huanduguihua.system.service.DefaultService;

public interface ColorContrastService extends DefaultService{

	public void save(ColorContrast colorContrast);
	
	public List<ColorContrast> list(String sql, String uid, String kinds);
}
