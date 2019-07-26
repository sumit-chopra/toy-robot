package com.robot.toy.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Responsible for loading properties file
 * @author sumit
 *
 */
public class PropertiesLoader {
	
	private static PropertiesLoader loader;
	private Properties prop = new Properties(); 
	Logger logger = LoggerFactory.getLogger(PropertiesLoader.class);
	
	/**
	 * Method to return instance of PropertiesLoader. Singleton implementation
	 * @return
	 */
	public static PropertiesLoader getInstance() {
		if ( loader == null ) {
			/* instance doesnot exist, create new */
			loader = new PropertiesLoader();
		}
		return loader;
	}

	/**
	 * Private constructor
	 */
	private PropertiesLoader() {
		prop = loadProperties();
	}
	
	/**
	 * Reads properties file and loads into memory 
	 * @return Properties
	 */
	public Properties loadProperties() {
		String propFileName = "config.properties";
		logger.info("Reading properties file : " + propFileName );
		try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(propFileName)) {
			prop.load(is);
			logger.info("Properties file has been loaded");
		} catch (IOException e) {
			/* error while reading properties file */
			logger.error(e.getMessage(), e);
		}
		
		return prop;
	}
	
	/**
	 * Retrieves the property value and returns as string
	 * @param key For which the value needs to be looked up 
	 * @param defaultValue Default value in case not found in properties file
	 * @return Value of the property 
	 */
	public String getStringProperty(String key, String defaultValue) {
		return prop.getProperty(key, defaultValue);
	}
	
	/**
	 * Retrieves the property value and returns as int
	 * @param key For which the value needs to be looked up 
	 * @param defaultValue Default value in case not found in properties file
	 * @return Value of the property 
	 */
	public int getIntProperty(String key, int defaultValue) {
		int returnValue = defaultValue;
		String value = prop.getProperty(key);
		if ( value != null ) {
			try { 
				returnValue = Integer.parseInt(value);
			} catch (NumberFormatException e) {
				logger.error(e.getMessage(), e);
			}
		}
		return returnValue;
	}
	
	/**
	 * Retrieves the property value and returns as positive int
	 * @param key For which the value needs to be looked up 
	 * @param defaultValue Default value in case not found in properties file or if it is negative or 0
	 * @return Value of the property 
	 */
	public int getPositiveIntProperty(String key, int defaultValue) {
		int returnValue = getIntProperty(key, defaultValue);
		if ( returnValue <=0 ) {
			logger.warn("Value for property  " + key + " is <=0. Returning default value " + defaultValue);
			returnValue = defaultValue;
		}
		return returnValue;
	}
	
}
