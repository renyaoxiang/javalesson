/**
 * 
 */
package com.novelbio.server.service;

import java.util.List;

/**
 * 
 * 
 * @author renyx
 * @date 2016年2月4日
 * 
 */
public class Service implements Runnable, IService {

	List<Long> list1;
	List<Long> list2;

	/**
	 * @param asList
	 * @param asList2
	 */
	public Service(List<Long> asList, List<Long> asList2) {
		list1 = asList;
		list2 = asList2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			doService();
		} catch (Throwable e) {
			System.err.println(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.novelbio.server.service.IService#doService(java.util.List,
	 * java.util.List)
	 */
	@Override
	public void doService() {
		// TODO Auto-generated method stub
		System.out.println(list1.toString() + ":" + list2.toString());
	}

}
