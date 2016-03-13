/**
 * 
 */
package com.novelbio.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @author renyx
 * @date 2016年2月4日
 * 
 */
@Aspect
@Component
public class AspectObject {

	@Autowired
	TestBean testBean;

	@Pointcut("@annotation(com.novelbio.aspect.AspectPoint)")
	private void anyOldTransfer() {
	}

	@AspectPoint
	public void print() {
		System.out.println(789);
	}

	@Before("anyOldTransfer()")
	public void before() {
		System.out.println(123);
	}
}
