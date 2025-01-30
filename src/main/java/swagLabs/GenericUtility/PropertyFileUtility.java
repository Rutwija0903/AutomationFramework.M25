package swagLabs.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class consists of generic methods related to 
 * property file
 * @author Rutwija Haripurkar
 * 
 * 
 */

public class PropertyFileUtility {
	
	/**
	 * This method will read data from property file by taking key from the caller
	 * and return the value to caller
	 * @param key
	 * @return 
	 * @throws Throwable 
	 * 
	 */
	
	public String readDataFromPropertyFile(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/Commondata.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
		
		}

}
