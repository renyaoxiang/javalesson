package com.novelbio.javalesson.lesson;

public class Lesson9 {
	public static class TestClass {
		/*
		 * Step 1.1
		 */
		int i = 0;

		/*
		 * Step 2
		 */
		public TestClass() {
			/*
			 * Step 2.1
			 */
			super();
		}

		public void init(int i) {
			/*
			 * Step 3.1
			 */
			this.i = i;
		}

		public void run() {
			/*
			 * Step 4.1
			 */
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		/**
		 * 创建对象步骤
		 */
		/*
		 * Step 1
		 */
		TestClass test = new TestClass();
		/*
		 * Step 3
		 */
		test.init(10);
		/*
		 * Step 4
		 */
		test.run();

		/**
		 * 对象比较
		 */
		TestClass test1 = test;
		TestClass test2 = new TestClass();
		if (test == test1) {
			System.out.println("test == test1");
		}
		if (test2 == test1) {
			System.out.println("test == test1");
		} else {
			System.out.println("test != test1");
		}
		if (test1.i == test2.i) {
			System.out.println("true");
		}

	}
}
