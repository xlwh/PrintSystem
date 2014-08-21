/*
 * Title:        在线打印系统2014年8月11日
 * Description:  普通用户对象的数据库访问层交互对象
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月11日
 */
package com.zhang.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zhang.domain.Users;

/**
 * 
 * 普通用户对象的数据库访问层对象
 * 负责和底层的数据库经行交互
 * @author       张洪斌
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        在线打印系统, 2014年8月11日
 */
public class UsersDao extends HibernateDaoSupport
{
	
	/*
	 * 保存一个新用户的数据
	 * @parameter Users 要保存的普通用户对象
	 * 
	 * 
	 */

	public void save(Users users)
	{
	  
	   this.getHibernateTemplate().save( users );
	 
	   
	}
	
	
	/*
	 * 删除一个用户
	 * @parameter Users  要删除的用户
	 * 
	 */
	
	public void remove(int id)
	{
		  HibernateTemplate util = this.getHibernateTemplate();
	      Users users = util.load( Users.class, id );
	      util.delete( users );
	      
	}
	
	/*
	 * 修改普通用户的属性
	 * @parameter Users 修改后的属性
	 * 
	 */
	
	public void update(int id,Users users)
	{
		
		HibernateTemplate util = this.getHibernateTemplate();
		util.update( users );
		
	}
	
	/*
	 * 查询一个用户
	 * 
	 * @parameter id  要查找的用户的id
	 */
	
	public Users find(int id){
		 HibernateTemplate util = this.getHibernateTemplate();
		 return util.load( Users.class, id );
	}
	
	/*
	 * 根据手机号获取一条记录
	 * Qparam  phone  要查询的手机号码
	 * 
	 */
	
	public List<?> findByPhone(String phone)
	{
		return this.getHibernateTemplate().find( "from Users where phone='"+phone+"'" );
	}
	
	/*
	 * 根据账号获取用户信息
	 * @parame name   要获取的目标账号
	 * @return        查找结果
	 */
	
	public List<?> findByName(String name)
	{
		return this.getHibernateTemplate().find( "from Users where name='"+name+"'" );
	}
	
}
