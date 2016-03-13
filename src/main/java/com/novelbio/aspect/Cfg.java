/**
 * 
 */
package com.novelbio.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 
 * 
 * @author renyx
 * @date 2016年2月4日
 * 
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses = Cfg.class)
public class Cfg {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Cfg.class);
		ctx.getBean(TestBean.class).print();
		ctx.getBean(AspectObject.class).print();
	}
}
