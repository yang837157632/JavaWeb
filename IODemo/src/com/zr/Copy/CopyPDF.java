package com.zr.Copy;

import java.io.*;
public class CopyPDF {
	//字符流copy
	public static void copy(String s,String out) throws IOException{
		Reader reader = new FileReader(s);
		Writer writer = new FileWriter(out);
		char[] x= new char[1024];
		int len=0;
		while((len=reader.read(x))!=-1){
			writer.write(x, 0, len);
		}
		reader.close();
		writer.close();
	}
	
	//字节流copy
	public static void copy1(String s,String out) throws IOException{
		InputStream reader = new FileInputStream(s);
		OutputStream writer = new FileOutputStream(out);
		byte[] x= new byte[1024];
		int len=0;
		while((len=reader.read(x))!=-1){
			writer.write(x, 0, len);
		}
		reader.close();
		writer.close();
	}
	
	public static void copy2(FileInputStream s,FileOutputStream out) throws IOException{
		InputStream reader = new BufferedInputStream(s);
		OutputStream writer = new BufferedOutputStream(out);
		int len=0;
		while((len=reader.read())!=-1){
			writer.write(len);
		}
		reader.close();
		writer.close();
	}
	
	public static void main(String[] args) throws IOException {
		copy("src\\com\\zr\\Copy\\chp8.pdf",
				"src\\com\\zr\\Copy\\chp9.pdf");
		
		copy1("src\\com\\zr\\Copy\\chp8.pdf",
				"src\\com\\zr\\Copy\\chp10.pdf");
		
		copy2(new FileInputStream("src\\com\\zr\\Copy\\chp8.pdf"),
				new FileOutputStream("src\\com\\zr\\Copy\\chp11.pdf"));
		
		System.out.println("OK");
	}

}
