/*
 * Title:        在线打印系统2014年8月12日
 * Description:  用户相关的请求处理
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月12日
 */
package com.zhang.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.Action;
import com.zhang.domain.Users;
import com.zhang.service.imp.UserService;

/**
 * 普通用户相关的请求处理
 * 负责处理用户相关的处理
 * @author       张洪斌
 * @see        
 * @since        在线打印系统, 2014年8月12日
 */
public class UserAction extends Users implements Action
{

	
	private Map<String, String> result ;
	
	/*
	 * 用户注册的相关业务逻辑处理
	 * 
	 * 用户注册时需要提供的参数：
	 * 1.账号       2.密码   3.邮箱    4.手机号码
	 * 
	 */
	
	public String register()
	{
		result = new HashMap<String,String>();
		System.out.println("用户注册.......");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Users user = (Users)ctx.getBean("users");
		
		user.setName(super.getName());
		user.setPwd(super.getPwd());
		user.setEmail(super.getEmail());
		user.setPhone(super.getPhone());
		
		UserService userservice = (UserService)ctx.getBean("userservice");
		
		if(super.getName()==null||super.getPwd()==null||super.getPhone()==null)
		{
			result.put("state", "-1");
		}
		else
		{
				if(userservice.register(user)==true)
				{
					result.put("state", "1");
				}
				else
				{
					result.put("state", "0");
				}
		}
		this.setResult(result);
		return SUCCESS;
	}


	/*
	 * 普通用户登录请求处理
	 * @see com.opensymphony.xwork2.Action#execute()
	 */
	
	public String dologin()
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userservice = (UserService)ctx.getBean("usersservice");
		String name = super.getName();
		String pwd = super.getPwd();
		int istrue = userservice.login(name, pwd);
		result = new HashMap<String,String>();
		result.put("state", ""+istrue);
		this.setResult(result);
		return SUCCESS;
	}

	public String execute() throws Exception {
		
		return null;
	}




	public Map<String, String> getResult() {
		return result;
	}




	public void setResult(Map<String, String> result) {
		this.result = result;
	}
	
	
	
	
    
}
