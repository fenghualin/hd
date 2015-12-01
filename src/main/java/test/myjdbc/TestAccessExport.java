//======================================================================
//
//        Copyright (C) 2013-2014 成都酷信科技有限公司
//        All rights reserved
//
//        文件名 ：test.myjdbc.TestAccessExport.java
//
//        创建时间：2014-6-16-下午3:01:39
//		      作者：康佳
//        http://www.cdkuxin.com
//
//======================================================================
package test.myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.huanduguihua.system.util.AccessUtil;
import com.huanduguihua.system.util.DBAccess;
import com.huanduguihua.user.bean.User;

/**
 * 名称： 功能：
 * 
 * @author 康佳
 * @version 1.0.0
 * 
 */
public class TestAccessExport {

	public static void main(String[] args) throws Exception {
		User user = new User();
		AccessUtil.getInstance().generateAccess(user, "D:/1.mdb", "D:/1.dat");
		//testAccess4();
//		 testAccess4();
		// ConnectAccessDataSource();  
	}

//	private static void testAccess1() {
//		try {
//			AccessUtil access = AccessUtil.getInstance();
//			// 打开连接
//			access.connetAccessDB();
//
//			access.executeSql("update Tester set Age = Age + 1");
//			access.closeConnection();
//
//			access.copyBlankMdbFile();
//
//			access.deleteOldMdbFile();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

	private static void testAccess2() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (Exception e) {
		}
		try {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rst = null;
			conn = DriverManager.getConnection("jdbc:odbc:BooksDB");
			stmt = conn.createStatement();
			rst = stmt
					.executeQuery("create table Test(id int,name varchar(32))");
		} catch (Exception e1) {
		}
	}

	private static void testAccess3() {
		try {
			// String str =
			// "[Microsoft][ODBC Microsoft Access ?????] ?Ҳ????ļ? '(δ֪??)'??";
			// System.out.println(new String(str.getBytes("utf-8")));
			// str =
			// "[Microsoft][ODBC Microsoft Access ?????] ???ܴ???ݿ? '(δ֪??)'??Ӧ?ó???????޷?ʶ?????ݿ⣬???ļ??????𻵡?";
			// str = new String(str.getBytes("utf-8"));

			// System.out.println(str);
			System.exit(0);
			DBAccess db = new DBAccess();
			String dbPath = "D:/blank.mdb";
			String query = "create table Test(id int,name varchar(32))";
			String password = "";
			Statement stmt = db.getStatement(dbPath, password);
			db.executeUpdate(stmt, query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	private static void testAccess4() {
//		try {
//			//java访问ACCESS数据库位置
//			String url = "jdbc:odbc:Driver={MicroSoft Access Driver (*.mdb)};DBQ=D:\\demo.mdb";
//			//执行用SQL
//			String sql_Select="insert into Tester(ID,UserID) values(1,2011101)";
//			//java访问ACCESS数据库的驱动程序
//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//			// 连接ACCESS数据库
//			Connection dbConn = DriverManager.getConnection(url, "", "");
//			// 创建执行SQL的环境
//			Statement stmt_Select = dbConn.createStatement();
//			// 执行SQL
//			//ResultSet rs_Select = stmt_Select.executeQuery(sql_Select);
//			stmt_Select.executeUpdate(sql_Select);
//			// 显示数据
//			
//			stmt_Select.close(); // 关闭Statement   
//			dbConn.close(); // 关闭Connection  
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

    public static void ConnectAccessFile() throws Exception   
    {  
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
        /** 
         * 直接连接access文件。 
         */  
        String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=d://demo.mdb";  
        Connection conn = DriverManager.getConnection(dbur1, "", "");  
        Statement stmt = conn.createStatement();  
        ResultSet rs = stmt.executeQuery("select * from Tester");  
        while (rs.next()) {  
            System.out.println(rs.getString(1));  
        }  
        rs.close();  
        stmt.close();  
        conn.close();  
    }  
    public static void ConnectAccessDataSource()throws Exception {  
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
        
        String dbur1 = "jdbc:odbc:demo";// 此为ODBC连接方式  
        Connection conn = DriverManager.getConnection(dbur1, "", "");  
        Statement stmt = conn.createStatement();  
         stmt.executeUpdate("update Tester set Age  = 18") ; 
//        while (rs.next()) {  
//            System.out.println(rs.getString(1));  
//        }  
//        rs.close();  
        stmt.close();  
        conn.close();  
    }  
}
