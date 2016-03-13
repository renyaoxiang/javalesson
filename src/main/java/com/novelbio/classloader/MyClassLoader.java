/**
 * 
 */
package com.novelbio.classloader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 
 * 
 * @author renyx
 * @date 2016年1月28日
 * 
 */
public class MyClassLoader extends ClassLoader {
	private String jarPath;

	public MyClassLoader(String jarPath) {
		super();
		this.jarPath = jarPath;
	}

	public static void main(String[] args) {
		try {
			Class<?> main = new MyClassLoader("").findClass(null);
			Method[] methods = main.getMethods();
			for (Method method : methods) {
				if (StringUtils.equals("test", method.getName())) {
					method.invoke(null);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] data = loaderClassData(name);
		return this.defineClass(name, data, 0, data.length);
	}

	/**
	 * @param name
	 * @return
	 */
	private byte[] loaderClassData(String name) {
		byte[] data = null;
		try {
			data = FileUtils.readFileToByteArray(new File("/home/novelbio/Main.class"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}

}
