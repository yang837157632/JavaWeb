package com.zr.Copy;

import java.io.*;
import java.util.*;

public class PasteDemo {

	public static void main(String[] args) throws IOException {
		//读出在控制台打印
		Reader reader1 = new FileReader("src\\com\\zr\\Copy\\PasteDemo.txt");
		int ch = 0;
		String x  ="";
		while((ch=reader1.read())!=-1){
			x+=(char)ch;
		}
		for (int i = x.length()-1; i >=0; i--) {
			System.out.print(x.charAt(i));
		}
		reader1.close();
		
		//读出数据存入PasteDemo2(方式1)
		BufferedReader in = new BufferedReader(new FileReader("src\\com\\zr\\Copy\\PasteDemo.txt"));
		BufferedWriter out = new BufferedWriter(new FileWriter("src\\com\\zr\\Copy\\PasteDemo2.txt",true));
		LinkedList list = new LinkedList();
		String s1 = null;
		while((s1=in.readLine())!=null){
			list.add(s1);
		}
		
		Collections.reverse(list);
		
		for (int i=list.size()-1;i>=0;i--) {
			out.write((String)list.get(i));
			out.newLine();
		}
		in.close();
		out.close();
		
		//读出数据存入PasteDemo2(方式2)
		BufferedReader in1 = new BufferedReader(new FileReader("src\\com\\zr\\Copy\\PasteDemo.txt"));
		BufferedWriter out1= new BufferedWriter(new FileWriter("src\\com\\zr\\Copy\\PasteDemo3.txt",true));
		String[] s = new String[1024];
		int i = 0;
		while((s[i]=in1.readLine())!=null){
			i++;
		}
		for (int j =s.length-1; j>=0;j--) {
			if(s[j]!=null){
			out1.write(s[j]);
			out1.newLine();
			}
		}
		in1.close();
		out1.close();
	}	
}
