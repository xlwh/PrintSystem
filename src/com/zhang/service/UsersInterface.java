/*
 * Title:        在线打印系统2014年8月12日
 * Description:  和用户相关的业务逻辑的接口定义
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月12日
 */
package com.zhang.service;

import com.zhang.domain.Users;

/**
 * 定义和普通用户相关的所有的业务逻辑接口
 * 但并不负责实现，只是定义一套操作规范而已
 * @author       张洪斌
 * @see          com.zhang.service.imp.UsersService
 * @see          com.zhang.dao.UsersDao
 * @see          com.zhang.domain.Users
 * @since        在线打印系统, 2014年8月12日
 */
public interface UsersInterface
{
	/*
	 * 用户注册
	 * 用注册实现过程：
	 *    1.用户在视图层填写表单;
	 *       （1）必须填写参数：用户名，密码，手机号
	 *    2.手机号验证：
	 *         （1）查询手机号是否已经注册    
	 *              已经注册过：提示用户登录，或者忘记密码？
	 *              没有注册过进入手机号用户身份验证
	 *         （2）发送验证码给手机号
	 *              用户填写收到的验证码（1分钟内）和平台存储的验证码进行比对,验证成功后才可以提交注册申请
	 *    3.提交注册请求经过Struts的拦截交给Action层处理;
	 *    
	 * 
	 * 
	 */
	
	/*
	 * 注册第一步：手机号码是否已经注册验证
	 * @param String phone 需要验证的手机号码
	 * @return 验证的结果
	 */
	
	 public boolean isRegistered(String phone);
	 
	 /*
	  * 注册第二步：发送验证码给手机
	  * @param String phone  发送验证码的目标手机号
	  * @return boolean 发送是否成功
	  */
	 
	 public boolean sendMsg(String phone,String msg);
	 
	 /*
	  * 注册第第三步：进行验证码验证
	  * @param String phone        验证的手机号
	  * @param String number       用户输入的验证码
	  * @return boolean            验证的结果，成功与否
	  */
	 
	 public boolean checkNumber(String phone,String number);
	 
	 
	 /*
	  * 前三步执行成功，可以进行最终的用户注册
	  * @param Users users      要注册的用户对象
	  * @return boolean 注册是否成功
	  */
	 
	 public boolean register(Users users);
	 
	 
	 /*
	  * 用户登录
	  * @param String name      登录账号
	  * @param String pwd       登录密码
	  * @return int              验证结果：0(账号不存在)  1：密码错误
	  * 
	  */
	 
	 public int login(String name,String pwd);
	
	 
	 /*
	  * 用户退出登录
	  * @param String name    要退出的账号
	  * 
	  */
	 public void loginOut(String name);
}
