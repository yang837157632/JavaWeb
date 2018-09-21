package com.zr.Demo;

import java.io.File;

public class FileDemo4 {
	//sum = 1+2+3+4+...+n
	//sum(n) = sum(n-1) + n;
	// n! = (n-1)! * n
	// fib:  1  1  2  3  5 ...
	// fib(n) = fib(n-1) + fib(n-2)
	
	//1）写一个方法，列出给定目录下的所有子目录及其所有文件
	public static void  listAll(String path) {
		//创建一个文件对象
		File file = new File(path);
		//如果文件不存在，抛出一个运行期异常
		if(!file.exists()) {
			throw new RuntimeException("文件不存在!!!");
		}
		//是否是目录
		if(file.isDirectory()) {
		//如果是目录，list方法，获得这个目录下的文件及子目录
			//文件，显示，子目录，递归调用
			File[] files = file.listFiles();
			for(File f:files) {
				System.out.println(f.getName());
				if(f.isDirectory()) {
					//子目录，递归调用
					listAll(f.getAbsolutePath());
				}			
			}		
		}else{
			System.out.println(file.getName());
		}		
	}
	
	
	public static void main(String[] args) {
//		listAll("E:/work");
		
		listAll("E:/jspl06.rar");
		System.out.println();
		
		listAll("E:/Undone");
	}

}
