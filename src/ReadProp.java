package com.test.utilityclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProp {

	public static String readData(String key){
		File f = new File("./src/test/resources/properties.property");
		FileInputStream fis=null;
		try {
			fis= new FileInputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties p= new Properties();
		try {
			p.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p.getProperty(key);

	}
}
