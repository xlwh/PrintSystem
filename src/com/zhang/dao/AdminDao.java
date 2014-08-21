/*
 * Title:        在线打印系统2014年8月11日
 * Description:  管理员相关的数据库访问对象
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月11日
 */
package com.zhang.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zhang.domain.Admin;

/**
 * 
 * 管理员相关的数据库操作层
 * @author       张洪斌
 * @see          com.zhang.domain.Admin
 * @since        在线打印系统, 2014年8月11日
 */
public class AdminDao extends HibernateDaoSupport
{
    /*
     * 添加数据
     */
	
	public void add(Admin admin)
	{
		HibernateTemplate util =  this.getHibernateTemplate();
		util.save( admin );
	}
	
	/*
	 * 删除数据
	 */
	
	public void delete(int id)
	{
		HibernateTemplate util = this.getHibernateTemplate();
		Admin admin = util.load( Admin.class, id );
		util.delete( admin );
	}
	
	
	/*
	 * 修改数据
	 * 
	 */
	
	public void update(Admin admin)
	{
		HibernateTemplate util = this.getHibernateTemplate();
		util.saveOrUpdate( admin );
	}
	
	/*
	 * 通过id获取一个管理员信息
	 */
	public Admin findById(int id)
	{
		return (Admin)this.getHibernateTemplate().load( Admin.class, id );
	}
	
	
	/*
	 * 通过账号获取管理员信息
	 */
	
	public List<?> findByName(String name)
	{
		return this.getHibernateTemplate().find( "from Admin where name='"+name+"'" );
	}
	
	
	
}
