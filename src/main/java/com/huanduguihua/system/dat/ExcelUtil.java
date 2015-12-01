//======================================================================
//
//        Copyright (C) 2013-2014 成都酷信科技有限公司
//        All rights reserved
//
//        文件名 ：com.huanduguihua.system.dat.ExcelUtil.java
//
//        创建时间：2014-6-24-下午4:50:24
//		      作者：康佳
//        http://www.cdkuxin.com
//
//======================================================================
package com.huanduguihua.system.dat;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huanduguihua.system.dat.DocFactory.Excel;
import com.huanduguihua.system.util.HttpHelper;
import com.huanduguihua.system.util.SystemUtils;

/**
 * 名称：
 * 功能：
 * 
 * @author 康佳
 * @version 1.0.0
 * 
 */
public class ExcelUtil {

	/**
	 * 生成一个Excel文件
	 * @param columnName	Excel顶部的中文名称
	 * @param columnMapping	数据源data参数对应的key
	 * @param datas			数据源
	 * @param file			文件生成在哪里
	 */
	public static void generate(List<String> columnName, List<String> columnMapping, List<Map<String, Object>> datas, String file) {
		try {

			Excel excel = DocFactory.createExcel();		//创建excel对象
        	for (int i=0; i<columnName.size(); i++) {
        		excel.addColumn(excel.new Column(columnName.get(i), columnMapping.get(i)));
        	}
        	excel.setDatas(datas);				//设置数据源
			DocFactory.exportExcel(excel, file);	//生成excel文件
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
		List<String> columnNames = new ArrayList<String>();
		columnNames.add("卡号");
		columnNames.add("密码");
		columnNames.add("有效期");
		List<String> columnMappings = new ArrayList<String>();
		columnMappings.add("username");
		columnMappings.add("password");
		columnMappings.add("createTime");
		List<Map<String, Object>> datas = new ArrayList<Map<String,Object>>();
		for (int i=0; i<100; i++) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("username", 20140000 + i);
			data.put("password", SystemUtils.generatePassword());
			data.put("createTime", new Date());
			datas.add(data);
 		}
		ExcelUtil.generate(columnNames, columnMappings, datas, "D:/账号密码.xls");
	}
}
