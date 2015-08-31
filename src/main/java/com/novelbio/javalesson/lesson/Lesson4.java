package com.novelbio.javalesson.lesson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class Lesson4 {

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
		double doubleValue = 100D;
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
	}
}
