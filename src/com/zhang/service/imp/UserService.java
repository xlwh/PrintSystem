/*
 * Title:        在线打印系统2014年8月12日
 * Description:  用户相关的业务逻辑实现类
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月12日
 */
package com.zhang.service.imp;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhang.dao.UsersDao;
import com.zhang.domain.Users;
import com.zhang.service.UsersInterface;
import com.zhang.utils.SendSMS;

/**
 * 用户相关的业务逻辑的实现类，负责实现用户相关的所有业务逻辑接口
 * 真正的提供用户相关的业务逻辑处理
 * @author       张洪斌
 * @see          
 * @since        在线打印系统, 2014年8月12日
 */
public class UserService implements UsersInterface
{

	/**
	 * 实现方法
	 * 验证普通用户填写的手机号码是否已经被注册过
	 * @see com.zhang.service.UsersInterface#isRegistered(java.lang.String)
	 * @author       张洪斌
	 * @see          
	 * @since        在线打印系统, 2014年8月12日
	 * @param phone  要验证的手机号码
	 * @return       验证的结果
	 */
	
	public boolean isRegistered( String phone )
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UsersDao userdao = (UsersDao)ctx.getBean( "userdao" );
		List<?> list = userdao.findByPhone( phone );
		if(list.size()>0)
		{
			return true;
		}
		else
		{
		    return false;
		}
	}

	/**
	 * 实现方法
	 * 发送一条验证码给用户，验证手机号码的用户身份
	 * 目前发送的验证码暂时为固定的验证码，真正的发布的时候做成动态密码即可
	 * @see com.zhang.service.UsersInterface#sendMsg(java.lang.String)
	 * @author       张洪斌
	 * @see         
	 * @since        在线打印系统, 2014年8月12日
	 * @param phone  发送验证码的手机号
	 * @param msg    发送的动态验证码
	 * @return
	 */
	
	public boolean sendMsg( String phone ,String msg)
	{
		 return SendSMS.send( phone, msg );
	}

	/**
	 * 实现方法
	 * 验证用户输入的验证码是不是正确
	 * @see com.zhang.service.UsersInterface#checkNumber(java.lang.String, java.lang.String)
	 * @author       张洪斌
	 * @see          
	 * @since        在线打印系统, 2014年8月12日
	 * @param phone    验证的手机号
	 * @param number   用户输入的验证码
	 * @return         验证的结果
	 */
	
	public boolean checkNumber( String phone, String number )
	{
		return true;
	}

	/**
	 * 实现方法
	 * 用户注册
	 * @see com.zhang.service.UsersInterface#register(com.zhang.domain.Users)
	 * @author       张洪斌
	 * @see          
	 * @since        在线打印系统, 2014年8月12日
	 * @param users   要注册的用户对象
	 * @return        注册结果
	 */
	
	public boolean register( Users users )
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UsersDao userdao = (UsersDao)ctx.getBean( "userdao" );
		userdao.save( users );
		return true;
	}

	/**
	 * 实现方法
	 * 用户登录验证
	 * @see com.zhang.service.UsersInterface#login(java.lang.String, java.lang.String)
	 * @author       张洪斌
	 * @see          
	 * @since        在线打印系统, 2014年8月12日
	 * @param name   要验证的用户名
	 * @param pwd    要验证的密码
	 * @return       验证结果
	 */
	@SuppressWarnings( "unused" )
	
	public int login( String name, String pwd )
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UsersDao userdao = (UsersDao)ctx.getBean( "userdao" );
		List<?> lst = userdao.findByName( name );
		if(lst.size()>0)
		{
			for(int i=0;i<lst.size();i++)
			{
				Users user = (Users)lst.get( i );
				  if(user.getPwd().equals( pwd ))
				  {
					  return 2;
				  }
				  else
				  {
					  return 1;
				  }
				
				
			}
		}else
		{
		   return 0;
		}
		return 0;
	}

	/**
	 * 实现方法
	 * (功能详细描述)
	 * @see com.zhang.service.UsersInterface#loginOut(java.lang.String)
	 * @author       张洪斌
	 * @see          
	 * @since        在线打印系统, 2014年8月12日
	 * @param name
	 */
	
	public void loginOut( String name )
	{
		
		
	}

}
