package com.righthonour.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

/**
 * 主界面
 * 
 * @author renyx
 *
 */
public class AppFrame extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Context context;
	private Controller controller;

	public static void main(String[] args) {
		AppFrame appFrame = new AppFrame();
		appFrame.setStartBackendCallback((e) -> {
			/**
			 * 此处可以优化，将方法 appFrame.setPort 封装到e对象中
			 */
			String port = "123";
			appFrame.setPort(port);
		});
		appFrame.setStopBackendCallback((e) -> {
			System.exit(0);
		});
		appFrame.setVisible(true);
	}

	public AppFrame() {
		/**
		 * 准备数据
		 */
		context = prepareContext();
		/**
		 * 封装控制逻辑
		 */
		controller = prepareController(context);
		/**
		 * 组合业务逻辑
		 */
		prepare(context, controller);
	}

	private void prepare(Context context, Controller controller) {
		controller.initFram();
		context.getStart().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.start();
			}
		});
		context.getStop().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.stop();
			}
		});
		context.getExit().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.exit();
			}
		});
	}

	private Controller prepareController(Context context) {
		return new Controller(context);
	}

	private Context prepareContext() {
		return new Context(this);
	}

	public void setStartBackendCallback(Consumer<Void> startBackendCallback) {
		this.controller.setStartBackendCallback(startBackendCallback);
	}

	public void setStopBackendCallback(Consumer<Void> stopBackendCallback) {
		this.controller.setStopBackendCallback(stopBackendCallback);
	}

	public void setPort(String port) {
		this.controller.setPort(port);
	}

}
