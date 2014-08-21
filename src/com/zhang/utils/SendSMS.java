/*
 * Title:        在线打印系统2014年8月12日
 * Description:  短信发送的工具类
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月12日
 */
package com.zhang.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * 短信发送的工具类，可以进行短信发送
 * 
 * @author 张洪斌
 * @see 
 * @since 在线打印系统, 2014年8月12日
 */
public class SendSMS
{
	private final static String	name	= "xlwhzhb";	// 短信平台账号
	private final static String	pwd		= "19c2330ab0484c030fdb";	// 短信平台密码

	public static boolean send( String phone, String msg )
	{
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod( "http://utf8.sms.webchinese.cn/" );
		post.addRequestHeader( "Content-Type", "application/x-www-form-urlencoded;charset=gbk" );
		NameValuePair[] data = { new NameValuePair( "Uid", name ), new NameValuePair( "Key", pwd ), new NameValuePair( "smsMob", phone ),
				new NameValuePair( "smsText", msg ) };
		post.setRequestBody( data );
		try
		{
			client.executeMethod( post );
		}
		catch( HttpException e )
		{
			e.printStackTrace();
		}
		catch( IOException e )
		{
			e.printStackTrace();
		}
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println( "statusCode:" + statusCode );
		for( Header h : headers )
		{
			System.out.println( h.toString() );
		}
		String result = null;
		try
		{
			result = new String( post.getResponseBodyAsString().getBytes( "utf-8" ) );
		}
		catch( UnsupportedEncodingException e )
		{
			e.printStackTrace();
		}
		catch( IOException e )
		{
			e.printStackTrace();
		}
		System.out.println( result ); // 打印返回消息状态
         
		post.releaseConnection();
		
		if(result.equals( "1" ))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
}
