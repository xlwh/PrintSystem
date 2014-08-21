/*
 * Title:        在线打印系统2014年8月12日
 * Description:  管理员相关的接口
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月12日
 */
package com.zhang.service;

import com.zhang.domain.Admin;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        在线打印系统, 2014年8月12日
 */
public interface AdminInterface
{
	/*
	 * 管理员注册
	 * @param Admin admin   要注册的管理员
	 * @return boolean      注册结果             
	 */
	
	public boolean register(Admin admin);
	
	/*
	 * 管理员登录
	 * @param String name   管理员账号
	 * @param String pwd    管理员密码
	 * @return int          登录验证结果（0：账号不存在  1：密码错误）
	 */
	
	public int login(String username,String pwd);
	
	
	/*
	 * 管理员退出登录
	 * @param String name   要退出的账号   
	 * 
	 */
	
	public void loginOut(String name);
	
}
