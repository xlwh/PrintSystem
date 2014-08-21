/*
 * Title:        在线打印系统2014年8月11日
 * Description:  打印属性的相关数据库操作类
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月11日
 */
package com.zhang.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zhang.domain.PrintAttribute;

/**
 * 打印属性的数据库操作对象
 * 负责操作打印属性的数据库持久化存储，以及修改，查询等等
 * @author       张洪斌
 * @see          com.zhang.domain.PrintAttribute
 * @see          org.springframework.orm.hibernate3.support.HibernateDaoSupport
 * @since        在线打印系统, 2014年8月11日
 */
public class PrintAttributeDao extends HibernateDaoSupport
{
   /*
    * 数据储存
    */
	public void add(PrintAttribute attribute)
	{
		HibernateTemplate util = this.getHibernateTemplate();
		util.save( attribute );
		
	}
	
	/*
	 * 数据删除
	 */
	
	public void delete(int id)
	{
		HibernateTemplate util = this.getHibernateTemplate();
		PrintAttribute attribute = util.load( PrintAttribute.class, id );
		util.delete( attribute );
	}
	
	
	/*
	 * 数据更新
	 */
	
	public void update(PrintAttribute attribute)
	{
		HibernateTemplate util = this.getHibernateTemplate();
		util.saveOrUpdate( attribute );
	}
	
	/*
	 * 根据用户id获取配置属性
	 */
	
	public List<?> findByUid(int id)
	{
		HibernateTemplate util = this.getHibernateTemplate();
		
		return util.find( "from PrintAttribute where uid='"+id+"'");
	}
	
}
