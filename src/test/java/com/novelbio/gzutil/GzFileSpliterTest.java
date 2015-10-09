/**
 * 
 */
package com.novelbio.gzutil;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * 
 * @author renyx
 *
 */
public class GzFileSpliterTest {

	/**
	 * Test method for {@link com.novelbio.gzutil.GzFileSpliter#run()}.
	 */
	@Test
	public void testRun() {
		String path = "/home/novelbio/workspace/javalesson/src/test/java/com/novelbio/gzutil/";
		String fileName = path + "mock.gz";
		int count = 2;
		new GzFileSpliter(fileName, count).run();
		try (BufferedInputStream bisTest0 = new BufferedInputStream(new GZIPInputStream(new FileInputStream(new File(
				path + "mock-part-0-test.gz"))));
				BufferedInputStream bisTest1 = new BufferedInputStream(new GZIPInputStream(new FileInputStream(new File(path
						+ "mock-part-1-test.gz"))));
				BufferedInputStream bis0 = new BufferedInputStream(new GZIPInputStream(new FileInputStream(
						new File(path + "mock-part-0.gz"))));
				BufferedInputStream bis1 = new BufferedInputStream(new GZIPInputStream(new FileInputStream(
						new File(path + "mock-part-1.gz"))));) {
			int value0 = 0;
			int value1 = 0;
			do {
				value0 = bisTest0.read();
				value1 = bis0.read();
				Assert.assertEquals("数据内容不同", value0, value1);
			} while (value0 != -1);
			do {
				value0 = bisTest1.read();
				value1 = bis1.read();
				Assert.assertEquals("数据内容不同", value0, value1);
			} while (value0 != -1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
