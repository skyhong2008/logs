package com.cn.huwg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadLog {
	private static final Logger logger = LoggerFactory.getLogger(ReadLog.class);

	public static void main(String[] args) {
		String file = "C:/Users/hwg/Desktop/logs/1.log";

		readFileByLines(file);

	}

	public static void readFileByLines(String fileName) {
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			logger.info("start...");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			String cString = null;
			while ((tempString = reader.readLine()) != null) {
				// cString = new String(tempString.getBytes("GBK"), "UTF-8");

				if (containsAny(tempString, "\"cfg_sp\":\"\"")) {
					logger.info("" + tempString);
					line++;
				}

			}
			reader.close();
			logger.info("end..." + line);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	public static boolean containsAny(String str, String searchChars) {
		for (int i = 0; i <= str.length(); i++) {
			int temp;
			temp = str.indexOf(searchChars);
			if (temp >= 0)
				return true;
			else
				return false;
		}
		return false;
	}

}
