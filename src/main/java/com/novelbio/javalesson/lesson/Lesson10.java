/**
 * 
 */
package com.novelbio.javalesson.lesson;

/**
 * 主要介绍值传递
 * 
 * @author renyx
 *
 */
public class Lesson10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		swapInitScript();
		System.out.println("==========================");
		swapObjectIntScript1();
		System.out.println("==========================");
		swapObjectIntScript2();

	}

	/**
	 * 
	 */
	private static void swapObjectIntScript1() {
		ObjectInt left = new ObjectInt(), right = new ObjectInt();
		left.setValue(1);
		right.setValue(2);
		System.out.print(String.format("Outer:left is %s and right is %s\n", left, right));
		System.out.print(String.format("Outer:left is %d and right is %d\n", left.getValue(), right.getValue()));
		/**
		 * 内部方法可修改对象内部的属性值
		 */
		swapObjectInt1(left, right);
		System.out.print(String.format("Outer:left is %s and right is %s\n", left, right));
		System.out.print(String.format("Outer:left is %d and right is %d\n", left.getValue(), right.getValue()));
	}

	/**
	 * 
	 */
	private static void swapObjectIntScript2() {
		ObjectInt left = new ObjectInt(), right = new ObjectInt();
		left.setValue(1);
		right.setValue(2);
		System.out.print(String.format("Outer:left is %s and right is %s\n", left, right));
		System.out.print(String.format("Outer:left is %d and right is %d\n", left.getValue(), right.getValue()));
		/**
		 * 内部方法不可修改对象本身
		 */
		swapObjectInt2(left, right);
		System.out.print(String.format("Outer:left is %s and right is %s\n", left, right));
		System.out.print(String.format("Outer:left is %d and right is %d\n", left.getValue(), right.getValue()));
	}

	/**
	 * @param left
	 * @param right
	 */
	private static void swapObjectInt1(ObjectInt left, ObjectInt right) {
		System.out.print(String.format("inner: left is %s and right is %s\n", left, right));
		System.out.print(String.format("inner: left is %d and right is %d\n", left.getValue(), right.getValue()));
		int temp = left.getValue();
		left.setValue(right.getValue());
		right.setValue(temp);
		System.out.print(String.format("inner: left is %s and right is %s\n", left, right));
		System.out.print(String.format("inner: left is %d and right is %d\n", left.getValue(), right.getValue()));
	}

	/**
	 * @param left
	 * @param right
	 */
	private static void swapObjectInt2(ObjectInt left, ObjectInt right) {
		System.out.print(String.format("inner: left is %s and right is %s\n", left, right));
		System.out.print(String.format("inner: left is %d and right is %d\n", left.getValue(), right.getValue()));
		ObjectInt temp = left;
		left = right;
		right = temp;
		System.out.print(String.format("inner: left is %s and right is %s\n", left, right));
		System.out.print(String.format("inner: left is %d and right is %d\n", left.getValue(), right.getValue()));
	}

	private static void swapInitScript() {
		int left = 1, right = 2;
		System.out.print(String.format("Outer:left is %d and right is %d\n", left, right));
		/**
		 * 内部方法无法修改基本类型的值
		 */
		swapInt(left, right);
		System.out.print(String.format("Outer:left is %d and right is %d\n", left, right));

	}

	private static void swapInt(int left, int right) {
		System.out.print(String.format("inner:left is %d and right is %d\n", left, right));
		int temp = left;
		left = right;
		right = temp;
		System.out.print(String.format("inner:left is %d and right is %d\n", left, right));
	}

	public static class ObjectInt {
		private int value;

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

	}
}
