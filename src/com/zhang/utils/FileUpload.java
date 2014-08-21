package com.zhang.utils;

import java.io.File;

/*
 * 构建打印文件
 */

public class FileUpload {
	public File build(File file) {
		if (file.exists()) {
            if(file.isFile())    
            {
            	
            }
			
		} else {
			System.err.println("对不起，要打印的文件不存在");

		}
		return file;

	}



}
