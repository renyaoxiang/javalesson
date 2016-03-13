/**
 * 
 */
package com.novelbio.beans;

import static java.lang.System.out;

import java.beans.Expression;
import java.beans.Statement;

/**
 * 
 * 
 * @author renyx
 * @date 2016年1月27日
 * 
 */
public class Beans {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		testStatement();
		testExpression();
	}

	public static void testStatement() {
		try {
			User user = new User();
			Statement statement = new Statement(user, "setAge", new Object[] { 10 });
			statement.execute();
			out.println(user.getAge());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testExpression() {
		try {
			User user = new User();
			Expression expression = new Expression(user, "compute", new Object[] { 20 });
			expression.execute();
			out.println(expression.getValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/**
 * 
 * Statement和Expression 中无法获得该类的方法
 * 
 * @author renyx
 * @date 2016年1月28日
 *
 */
class Student {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void test() {

	}
}
