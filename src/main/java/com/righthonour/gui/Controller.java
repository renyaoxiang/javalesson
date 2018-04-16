package com.righthonour.gui;

import java.awt.BorderLayout;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.function.Consumer;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class Controller {
	Consumer<Void> startBackendCallback;
	Consumer<Void> stopBackendCallback;
	Context context;

	public Controller(Context context) {
		this.context = context;
	}

	public void initFram() {
		AppFrame appFrame = context.getAppFrame();
		appFrame.setTitle("科研数据管理系统");
		appFrame.setResizable(false);
		context.getStart().setEnabled(true);
		context.getStop().setEnabled(false);
		context.getMessage().setEditable(false);
		context.getMessage().setVisible(false);
		appFrame.setLayout(new BoxLayout(appFrame.getContentPane(), BoxLayout.Y_AXIS));
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
		JPanel messagePanel = new JPanel();
		messagePanel.setLayout(new BorderLayout());
		appFrame.add(buttonsPanel);
		appFrame.add(messagePanel);
		buttonsPanel.add(context.getStart());
		buttonsPanel.add(context.getStop());
		buttonsPanel.add(context.getExit());
		messagePanel.add(context.getMessage(), BorderLayout.CENTER);
		appFrame.pack();
		appFrame.setDefaultCloseOperation(AppFrame.EXIT_ON_CLOSE);
		appFrame.setSize(300, 100);
		appFrame.setLocationRelativeTo(null);
	}

	public void exit() {
		context.getExit().setEnabled(false);
		SwingUtilities.invokeLater(() -> {
			this.stop();
			System.exit(0);
		});
	}

	public void start() {
		context.getStart().setEnabled(false);
		context.getMessage().setVisible(true);
		context.getMessage().setText("启动中...");
		SwingUtilities.invokeLater(() -> {
			startBackend();
			String ip;
			try {
				ip = InetAddress.getLocalHost().getHostAddress();
			} catch (UnknownHostException e) {
				ip = "127.0.0.1";
			}
			context.setIp(ip);
			context.getStop().setEnabled(true);
		});
	}

	public void stop() {
		context.getStop().setEnabled(false);
		context.getMessage().setVisible(false);
		SwingUtilities.invokeLater(() -> {
			stopBackend();
			context.getStart().setEnabled(true);
		});

	}

	private void startBackend() {
		if (this.startBackendCallback != null) {
			this.startBackendCallback.accept(null);
		}
	}

	private void stopBackend() {
		if (this.stopBackendCallback != null) {
			this.stopBackendCallback.accept(null);
		}
	}

	public void setStartBackendCallback(Consumer<Void> startBackendCallback) {
		this.startBackendCallback = startBackendCallback;
	}

	public void setStopBackendCallback(Consumer<Void> stopBackendCallback) {
		this.stopBackendCallback = stopBackendCallback;
	}

	public void setPort(String port) {
		SwingUtilities.invokeLater(() -> {
			context.setPort(port);
			updateMessage();
		});
	}

	public void updateMessage() {
		context.getMessage().setText("请使用浏览器打开: http://" + context.getIp() + ":" + context.getPort());
	}
}