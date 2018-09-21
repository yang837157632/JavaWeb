package com.zr.Demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Echo {

	public static void main(String[] args) throws IOException {
		
		//从鍵盘读入一行数据，回显这行数据
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		//加while循环，当输入的是quit时退出
		while(true) {
			String s = br.readLine();
			System.out.println(s);
			if(s.equals("quit")) {
				break;
			}
		}
		br.close();		
	}
}
