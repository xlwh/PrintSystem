/*
 * Title:        在线打印系统2014年8月12日
 * Description:  打印任务的数据库访问层对象
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月12日
 */
package com.zhang.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zhang.domain.Task;

/**
 * 
 * 打印任务的数据库访问对象，负责和数据库进行交互
 * @author       张洪斌
 * @see          com.zhang.domain.Task
 * @since        在线打印系统, 2014年8月12日
 */
public class TaskDao extends HibernateDaoSupport
{
	/*
	 * 数据存储
	 * @param Task task 要存储的任务数据
	 */
	
	public void save(Task task)
	{
		this.getHibernateTemplate().save( task );
	}
	
	/*
	 *数据删除
	 *@param int id  要删除的数据id
	 */
	
	public void delete(int id)
	{
		HibernateTemplate util = this.getHibernateTemplate();
		Task task = (Task)util.load( Task.class, id );
		util.delete( task );
	}
	
	/*
	 * 数据更新
	 * @param Task task  要更新的数据
	 */
	
	public void update(Task task)
	{
		this.getHibernateTemplate().saveOrUpdate( task );
	}
	
	/*
	 * 根据用户id获取打印任务
	 * @param int id 想要获取的打印任务的用户id
	 */
	
	public List<?> findByUid(int id)
	{
		return this.getHibernateTemplate().find( "from Task where uid='"+id+"'" );
	}
	
	/*
	 * 查看某个用户已经打印好，但是还没有取到
	 * @param uid       用户id
	 * @return          打印任务列表
	 * 
	 */
	
	public List<?> viewOready(int uid)
	{
		
		return this.getHibernateTemplate().find( "from Task where uid='"+uid+"'" );
		
	}
	
	
	/*
	 * 获取所有的等待中的打印任务
	 * 
	 * @return    所有正在等待中的任务
	 */
	
	public List<?> findAll()
	{
		return this.getHibernateTemplate().find( "from Task where state='"+0+"'" );
		
	}
	
}
