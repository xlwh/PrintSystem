/*
 * Title:        在线打印系统2014年8月11日
 * Description:  打印文件的抽象类对象封装
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月11日
 */
package com.zhang.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 打印文件的抽象类
 * 用于封装打印文件的属性和操作方法
 *
 * @author       张洪斌
 * @see         
 * @since        在线打印系统, 2014年8月11日
 */

@Entity
@Table(name="printfile")
public class PrintFile
{
	private int id;           			//主键
	private String name;      			//文件名
	private String format;    			//文件格式
	private Date createtime;  			//文件创建时间
	private double size;       			//文件大小
	private String content;    			//文件的内容
	private int state;                  //文件的打印状态
	
	 @Id
	 @GeneratedValue(strategy= GenerationType.AUTO)
	public int getId()
	{
		return id;
	}
	public void setId( int id )
	{
		this.id = id;
	}
	
	@Column(length = 30)
	public String getName()
	{
		return name;
	}
	public void setName( String name )
	{
		this.name = name;
	}
	
	@Column(length = 30)
	public String getFormat()
	{
		return format;
	}
	public void setFormat( String format )
	{
		this.format = format;
	}
	
	@Basic(optional=true)
	@Temporal(TemporalType.TIMESTAMP) 
	public Date getCreatetime()
	{
		return createtime;
	}
	public void setCreatetime( Date createtime )
	{
		this.createtime = createtime;
	}
	public double getSize()
	{
		return size;
	}
	public void setSize( double size )
	{
		this.size = size;
	}
	
	@Column(length = 50)
	public String getContent()
	{
		return content;
	}
	public void setContent( String content )
	{
		this.content = content;
	}
	public int getState()
	{
		return state;
	}
	public void setState( int state )
	{
		this.state = state;
	}
	
	
	
	
	
	
}
