/*
 * Title:        在线打印系统2014年8月15日
 * Description:  管理员相关的业务逻辑接口实现
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月15日
 */
package com.zhang.service.imp;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhang.dao.AdminDao;
import com.zhang.domain.Admin;
import com.zhang.service.AdminInterface;

/**
 *  管理员相关的业务逻辑接口实现
 * 
 * @author       张洪斌
 * @see          
 * @since        在线打印系统, 2014年8月15日
 */
public class AdminService implements AdminInterface
{

	/**
	 * 实现方法
	 * 
	 * @see com.zhang.service.AdminInterface#register(com.zhang.domain.Admin)
	 * @author       张洪斌
	 * @see          
	 * @since        在线打印系统, 2014年8月15日
	 * @param admin
	 * @return
	 */
	@Override
	public boolean register( Admin admin )
	{
		
		return false;
	}

	/**
	 * 实现方法
	 * 管理员登录到管理系统进行任务的管理
	 * @see com.zhang.service.AdminInterface#login(java.lang.String, java.lang.String)
	 * @author       张洪斌
	 * @see          com.zhang.dao.AdminDao#findByName(String) 
	 * @since        在线打印系统, 2014年8月15日
	 * @param username
	 * @param pwd
	 * @return
	 */
	@Override
	public int login( String username, String pwd )
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminDao admindao = (AdminDao)ctx.getBean( "admindao" );
		List<?> lst = admindao.findByName( username );
		if(lst.size()>0)
		{
		     Admin admin = (Admin)lst.get( 0 );
		     if(admin.getPwd().equals( pwd ))
		     {
		    	 return 2;
		     }
		     else
		     {
		    	 return 1;
		     }
		}
		
		return 0;
	}

	/**
	 * 实现方法
	 * 
	 * @see com.zhang.service.AdminInterface#loginOut(java.lang.String)
	 * @author       张洪斌
	 * @see          
	 * @since        在线打印系统, 2014年8月15日
	 * @param name
	 */
	@Override
	public void loginOut( String name )
	{
		
		
	}

}
