package com.righthonour.gui;

import javax.swing.JButton;
import javax.swing.JTextPane;

class Context {
	private AppFrame appFrame;
	private JButton start = new JButton("启动");
	private JButton stop = new JButton("关闭");
	private JButton exit = new JButton("退出");
	private JTextPane message = new JTextPane();
	private String port = "";
	private String ip = "";

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public Context(AppFrame appFrame) {
		this.appFrame = appFrame;
	}

	public AppFrame getAppFrame() {
		return appFrame;
	}

	public JButton getStart() {
		return start;
	}

	public JButton getStop() {
		return stop;
	}

	public JButton getExit() {
		return exit;
	}

	public JTextPane getMessage() {
		return message;
	}

}