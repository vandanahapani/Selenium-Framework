package com.learautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	Properties prop;

	public ConfigDataProvider() {
		File src = new File("./Config/Config.properties");
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(src);
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Not able to load config file >>" + e.getMessage());
		}
	}

	
	//generic method
	public String getDataFromConfig(String keyToSearch) {
		return prop.getProperty(keyToSearch);
	}

	public String getBrowser() {
			return prop.getProperty("Browser");
	}
//get test URL
	public String getStagingURL() {
		return prop.getProperty("qaUrl");
	}

}
