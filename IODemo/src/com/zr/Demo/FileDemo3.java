package com.zr.Demo;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class FileDemo3 {

	public static void main(String[] args) {
		
		// 显示Demo目录下所有java结尾的文件
		File file = new File("src\\com\\zr\\Demo");
		String[] files = file.list();
		for(String f:files) {
			if(f.endsWith("java")) {
				System.out.println(f);
			}
		}
		System.out.println();
		
		//file.list
		String[] files1 = file.list(new FilenameFilter(){
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith("java");
			}			
		});		
		System.out.println("file.list");
		for(String s:files1) {
			System.out.println(s);
		}
		System.out.println();
		
		//filename.list
		File[] files2 = file.listFiles(new MyFileFilter());
		System.out.println("file.listFiles");
		for(File f:files2) {
			System.out.println(f);
		}
	}
}

//写一个类实现FileFilter
class MyFileFilter implements FileFilter {
	@Override
	public boolean accept(File pathname) {
		return pathname.getName().endsWith("java");
	}	
}









