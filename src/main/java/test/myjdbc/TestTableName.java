/**
 * test.myjdbc
 * TestTableName.java
 * 
 * 2014-5-15-上午11:20:56
 *  2014成都酷信科技公司-版权所有
 * 
 */
package test.myjdbc;

import java.sql.Timestamp;

import com.huanduguihua.system.bean.DefaultBean;
import com.huanduguihua.user.bean.User;

/**
 * 
 * TestTableName
 * 
 * kin
 * kin
 * 2014-5-15 上午11:20:56
 * 
 * @author KangJia
 * @version 1.0.0
 * 
 */
public class TestTableName {
	public static void main(String[] args) {
		User bean = new User();
		
		show(bean);
		try {
			System.out.println(TestTableName.class.getMethod("test").getReturnType().getName());
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		System.out.println(Integer.class.getName());
		System.out.println(Double.class.getName());
		System.out.println(Float.class.getName());
		System.out.println(String.class.getName());
		System.out.println(Boolean.class.getName());
		System.out.println(Timestamp.class.getName());
	}
	public static void show(DefaultBean bean) {
		System.out.println(bean.__getMyjdbcTableName());
	}
	public static Integer test() {
		return 1;
	}
}
