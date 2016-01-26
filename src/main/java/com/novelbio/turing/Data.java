/**
 * 
 */
package com.novelbio.turing;

/**
 * 
 * 
 * @author renyx
 * @date 2016年1月17日
 * 
 */
public class Data {
	private Operation op;
	private int input1;
	private int input2;
	private int output;

	public Operation getOp() {
		return op;
	}

	public void setOp(Operation op) {
		this.op = op;
	}

	public int getInput1() {
		return input1;
	}

	public void setInput1(int input1) {
		this.input1 = input1;
	}

	public int getInput2() {
		return input2;
	}

	public void setInput2(int input2) {
		this.input2 = input2;
	}

	public int getOutput() {
		return output;
	}

	public void setOutput(int output) {
		this.output = output;
	}

	public Data(Operation op, int input1) {
		super();
		this.op = op;
		this.input1 = input1;
	}

	public Data(Operation op, int input1, int input2) {
		super();
		this.op = op;
		this.input1 = input1;
		this.input2 = input2;
	}

}
