/*
 * Title:        在线打印系统2014年8月14日
 * Description:  生成JSON定义格式规定
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月14日
 */
package com.zhang.test;

import net.sf.json.JSONObject;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        在线打印系统, 2014年8月14日
 */
public class CreateJSON
{

	/**
	 * (一句话功能简述)
	 * (功能详细描述)
	 * @author       张洪斌
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        在线打印系统, 2014年8月14日
	 * @param args
	 */
	public static void main( String[] args )
	{
		JSONObject obj = new JSONObject();
		obj.put( "num", "[打印页数]" );
		obj.put( "pagenum", "[每页打印版数]" );
		
		System.out.println(obj.toString());

	}

}
