package com.novelbio.javalesson.lesson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class Lesson8 {

	/**
	 * <pre>
	 * 我是注释，说明下面的函数的功能
	 * public static void main(String[] args) 
	 * 该方法是个特殊函数，是程序的入口，即计算机识别代码的入口
	 * </pre>
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		/**
		 * 控制台打印文字
		 */
		System.out.println("hello world");
		/**
		 * 控制台打印基本数据类型
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
		double doubleValue = 10.10D;
		System.out.println(doubleValue);
		boolean booleanValue = true;
		System.out.println(booleanValue);
		/*
		 * 基本类型的比较和复制是用的等号（=)
		 */
		byte anotherByteValue = byteValue;
		System.out.println(anotherByteValue);
		System.out.println(byteValue == anotherByteValue);
		/**
		 * String特殊类型
		 */
		String stringValue = "I like SKY";
		System.out.println(stringValue);
		String anotherStringValue = "I like Tade";
		/*
		 * 比较使用的是equals方法
		 */
		System.out.println(stringValue.equals(anotherStringValue));
		/*
		 * 可以使用类库如下,StringUtils类还包括其他方法
		 */
		System.out.println(StringUtils.equals(stringValue, anotherStringValue));

		/**
		 * 3、对象数据类型
		 */
		/*
		 * 所有对象的超类
		 */
		Object test = new Object();
		/**
		 * HashMap、HashSet、ArrayList数据结构，例子网上很多，自己找一下
		 */
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap = Maps.newHashMap();
		HashSet<String> hashSet = new HashSet<>();
		hashSet = Sets.newHashSet("1", "2");
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList = Lists.newArrayList("1", "2");

		/**
		 * 4、接口 Collection、Iterator、Map、Set、List
		 */
		Collection<String> collection = hashSet;
		collection = arrayList;
		for (String strValue : collection) {
			System.out.println(strValue);
		}
		for (Iterator<String> iter = collection.iterator(); iter.hasNext();) {
			String strValue = iter.next();
			System.out.println(strValue);
		}

		/**
		 * 5程序流程
		 */
		try {
			if (StringUtils.equals("Test", "Test")) {
				System.out.println("Test");
			}
			if (!StringUtils.equals("Test", "Test")) {
				System.out.println("Test");
			} else {
				System.out.println("Test");
			}
			switch (1) {
			case 2:
				System.out.println("2");
				break;
			case 1:
				System.out.println("1");
				break;
			default:
				System.out.println("default");
			}
			for (String strValue : collection) {
				System.out.println(strValue);
			}
			throw new Exception("test");
		} catch (Exception e) {
			System.out.print("exception");
		}

		/**
		 * 6、递归
		 */
		recursion(3);
		int[] tree = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		search(tree, 0, 5);
		/*
		 * 图搜索一般不会用到，和树类似，如果用到网上找资料
		 */

		/**
		 * <pre>
		 * 7、java编程手则 
		 * 1、方法功能单一、明确 
		 * 2、学会抛异常
		 * </pre>
		 */
		double result = division(1, 2);

		/**
		 * 8 文件读取 FileUtils、Files
		 */
		try {
			List<String> lines = FileUtils.readLines(null);
			LineIterator iter = FileUtils.lineIterator(null);
			while (iter.hasNext()) {
				String line = iter.next();
			}
		} catch (Exception e) {
		}
	}

	private static double division(int i, int j) {
		if (j == 0) {
			throw new RuntimeException("num2 can not be 0");
		}
		/*
		 * 整数除以整数，结果会忽略小数 *1.0的作用是进行转换
		 */
		System.out.println(i * 1.0 / j);
		return i * 1.0 / j;
	}

	private static void search(int[] tree, int index, int num) {
		if (index > 9) {
			return;
		}
		if (tree[index] == num) {
			System.out.println("find");
		} else {
			System.out.println("not find");
			search(tree, (index + 1) * 2 - 1, num);
			search(tree, (index + 1) * 2, num);
		}
	}

	private static void recursion(int i) {
		System.out.println("before" + i);
		if (i > 0) {
			recursion(i - 1);
		}
		System.out.println("after" + i);
	}

}
