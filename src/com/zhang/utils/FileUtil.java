/*
 * Title:        在线打印系统2014年8月14日
 * Description:  解析上传文件的小工具
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月14日
 */
package com.zhang.utils;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhang.domain.PrintFile;

/**
 * 对用json格式上传的文件进行解析的处理工具
 *     json形式上传文件的处理步骤：
 *     （1）对数据进行解析
 *      (2)解析完毕后返回解析完的文件
 * 
 * 
 * @author       张洪斌
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        在线打印系统, 2014年8月14日
 */
public class FileUtil
{
	public static List<PrintFile> parseFile(String str)
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		List<PrintFile> lst = new ArrayList<PrintFile>();
		if(str!=null){
		JSONObject obj = JSONObject.fromObject( str );
		JSONArray array = obj.getJSONArray( "data" );
		for(int i=0;i<array.size();i++)
		{
			PrintFile file = (PrintFile)ctx.getBean( "printfile" );
			JSONObject ob = array.getJSONObject( i );
			if(!obj.isEmpty())
			{
				String name = ob.getString( "name" );
				String format = ob.getString( "format" );
				int size = ob.getInt( "size" );
				String content = ob.getString( "content" );
				
				file.setName( name );
				file.setFormat( format );
				file.setSize( size );
				file.setContent( content );
				
				lst.add( file );
				
			}
			
		}
		}
		return lst;
	}
}
