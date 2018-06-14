/**
 * 
 */
package com.rionour.gzutil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.lang3.Validate;

/**
 * 
 * 
 * @author renyx
 * 
 */
public class GzFileExtractor {

	private String fileName;
	private int start = 0;
	private int end = 0;
	private int runningStart = 0;
	private int runningEnd = 0;

	/**
	 * @param fileName
	 *            filename
	 * @param start
	 *            start
	 * @param end
	 *            end
	 */
	public GzFileExtractor(String fileName, int start, int end) {
		Validate.notBlank(fileName);
		Validate.isTrue(start > 0, "起始组号必须大于0");
		Validate.isTrue(end > 0, "结束组号必须大于0");
		Validate.isTrue(end >= start, "结束组号必须大于等于起始组号");
		this.fileName = fileName;
		this.start = start;
		this.end = end;
		this.runningStart = start - 1;
		this.runningEnd = end;
	}

	public static void main(String[] args) {
		Validate.isTrue(args.length == 3, "需要三个输入参数:文件名 起始组号(1位开始，包括) 结束组号(1位开始，包括");
		String fileName = args[0];
		int start, end;
		try {
			start = Integer.valueOf(args[1]);
			end = Integer.valueOf(args[2]);
		} catch (Exception e) {
			System.err.println("起始组合、截取长度必须是整数");
			return;
		}

		new GzFileExtractor(fileName, start, end).run();

	}

	/**
	 * 运行
	 */
	public void run() {
		String outputName = getOutputFileName(fileName);
		int totalGroupNumber = getTotalNumber(fileName);
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new GZIPInputStream(new FileInputStream(fileName))));
				BufferedWriter bw = new BufferedWriter(
						new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(outputName))))) {
			for (int index = 0; index < runningEnd && index < totalGroupNumber; index++) {

				for (int i = 0; i < 4; i++) {
					String line = br.readLine();
					if (index >= runningStart) {
						bw.write(line);
						bw.newLine();
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int getTotalNumber(String fileName) {
		int totalGroupNumber = 0;
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new GZIPInputStream(new FileInputStream(fileName))))) {
			int groupLineNumber = 0;
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				if (line.startsWith("@")) {
					Validate.isTrue(groupLineNumber % 4 == 0, "文件格式不正确：存在不完整的分组");
					totalGroupNumber++;
					groupLineNumber = 0;
				}
				groupLineNumber++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return totalGroupNumber;
	}

	private String getOutputFileName(String fileName) {
		String path = fileName.substring(0, fileName.lastIndexOf("/")) + "/";
		int startIndex = fileName.lastIndexOf("/");
		int endIndex = fileName.lastIndexOf(".");
		String outputName = "";
		if (startIndex < endIndex) {
			outputName = path + fileName.substring(startIndex, endIndex) + "-extract-" + start + "-" + end + ".gz";
		} else {
			outputName = path + fileName.substring(startIndex) + "-extract-" + start + "-" + end + ".gz";
		}
		return outputName;
	}

}
