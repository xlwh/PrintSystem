/*
 * Title:        在线打印系统2014年8月14日
 * Description:  服务器配置文件读取工具
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月14日
 */
package com.zhang.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 
 * 服务器配置读取工具
 * 负责读取到用户配置的配置文件（配置文件采用XML格式存储）
 * xml配置文件的格式如下（server.xml）：
 * <conf>
 *   <tempdir>[缓存文件目录]</tempdir>
 *   <filedir>[用户上传的文件的存储目录]</filedir>
 * </conf>
 * 
 * 
 * 
 * @author       张洪斌
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        在线打印系统, 2014年8月14日
 */
public class ConfigReader
{
	/*
	 * 读取要解析的xml文档
	 * @parame path     要解析的xml文档的路径
	 * @return          读取到的待解析的xml文档
	 */
   private static Document bar(String path) throws DocumentException
   {
	   SAXReader reader = new SAXReader();
	   return reader.read( path );
   }
   
   /*
    * 对文档进行解析，解析的结果放在一个Map中
    * @parame document     等待解析的目标文档
    * @return              解析的所有文档节点
    * 
    */
   
   public static Map<String,String> parse(String url) throws DocumentException
   {
	   
	   Document document = bar(url);
	   Map<String,String> result = new HashMap<String,String>();
	   Element root = document.getRootElement();       //读取文档的根节点
	   //遍历根节点的所有子节点
	    for(Iterator<?> it = root.elementIterator();it.hasNext();)
	    {
	    	Element element = (Element)it.next();
	    	result.put( element.getName(), element.getText() );
	    }
	  
	   return result;
   }
   
   /*
    * 读取文件缓存目录
    * @return 读取到的文件的缓存目录
    * 
    */
   
   public static String  getTempDir()
   {
	   try
	{
		Map<String,String> map = ConfigReader.parse( "D:\\server.xml" );
		return map.get( "tempdir" );
	}
	catch( DocumentException e )
	{
		e.printStackTrace();
		System.out.println("对不起，配置文件不存在！会影响服务器的正常功能，请管理人员检查！");
		return null;
	}
	   
   }
   
   /*
    * 读取文件存储目录配置
    * @return        管理员配置好的文件存储目录
    */
   
   public static String getFileDir()
   {
	   try
	{
		Map<String,String> map = ConfigReader.parse( "D:\\server.xml" );
		return map.get( "filedir" );
	}
	catch( DocumentException e )
	{
		e.printStackTrace();
		System.out.println("对不起，配置文件不存在！会影响服务器的正常功能，请管理人员检查！");
		return null;
	}
	   
   }
   
   
   
  }
