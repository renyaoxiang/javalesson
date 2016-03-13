/**
 * 
 */
package com.novelbio.aspect;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @author renyx
 * @date 2016年2月4日
 * 
 */
@Component
public class TestBean {
	@AspectPoint
	public void print() {
		System.out.println(789);
	}

	/**
	 * 
	 */
	public void print1() {
		System.out.println(542);

	}
}
