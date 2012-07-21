package org.usc.demo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 *
 * @author Shunli
 */
public class Test6 {

	public static void main(String[] args) throws IOException {
		File file = new File("E:\\Source\\XLAct\\V2\\xlgame_dachongfeng\\dcfsummerbloom\\etc\\doc\\killtaskopensummergift.txt");
		List<String> lines = FileUtils.readLines(file);
		int i = 461;
		for (String line : lines) {
			String[] split = line.split("==");
			System.out.println(split[0] + "==" + split[1] + "==" + split[2] + "==" + (i--));
		}
	}

}
