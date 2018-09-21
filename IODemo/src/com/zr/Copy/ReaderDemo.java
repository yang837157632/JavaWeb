package com.zr.Copy;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderDemo {

	public static void main(String[] args) throws IOException {
		
		//Reader的示例，从当前文件中读一些字符
		Reader r = new FileReader("src\\com\\zr\\Copy\\ReaderDemo.java");
		
		//读数据,读一个字符
		int i1 = r.read();
		System.out.println((char)i1);
		int i2 = r.read();
		System.out.println((char)i2);
		
		//读到一个字符数组
		char[] cbuf = new char[10];
		r.read(cbuf);
		System.out.println(cbuf);
		
		//读到数组中的一部分
		char[] cbuf1 = new char[10];		
		r.read(cbuf1,2,6);
		System.out.println(cbuf1);
		
		r.close();	
	}
}
