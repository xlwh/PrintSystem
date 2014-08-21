/*
 * Title:        在线打印系统2014年8月12日
 * Description:  打印文件的相关业务逻辑接口实现
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月12日
 */
package com.zhang.service.imp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhang.domain.PrintFile;
import com.zhang.domain.Task;
import com.zhang.service.PrintFileInterface;

/**
 * 打印文件的相关业务逻辑接口实现
 * 
 * @author       张洪斌
 * @see         
 * @since        在线打印系统, 2014年8月12日
 */
public class PrintFileService implements PrintFileInterface
{

	/**
	 * 实现方法
	 * 解析客户端使用JSON形式上传上来的文件
	 * @see com.zhang.service.PrintFileInterface#parseJson(java.lang.String)
	 * @author       张洪斌
	 * @see         
	 * @since        在线打印系统, 2014年8月12日
	 * @param str     上传的json形式的数据
	 * @return
	 */
	public List<PrintFile> parseJson( String str )
	{
		List<PrintFile> lst = new ArrayList<PrintFile>();
		JSONObject json = JSONObject.fromObject( str );
		JSONArray array = json.getJSONArray( "data" );
		for(int i=0;i<array.size();i++)
		{
			JSONObject obj = (JSONObject)array.get( i );
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			PrintFile printfile = (PrintFile)ctx.getBean( "printfile" );
			printfile.setName( obj.getString( "name" ) );
			printfile.setFormat( obj.getString( "format" ) );
			printfile.setSize( Integer.parseInt( obj.getString( "size" )) );
			printfile.setContent( obj.getString( "content" ) );
			
			lst.add( printfile );
		}
		return lst;
	}

	/**
	 * 实现方法
	 * 
	 * @see com.zhang.service.PrintFileInterface#saveFile(java.io.File)
	 * @author       张洪斌
	 * @see         
	 * @since        在线打印系统, 2014年8月12日
	 * @param file
	 * @return
	 */
	public boolean saveFile( File file )
	{
		
		return false;
	}

	/**
	 * 实现方法
	 * 
	 * @see com.zhang.service.PrintFileInterface#saveToDB(com.zhang.domain.PrintFile)
	 * @author       张洪斌
	 * @see         
	 * @since        在线打印系统, 2014年8月12日
	 * @param printfile
	 * @return
	 */
	public boolean saveToDB( PrintFile printfile ,Task task)
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		TaskService fileservice = (TaskService)ctx.getBean("printfileservice");
		fileservice.add(task, printfile);
		return false;
	}

	/**
	 * 实现方法
	 * 
	 * @see com.zhang.service.PrintFileInterface#uodateState(com.zhang.domain.PrintFile)
	 * @author       张洪斌
	 * @see         
	 * @since        在线打印系统, 2014年8月12日
	 * @param printfile
	 * @return
	 */

	public boolean uodateState( PrintFile printfile )
	{
		
		return false;
	}

	/**
	 * 实现方法
	 * 
	 * @see com.zhang.service.PrintFileInterface#viewAll(int)
	 * @author       张洪斌
	 * @see         
	 * @since        在线打印系统, 2014年8月12日
	 * @param uid
	 * @return
	 */

	public List<?> viewAll( int uid )
	{
		
		return null;
	}

	/**
	 * 实现方法
	 * 
	 * @see com.zhang.service.PrintFileInterface#viewWaitPrint(int)
	 * @author       张洪斌
	 * @see         
	 * @since        在线打印系统, 2014年8月12日
	 * @param uid
	 * @return
	 */

	public List<?> viewWaitPrint( int uid )
	{
		
		return null;
	}

	/**
	 * 实现方法
	 * 
	 * @see com.zhang.service.PrintFileInterface#viewWaitPrinted(int)
	 * @author       张洪斌
	 * @see         
	 * @since        在线打印系统, 2014年8月12日
	 * @param uid
	 * @return
	 */

	public List<?> viewWaitPrinted( int uid )
	{
		
		return null;
	}

	/**
	 * 实现方法
	 * 
	 * @see com.zhang.service.PrintFileInterface#viewGeted(int)
	 * @author       张洪斌
	 * @see         
	 * @since        在线打印系统, 2014年8月12日
	 * @param uid
	 * @return
	 */

	public List<?> viewGeted( int uid )
	{
		
		return null;
	}

	/**
	 * 实现方法
	 * 
	 * @see com.zhang.service.PrintFileInterface#download()
	 * @author       张洪斌
	 * @see         
	 * @since        在线打印系统, 2014年8月12日
	 * @return
	 */

	public String download()
	{
		
		return null;
	}

}
