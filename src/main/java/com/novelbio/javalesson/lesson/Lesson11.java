/**
 * 
 */
package com.novelbio.javalesson.lesson;

/**
 * 
 * 该方法说明面向对象的概念
 * 
 * @author renyx
 *
 */
public class Lesson11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestBean testBean = new TestBean();
		testBean.eatSundae();
		testBean.work();
		System.out.println("===========");
		TestBean errorBean = new TestBean();
		errorBean.work();
	}

}

/**
 * 面向对象的设计，可以理解为：通过某种状态(对象的属性)来控制方法实际操作。
 * 
 * 
 * @author renyx
 *
 */
class TestBean {
	private boolean wantEatSundae = true;

	public void eatSundae() {
		System.out.println("eat Sundae");
		wantEatSundae = false;
	}

	public void work() {
		if (!wantEatSundae) {
			System.out.println("work");
		} else {
			throw new RuntimeException("我饿了，我要吃圣代");
		}
	}
}
