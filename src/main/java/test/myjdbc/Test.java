//======================================================================
//
//        Copyright (C) 2013-2014 成都酷信科技有限公司
//        All rights reserved
//
//        文件名 ：Test.java
//        功能：TODO
//
//        创建时间：2014-5-15-下午5:40:59
//		      作者：康佳
//        http://www.cdkuxin.com
//
//======================================================================
package test.myjdbc;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import org.springframework.test.context.TestExecutionListeners;

import junit.framework.TestCase;

/**
 * 
 * Test
 * 
 * kin kin 2014-5-15 下午5:40:59
 * 
 * @author KangJia
 * @version 1.0.0
 * 
 */
public class Test extends TestCase {

	public static void main(String[] args) {
		try {
			FileInputStream input = new FileInputStream("C:/1.dat");
			byte[] buff = new byte[128];
			int len = -1;
			StringBuffer stringBuffer = new StringBuffer();
			System.out.println("__________start____________");
			while ((len = input.read(buff)) != -1) {
				// String s = new String();
				for (int i = 0; i < len; i++) {
					Byte b = buff[i];
					System.out.println(b.toString());
				}

				String str = new String(buff, 0, len, "gbk");
				stringBuffer.append(str);
				// return ;
			}
			System.out.println("__________end____________");
			// System.out.println(stringBuffer.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static long getLong(byte[] b, int off) {
		return (((long) b[off] << 56) + ((long) (b[off + 1] & 255) << 48)
				+ ((long) (b[off + 2] & 255) << 40)
				+ ((long) (b[off + 3] & 255) << 32)
				+ ((long) (b[off + 4] & 255) << 24)
				+ ((b[off + 5] & 255) << 16) + ((b[off + 6] & 255) << 8) + ((b[off + 7] & 255) << 0));
	}

	public static double getDouble(byte[] b) {
		return Double.longBitsToDouble(getLong(b, 0));
	}

	@org.junit.Test
	public void test() {
		try {
			InputStream input = new FileInputStream("C:/1.dat");
			DataInput dataInput = new DataInputStream(input);
			String line = null;
			while ((line = dataInput.readLine()) != null) {
				System.out.println(new String(line.getBytes("gbk")));
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
