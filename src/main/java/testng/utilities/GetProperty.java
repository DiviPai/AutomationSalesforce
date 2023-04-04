package testng.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetProperty {

	public String getValue(String key) throws IOException {
		String strPath = "C:\\Users\\Prabhu\\eclipse-workspace\\TestNGFramework\\CommonUtilities\\KeyValuePair.properties";
		/*
		 * String userDir = System.getProperty("user.dir"); String fileSep =
		 * System.getProperty("file.separator");
		 * 
		 * String strPath = userDir + fileSep +
		 * "CommonUtilities\\Key-ValuePair.properties";
		 */
		
		FileInputStream fileInput = new FileInputStream(strPath);
		
		Properties property = new Properties();
		property.load(fileInput);
		
		String value = property.getProperty(key);
		return value;
		
		
	}
}
