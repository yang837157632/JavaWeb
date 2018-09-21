package com.zr.Copy;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterDemo {

	public static void main(String[] args) throws IOException {
		
		//Writer示例
		Writer w = new FileWriter("src\\com\\zr\\Copy\\WriterDemo.txt");
		
		//写一个字符
		w.write('j');
		w.write("\r\n");

		w.write("java");
		w.write("\r\n");
		
		//写一个字符数组
		char[] cbuf = {'j','s','p','w','e','b'};
		w.write(cbuf);
		w.write("\r\n");
		
		//写一个字符数组的一部分
		w.write(cbuf, 2, 3);
		w.write("\r\n");		
		
		
		Writer w2 = new FileWriter("src\\com\\zr\\Copy\\WriterDemo2.txt",true);
		w2.append("孩子们心中的希望是什么形状！\r\n");
		
		w.close();
		w2.close();
		System.out.println("ok");
		
	}
}
