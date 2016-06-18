package br.com.controlealuno.properties;

import java.util.ResourceBundle;

public class AppResource {

	static final ResourceBundle resource = ResourceBundle.getBundle("ApplicationResource");

	public static String getValue(String key) {
		return resource.getString(key);
	}
}
