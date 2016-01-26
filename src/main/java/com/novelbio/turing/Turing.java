/**
 * 
 */
package com.novelbio.turing;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author renyx
 * @date 2016年1月17日
 * 
 */
public class Turing {

	boolean state = true;
	Data[] dataArray;
	List<Object> result = new ArrayList<>();

	public static void main(String[] args) {
		
		
		Turing turing = new Turing();
		turing.setData(new Data[] { new Data(Operation.SET, 100), new Data(Operation.SET, 200),
				new Data(Operation.PLUS, 0, 1) });
		turing.start();
		turing.print();
	}

	/**
	 * 
	 */
	private void print() {
		System.out.println(dataArray[dataArray.length - 1].getOutput());

	}

	/**
	 * 
	 */
	private void start() {
		for (int i = 0; i < dataArray.length; i++) {
			if (state) {
				state = calculate(dataArray[i]);
			}
		}

	}

	/**
	 * @param data
	 * @return
	 */
	private boolean calculate(Data data) {
		switch (data.getOp()) {
		case SET:
			data.setOutput(data.getInput1());
			break;
		case PLUS:
			data.setOutput(dataArray[data.getInput1()].getOutput() + dataArray[data.getInput2()].getOutput());
			break;

		default:
			return false;
		}
		return true;
	}

	/**
	 * @param datas
	 */
	private void setData(Data[] dataArray) {
		this.dataArray = dataArray;
	}

}
