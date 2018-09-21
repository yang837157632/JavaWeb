
package com;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	InputStream resourceAsStream = null;
	Properties properties = null;

	{
		resourceAsStream = getClass().getResourceAsStream("/config.properties");
		properties = new Properties();

		try {
			properties.load(resourceAsStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getValue(String key) {

		String object = properties.get(key).toString();
		return object;
	}

}
