/**
 * 
 */
package com.novelbio.server;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.novelbio.server.service.Service;

/**
 * 
 * 
 * @author renyx
 * @date 2016年2月4日
 * 
 */
public class Server implements IServer {
	private ExecutorService executer;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Server server = new Server();
		int i = 0;
		while (i++ < 100000) {
			server.accept(Arrays.asList((long) i), Arrays.asList(System.nanoTime()));
		}
		server.shutdown();
	}

	/**
	 * 
	 */
	private void shutdown() {
		executer.shutdown();
	}

	public Server() {
		executer = Executors.newFixedThreadPool(100);
	}

	/**
	 * @param asList
	 * @param asList2
	 */
	private void accept(List<Long> asList, List<Long> asList2) {

		executer.execute(new Service(asList, asList2));
	}

}
