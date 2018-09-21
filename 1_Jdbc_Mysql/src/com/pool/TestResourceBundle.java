package com.pool;

import java.util.ResourceBundle;

public class TestResourceBundle {

	public static void main(String[] args) {

//		ResourceBundle bundle=ResourceBundle.getBundle("config");
		
		ResourceBundle bundle=ResourceBundle.getBundle("com/source/parameter");

		System.out.println(bundle.getString("username"));

	}
}
