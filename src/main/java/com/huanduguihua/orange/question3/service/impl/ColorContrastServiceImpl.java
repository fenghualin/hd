package com.huanduguihua.orange.question3.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huanduguihua.orange.question3.bean.ColorContrast;
import com.huanduguihua.orange.question3.service.ColorContrastService;
import com.huanduguihua.system.service.impl.DefaultServiceImpl;

@Service
public class ColorContrastServiceImpl extends DefaultServiceImpl implements ColorContrastService{

	@Override
	public void save(ColorContrast colorContrast) {
		try {
			super.update(colorContrast);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected List<?> pack(List<Map<String, Object>> datas) {
		return super.pack(datas, ColorContrast.class);
	}

	@Override
	public List<ColorContrast> list(String sql, String uid, String kinds) {
		List<Map<String, Object>> l = super.executeQuery(sql, Integer.parseInt(uid));
		if(l.size()>0){
			List<ColorContrast> list=new ArrayList<ColorContrast>();
			for(int i = 0;i<l.size();i++){
				list.add((ColorContrast)this.pack(l).get(i));
			}
			return list;
		}
		return null;
	}

}
