/**
 * 
 */
package com.tlvProcessor.util;

/**
 * @author amkb
 *
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
 
/**
 * @author Crunchify.com
 * 
 */
 
public  class GetProperties {
	static String result = "";
	static InputStream inputStream;
 
	public String getPropValues(String propertyKey) throws IOException {
 
		try {
			Properties prop = new Properties();
			String propFileName = "processor.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			result = prop.getProperty(propertyKey);		
			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}
}