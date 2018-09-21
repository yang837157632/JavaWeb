package com.zr.Copy;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderDemo2 {

	public static void main(String[] args) throws IOException {
		
		//将当前程序，在控制台输出
		Reader r = new FileReader("src\\com\\zr\\Copy\\ReaderDemo2.java");
		int ch = 0;
		
		while((ch = r.read()) !=-1) {
			System.out.print((char)ch);
		}		
		
		//关闭
		r.close();
	}

}
