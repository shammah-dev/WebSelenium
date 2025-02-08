package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utilities {
	
	
	public static String getProperty(String propertyName) throws IOException {
	
		Properties prop =new Properties();
		FileInputStream file=new FileInputStream("config.properties");		
		prop.load(file);
		String value=prop.getProperty(propertyName);
		return value;
	}
	

}
