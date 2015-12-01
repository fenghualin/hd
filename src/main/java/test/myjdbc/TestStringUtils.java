package test.myjdbc;

import org.apache.commons.lang.StringUtils;

import junit.framework.TestCase;

public class TestStringUtils extends TestCase {

	@org.junit.Test
	public void test() {
		String s = "";
		System.out.println(StringUtils.isEmpty(s));
	}
}
