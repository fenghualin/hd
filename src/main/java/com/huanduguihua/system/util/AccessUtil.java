//======================================================================
//
//        Copyright (C) 2013-2014 成都酷信科技有限公司
//        All rights reserved
//
//        文件名 ：com.huanduguihua.system.util.AccessUtil.java
//
//        创建时间：2014-6-16-下午3:03:10
//		      作者：康佳
//        http://www.cdkuxin.com
//
//======================================================================
package com.huanduguihua.system.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import com.huanduguihua.user.bean.User;

/**
 * 名称： 功能：
 * 
 * @author 康佳
 * @version 1.0.0
 * 
 */
public class AccessUtil {
	private Connection connection;
	private PreparedStatement statement;
	
	// 标准的单件模式
	private static AccessUtil instance = new AccessUtil();

	private AccessUtil() {
		
	}
	public static AccessUtil getInstance() {
		return instance;
	}
	private void executeUpdate(String url, String sql, InputStream input) {
		try {
			//String url = "jdbc:odbc:Driver={MicroSoft Access Driver (*.mdb)};DBQ=D:\\demo.mdb";
			//String sql_Select="insert into Tester(ID,UserId) values(1,2011101)";
			
			//java访问ACCESS数据库的驱动程序
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			//java访问ACCESS数据库位置
			
			// 连接ACCESS数据库
			connection = DriverManager.getConnection(url, "", "");
			// 创建执行SQL的环境
			//statement = connection.createStatement();
			// 执行SQL
			//ResultSet rs_Select = stmt_Select.executeQuery(sql_Select);
			//statement.executeUpdate(sql);
			// 显示数据
			statement = connection.prepareStatement(sql);
			if (input != null) {
	           // byte[] data = new byte[] {};
	            //data = inputStreamToByte(input);//将文件保存到字节数组中 
			statement.setBinaryStream(1, input, input.available());
	         //  statement.setBytes(1, data);
			    //statement.setBinaryStream(1, input);
			    //statement.setBlob(1, input,input.available());
			}
			statement.executeUpdate();
			statement.close(); // 关闭Statement   
			connection.close(); // 关闭Connection  
			if (input != null) {
			    input.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 生成一个access文件到指定的文件
	 * @param user	用户对象
	 * @param file	生成到哪里
	 */
	public void generateAccess(User user, String file, String datFile) {
		try {
			String url = "jdbc:odbc:huandu";
			//复制db文件
			//copyFile(AccessUtil.class.getClassLoader().getResource("demo.mdb").getPath(), file);
			//copyFile("D:/demo.mdb", file);
			//连接Access
			//删除旧数据
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			executeUpdate(url, "delete from Tester", null);
			String sql = "insert into Tester(UserID,Pwd,Name,Age,Nation,Nationality,Sex,Vision,Blood,"+
							"`Date`,School,StudentType,Grade,Class,Ability,Interest,FatherAge,MotherAge,FatherWork,"+
							"MotherWork,FatherIncome,MotherIncome,FatherAntecedents,MotherAntecedents,Tel,Email,"+"" +
							"Address, `Data`) values('"+user.getUsername()+"','"+user.getPassword()+"','"+
							user.getName()+"','"+user.getNianling()+"','"+user.getMinzu()+"','中华人民共和国','"+user.getXingbie()+"','"+
							user.getShili()+"','"+user.getXiexing()+"','"+formatter.format(user.getCreateTime())+"','"+user.getSchool()+"','"+
							user.getXueshengleixing()+"','"+user.getNianji()+"','"+user.getBanji()+"','无','"+user.getTechang()+"','"+
							user.getFuqinnianling()+"','"+user.getMuqinnianling()+"','"+user.getFuqinzhiye()+"','"+user.getMuqinzhiye()+"','"+
							user.getFuqinshouru()+"','"+user.getMuqinshouru()+"','"+user.getFuqinwenhuachengdu()+"','"+
							user.getMuqinwenhuachengdu()+"','"+user.getYidongdianhua()+"','"+user.getEmail()+"','"+user.getDizhi()+"', ?)";
			
//			String sql = "update Tester set UserID='"+user.getUsername()+"',Pwd='"+user.getPassword()+"',Name='"+user.getName()+"',Age='"+user.getNianling()+
//					"',Nation='"+user.getMinzu()+"',Nationality='中华人民共和国',Sex='"+user.getXingbie()+"',Vision='"+user.getShili()+"',Blood='"+user.getXiexing()+"',"+
//					"`Date`='"+user.getCreateTime()+"',School='"+user.getSchool()+"',StudentType='"+user.getXueshengleixing()+"',Grade='"+user.getNianji()+
//					"',Class='"+user.getBanji()+"',Ability='无',Interest='"+user.getTechang()+"',FatherAge='"+user.getFuqinnianling()+"',MotherAge='"+user.getMuqinnianling()+
//					"',FatherWork='"+user.getFuqinzhiye()+"',"+"MotherWork='"+user.getMuqinzhiye()+"',FatherIncome='"+user.getFuqinshouru()+"',MotherIncome='"+user.getMuqinshouru()+
//					"',FatherAntecedents='"+user.getFuqinwenhuachengdu()+"',MotherAntecedents='"+user.getMuqinwenhuachengdu()+"',Tel='"+user.getYidongdianhua()+"',Email='"+
//					user.getEmail()+"',Address='"+user.getDizhi()+"'";
//			String url = "jdbc:odbc:Driver={MicroSoft Access Driver (*.mdb)};DBQ=D:\\demo.mdb";
			System.out.println("sql: " + sql);
			
//		        String dbur1 = "jdbc:odbc:demo";// 此为ODBC连接方式  
//		        Connection conn = DriverManager.getConnection(dbur1, "", "");  
//		        Statement stmt = conn.createStatement();  
//		        ResultSet rs = stmt.executeQuery("select * from Tester");  
//		        while (rs.next()) {  
//		            System.out.println(rs.getString(1));  
//		        }  
//		        rs.close();  
//		        stmt.close();  
//		        conn.close();  
			 datFile = datFile.replace(".dat", "_fix.dat");
//			  DataInputStream in=new DataInputStream(  
//                      new BufferedInputStream(  
//                      new FileInputStream(datFile)));   
			  
			executeUpdate(url, sql, new FileInputStream(datFile));
			//拷贝文件
			copyFile("D:/huandu.mdb", file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	   /**
     * 生成一个access文件到指定的文件 单项
     * @param user  用户对象
     * @param file  生成到哪里
     */
    public void generateAccessDanxiang(User user, String file, String datFile) {
        try {
            String url = "jdbc:odbc:huandudanxiang";
            //复制db文件
            //copyFile(AccessUtil.class.getClassLoader().getResource("demo.mdb").getPath(), file);
            //copyFile("D:/demo.mdb", file);
            //连接Access
            //删除旧数据
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            executeUpdate(url, "delete from Tester", null);
            String sql = "insert into Tester(UserID,Name,Age,Nation,Nationality,Sex,Vision,Blood,"+
                            "`Birthday`,School,StudentType,Grade,Class,Ability,Interest,FatherAge,MotherAge,FatherWork,"+
                            "MotherWork,FatherIncome,MotherIncome,FatherAntecedents,MotherAntecedents,Telephone,Email,"+"" +
                            "Home,SystemVersion,`Date`, `Data`) values('"+user.getUsername()+"','"+
                            user.getName()+"','"+user.getNianling()+"','"+user.getMinzu()+"','中华人民共和国','"+user.getXingbie()+"','"+
                            user.getShili()+"','"+user.getXiexing()+"','','"+user.getSchool()+"','"+
                            user.getXueshengleixing()+"','"+user.getNianji()+"','"+user.getBanji()+"','无','"+user.getTechang()+"','"+
                            user.getFuqinnianling()+"','"+user.getMuqinnianling()+"','"+user.getFuqinzhiye()+"','"+user.getMuqinzhiye()+"','"+
                            user.getFuqinshouru()+"','"+user.getMuqinshouru()+"','"+user.getFuqinwenhuachengdu()+"','"+
                            user.getMuqinwenhuachengdu()+"','"+user.getYidongdianhua()+"','"+user.getEmail()+"','"+user.getDizhi()+"','MemoryTestII','"+formatter.format(user.getCreateTime())+"', ?)";
            
//          String sql = "update Tester set UserID='"+user.getUsername()+"',Pwd='"+user.getPassword()+"',Name='"+user.getName()+"',Age='"+user.getNianling()+
//                  "',Nation='"+user.getMinzu()+"',Nationality='中华人民共和国',Sex='"+user.getXingbie()+"',Vision='"+user.getShili()+"',Blood='"+user.getXiexing()+"',"+
//                  "`Date`='"+user.getCreateTime()+"',School='"+user.getSchool()+"',StudentType='"+user.getXueshengleixing()+"',Grade='"+user.getNianji()+
//                  "',Class='"+user.getBanji()+"',Ability='无',Interest='"+user.getTechang()+"',FatherAge='"+user.getFuqinnianling()+"',MotherAge='"+user.getMuqinnianling()+
//                  "',FatherWork='"+user.getFuqinzhiye()+"',"+"MotherWork='"+user.getMuqinzhiye()+"',FatherIncome='"+user.getFuqinshouru()+"',MotherIncome='"+user.getMuqinshouru()+
//                  "',FatherAntecedents='"+user.getFuqinwenhuachengdu()+"',MotherAntecedents='"+user.getMuqinwenhuachengdu()+"',Tel='"+user.getYidongdianhua()+"',Email='"+
//                  user.getEmail()+"',Address='"+user.getDizhi()+"'";
//          String url = "jdbc:odbc:Driver={MicroSoft Access Driver (*.mdb)};DBQ=D:\\demo.mdb";
            System.out.println("sql: " + sql);
            
//              String dbur1 = "jdbc:odbc:demo";// 此为ODBC连接方式  
//              Connection conn = DriverManager.getConnection(dbur1, "", "");  
//              Statement stmt = conn.createStatement();  
//              ResultSet rs = stmt.executeQuery("select * from Tester");  
//              while (rs.next()) {  
//                  System.out.println(rs.getString(1));  
//              }  
//              rs.close();  
//              stmt.close();  
//              conn.close();  
             datFile = datFile.replace(".dat", "_fix.dat");
//            DataInputStream in=new DataInputStream(  
//                      new BufferedInputStream(  
//                      new FileInputStream(datFile)));   
              
            executeUpdate(url, sql, new FileInputStream(datFile));
            //拷贝文件
            copyFile("D:/huandudanxiang.mdb", file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	//将文件保存到字节数组中
    private byte [] inputStreamToByte(InputStream is) throws IOException {
        DataInputStream dis = new DataInputStream(is);
        ByteArrayOutputStream bAOutputStream = new ByteArrayOutputStream();
        int ch;
        for(int i=0;i<26;i++){
            dis.readByte();
            dis.readByte();
            dis.readByte();
            dis.readByte();
            dis.readByte();
            dis.readByte();
            dis.readByte();
            dis.readByte();
        }
        while((ch = dis.read() ) != -1){
            bAOutputStream.write(ch);
        }
        byte data [] =bAOutputStream.toByteArray();
        bAOutputStream.close();
        return data;
    } 
	private void copyFile(String from, String to) {
		try {
			InputStream input = new FileInputStream(from);
			OutputStream output = new FileOutputStream(to);
			byte[] buff = new byte[1024];
			int len = -1;
			while ( (len=input.read(buff)) != -1 ) {
				output.write(buff, 0, len);
			}
			output.flush();
			output.close();
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}