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

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/**
 *
 * GZ文件切分工具
 *
 * <pre>
 * 文件必须具有规定格式
 * 1、每四行为一组
 * 2、每组的第一行都是@开头
 * 3、文件总行是必须是4的倍数
 * </pre>
 * 
 * @author renyx
 *
 */
public class GzFileSpliter {

	private String fileName = "/home/novelbio/mock_S_a_filtered_1_part.fq.gz";
	private int partCount = 1;

	/**
	 * @param fileName
	 *            filename
	 * @param partCount
	 *            the number of the file to be splited to
	 */
	public GzFileSpliter(String fileName, int partCount) {
		Validate.isTrue(StringUtils.isNoneBlank(fileName), "文件名不能为空");
		Validate.isTrue(partCount > 0, "文件切分数量必须大于0");
		this.fileName = fileName;
		this.partCount = partCount;
	}

	public static void main(String[] args) {
		String fileName = args[0];
		int count = Integer.valueOf(args[1]);
		new GzFileSpliter(fileName, count).run();
	}

	/**
	 * 运行
	 */
	public void run() {
		String path = fileName.substring(0, fileName.lastIndexOf("/")) + "/";
		int partLineCount = 1;
		int totalGroupNumber = getTotalNumber(fileName);
		partLineCount = (int) Math.ceil(totalGroupNumber * 1.0 / partCount);
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new GZIPInputStream(new FileInputStream(fileName))))) {
			int actualReadedGroupCount = 0;
			for (int partIndex = 0; partIndex < partCount && actualReadedGroupCount < totalGroupNumber; partIndex++) {
				String outputName = getOutputFileName(fileName, path, partIndex);
				try (BufferedWriter bw = new BufferedWriter(
						new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(outputName))))) {
					for (int partActualReadedGroupCount = 0; partActualReadedGroupCount < partLineCount
							&& actualReadedGroupCount < totalGroupNumber; partActualReadedGroupCount++, actualReadedGroupCount++) {
						for (int i = 0; i < 4; i++) {
							String line = br.readLine();
							bw.write(line);
							bw.newLine();
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
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

	private String getOutputFileName(String fileName, String path, int partIndex) {
		int startIndex = fileName.lastIndexOf("/");
		int endIndex = fileName.lastIndexOf(".");
		String outputName = "";
		if (startIndex < endIndex) {
			outputName = path + fileName.substring(startIndex, endIndex) + "-part-" + partIndex + ".gz";
		} else {
			outputName = path + fileName.substring(startIndex) + "-part-" + partIndex + ".gz";
		}
		return outputName;
	}
}
