package com.huanduguihua.user.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateTxt {
	public static void main(String s[]) {
	}


	public static void contentToTxt(String filePath, String content) {
		try {
			File f = new File(filePath);
			if (f.exists()) {
			} else {
				f.createNewFile();// 不存在则创建
			}
			BufferedWriter output = new BufferedWriter(new FileWriter(f, true));
			output.write(content);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	public static void createwjj(String filePath){
		File f=new File(filePath);
		if(!f.exists()){
			f.mkdirs();
		}
	}
	/**
	 * 
	 * @param filepath 要打包的文件路径
	 * @param zippath  打包后的文件路径
	 */
	public static void createZIP(List<String> filepath,String zippath){
		try {
			 byte[] buffer = new byte[1024];   
		       ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zippath));   
//		       String[] file1={"d:/a.txt","d:/b.txt","d:/a.html","d:/b.html"};   
		       for(int i=0;i<filepath.size();i++) {   
		    	   File f=new File(filepath.get(i));
		           FileInputStream fis = new FileInputStream(f);   
		           out.putNextEntry(new ZipEntry(f.getName()));   
		           int len;   
		           //读入需要下载的文件的内容，打包到zip文件   
		          while((len = fis.read(buffer))>0) {   
		           out.write(buffer,0,len);    
		          }   
		           out.closeEntry();   
		           fis.close();   
		       }   
		        out.close();   
		        System.out.println("zip成功");   
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}