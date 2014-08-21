/*
 * Title:        在线打印系统2014年8月15日
 * Description:  管理员相关的请求处理
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月15日
 */
package com.zhang.action;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.Action;
import com.zhang.domain.Admin;
import com.zhang.service.imp.AdminService;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌
 * @see          管理员相关的业务逻辑请求处理
 * @since        在线打印系统, 2014年8月15日
 */
public class AdminAction extends Admin implements Action
{
    /*
     * 管理员登录系统
     * 
     * 
     */
	private String json;
	private Map<String,String> result;
	
	
	public String getJson()
	{
		return json;
	}




	public void setJson( String json )
	{
		this.json = json;
	}




	public String login()
	{
		result = new HashMap<String,String>();
		String json = this.getJson();
		
		System.out.println("服务器收到的json:"+json);
		if(json!=null)
		{
			JSONObject obj = JSONObject.fromObject( json );
			String name = obj.getString( "name" );
			String pwd = obj.getString( "pwd" );
			
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			AdminService adminservice = (AdminService)ctx.getBean( "adminservice" );
			result.put( "state", ""+adminservice.login( name, pwd ));
		}
		else
		{
			result.put( "state", "-1" );
		}
		this.setResult( result );
		return SUCCESS;
	}
	
	
	

	/**
	 * 覆盖方法
	 * (功能详细描述)
	 * @see com.opensymphony.xwork2.Action#execute()
	 * @author       张洪斌
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        在线打印系统, 2014年8月15日
	 * @return
	 * @throws Exception
	 */
	@Override
	public String execute() throws Exception
	{
	
		return null;
	}




	public Map<String, String> getResult()
	{
		return result;
	}




	public void setResult( Map<String, String> result )
	{
		this.result = result;
	}
	
	
	
	
	
}
