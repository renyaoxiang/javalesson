/**
 * 
 */
package com.novelbio.gzutil;

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

/**
 *
 * GZ文件切分工具
 *
 * <pre>
 * 文件必须具有特殊格式,每四行为一组，每组的第一行都是@开头，文件总行是必须是4的倍数
 * </pre>
 * 
 * @date 2015-10-9
 * @author renyx
 *
 */
public class GzFileSpliter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileName = "/home/novelbio/mock_S_a_filtered_1_part.fq.gz";
		int partCount = 3;

		String path = fileName.substring(0, fileName.lastIndexOf("/")) + "/";
		int partLineCount = 1;
		int totalGroupNumber = getTotalNumber(fileName);
		partLineCount = (int) Math.ceil(totalGroupNumber * 1.0 / partCount);
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(
				fileName))))) {
			int actualReadedGroupCount = 0;
			for (int partIndex = 0; partIndex < partCount && actualReadedGroupCount < totalGroupNumber; partIndex++) {
				String outputName = getOutputFileName(fileName, path, partIndex);
				try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(
						new FileOutputStream(outputName))))) {
					for (int partActualReadedGroupCount = 0; partActualReadedGroupCount < partLineCount
							&& actualReadedGroupCount < totalGroupNumber; partActualReadedGroupCount++, actualReadedGroupCount++) {
						for (int i = 0; i < 4; i++) {
							String line = br.readLine();
							bw.write(line + "\n");
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

	private static int getTotalNumber(String fileName) {
		int totalNumber = 0;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(
				fileName))))) {
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				if (line.startsWith("@")) {
					totalNumber++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return totalNumber;
	}

	private static String getOutputFileName(String fileName, String path, int partIndex) {
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
