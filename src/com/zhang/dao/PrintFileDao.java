/*
 * Title:        在线打印系统2014年8月11日
 * Description:  打印文件的数据库操作对象
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月11日
 */
package com.zhang.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zhang.domain.PrintFile;

/**
 * 
 * 打印文件的数据库访问层对象
 * @author       张洪斌
 * @see          com.zhang.PrintFile
 * @since        在线打印系统, 2014年8月11日
 */
public class PrintFileDao extends HibernateDaoSupport
{
    /*
     * 数据存储
     * @param PrintFile printfile 要存储的打印文件
     */
	
	public void add(PrintFile printfile)
	{
		this.getHibernateTemplate().save( printfile );
	}
	
	/*
	 * 数据删除
	 * @param int id 要删除的存储文件的id
	 */
	
	public void delete(int id)
	{
		
		HibernateTemplate util = this.getHibernateTemplate();
		PrintFile printfile = (PrintFile)util.load( PrintFile.class, id );
		util.delete( printfile );
		
	}
	
	/*
	 * 数据更新
	 * @param PrintFile printfile 要更新的打印文件的数据
	 */
	
	public void update(PrintFile printfile)
	{
		this.getHibernateTemplate().saveOrUpdate( printfile );
	}
	
	/*
	 * 根据用户id获取所有文件信息
	 * @param int id    用户id
	 */
	public List<?> getByUid(int id)
	{
		return this.getHibernateTemplate().find( "from PrintFile where uid='"+id+"'" );
	}
	
	/*
	 * 根据用户id和文件状态获取文件
	 * @param int uid    要获取数据的用户的id
	 * @param int state  要获取的文件状态
	 */
	
	public List<?> getByUidAndState(int uid,int state)
	{
		return this.getHibernateTemplate().find( "from PrintFile where uid='"+uid+"' and state='"+state+"'" );
	}
}
