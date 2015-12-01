//======================================================================
//
//        Copyright (C) 2013-2014 成都酷信科技有限公司
//        All rights reserved
//
//        文件名 ：test.myjdbc.TestDatExport.java
//
//        创建时间：2014-6-20-下午2:48:09
//		      作者：康佳
//        http://www.cdkuxin.com
//
//======================================================================
package test.myjdbc;

import java.util.ArrayList;
import java.util.List;

import com.huanduguihua.system.dat.Generate;
import com.huanduguihua.system.dat.UserData;

/**
 * 名称：
 * 功能：
 * 
 * @author 康佳
 * @version 1.0.0
 * 
 */
public class TestDatExport {

	public static void main(String[] args) {
		Generate gen = new Generate();
		UserData data = new UserData();
		data.ID = "100292";
		data.Name = "陈欣悦";
		data.Age = "19";
		data.Nation = "汉族";
		data.Nationality = "中华人民共和国";
		data.Vision = "正常";
		data.Sex = "女";
		data.Blood = "A";
		data.Birthday = "未知";
		data.School = "浙江省富阳中学";
		data.StudentType = "高中";
		data.Grade = "高三毕业";
		data.CClass = "9";
		data.Ability = "无";
		data.Interest = "无";
		data.FatherAge = "44";
		data.MotherAge = "42";
		data.FatherWork = "无";
		data.MotherWork = "普通职工";
		data.FatherIncome = "0-2000";
		data.MotherIncome = "2000-5000";
		data.FatherAntecedents = "小学";
		data.MotherAntecedents = "初中";
		data.Telephone = "15988125712";
		data.Email = "1224429743@qq.com";
		data.Home = "富阳市新登镇东安路";
		List<Boolean> visited = new ArrayList<Boolean>();
		visited.add(true);
		visited.add(true);
		visited.add(true);
		gen.generate("D:/100292.txt", "D:/100292.dat", 34, data,visited);
	}
}
