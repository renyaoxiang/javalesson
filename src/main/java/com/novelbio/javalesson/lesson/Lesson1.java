package com.novelbio.javalesson.lesson;

public class Lesson1 {

	/**
	 * <pre>
	 * 我是注释，说明下面的函数的功能
	 * public static void main(String[] args) 
	 * 该方法是个特殊函数，是程序的入口，即计算机识别代码的入口
	 * </pre>
	 */
	public static void main(String[] args) {
		/**
		 * 控制台打印文字
		 */
		System.out.println("hello world");
		/**
		 * 控制台打印基本数据类型, 
		 */
		/*
		 * byte[-128,127]
		 */
		byte byteValue = 127;
		System.out.println(byteValue);
		char charValue = 'a';
		System.out.println(charValue);
		short shortValue = 100;
		System.out.println(shortValue);
		int intValue = 100;
		System.out.println(intValue);
		float floatValue = 100.12F;
		System.out.println(floatValue);
		long longValue = 100L;
		System.out.println(longValue);
		double doubleValue = 100D;
		System.out.println(doubleValue);
		boolean booleanValue = true;
		System.out.println(booleanValue);
		/**
		 * 基本类型的比较和复制是用的等号（=)
		 */
		byte anotherByteValue = byteValue;
		System.out.println(anotherByteValue);
		System.out.println(byteValue == anotherByteValue);
	}
}
