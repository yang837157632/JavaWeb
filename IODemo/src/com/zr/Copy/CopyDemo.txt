package com.zr.Copy;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class CopyDemo {

	public static void main(String[] args) throws Exception {

		Reader r = new FileReader("src\\com\\zr\\Copy\\CopyDemo.java");
		Writer w = new FileWriter("src\\com\\zr\\Copy\\CopyDemo.txt");
		
		//读一个字符，写一个字符
		//读到一个缓存（数组）中 ==》
		int ch=0;
		while((ch=r.read()) != -1) {
			w.write(ch);
		}
		
		//关闭流
		r.close();
		w.close();	
		
		System.out.println("Done");
	}
}