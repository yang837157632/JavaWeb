package com.zr.Demo;

import java.io.File;

public class FileDemo2 {

	public static void main(String[] args) {
		
		//显示目录：src com zr Demo下的文件及子目录
		File file = new File("src\\com\\zr\\Demo");
		
		//list方法，获得文件名及子目录
		String[] fn = file.list();
		//for-each
		for(String f:fn) {
			System.out.println(f);
		}
		
		System.out.println();
		
		//listFiles
		File[] files = file.listFiles();
		for(File f: files) {
			if(f.isFile()) {
				System.out.println("文件："+f.getName());
			}
			if(f.isDirectory()) {
				System.out.println("目录："+f.getName());
			}
		}
		
		
		
		
		
		
	}

}