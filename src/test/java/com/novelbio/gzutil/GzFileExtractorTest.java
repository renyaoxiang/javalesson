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
 * @date 2015年11月17日
 * 
 */
public class GzFileExtractorTest {

	/**
	 * Test method for {@link com.novelbio.gzutil.GzFileExtractor#run()}.
	 */
//	@Test
	public void testRun() {
		String path = "/home/novelbio/git/javalesson/src/test/java/com/novelbio/gzutil/";
		String fileName = path + "mock.gz";
		new GzFileExtractor(fileName, 2, 4).run();
		try (BufferedInputStream bisTest0 = new BufferedInputStream(new GZIPInputStream(new FileInputStream(new File(
				path + "mock-extract-2-4-test.gz"))));
				BufferedInputStream bis0 = new BufferedInputStream(new GZIPInputStream(new FileInputStream(new File(
						path + "mock-extract-2-4.gz"))));) {
			int value0 = 0;
			int value1 = 0;
			while (true) {
				value0 = bisTest0.read();
				value1 = bis0.read();
				Assert.assertEquals("数据内容不同", value0, value1);
				if (value0 == -1 && value1 == -1) {
					break;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
