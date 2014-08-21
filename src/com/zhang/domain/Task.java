/*
 * Title:        在线打印系统2014年8月11日
 * Description:  打印任务的抽象对象，用于封装打印属性
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月11日
 */
package com.zhang.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * 
 * @author       张洪斌
 * @see         
 * @since        在线打印系统, 2014年8月11日
 */

@Entity
@Table(name="task")
public class Task
{
	private int id;           //主键
	private int state;        //任务状态
	private PrintFile file;   //打印文件
	
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
	
	public int getState()
	{
		return state;
	}
	
	public void setState( int state )
	{
		this.state = state;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fid")
	public PrintFile getFile()
	{
		return file;
	}
	
	public void setFile( PrintFile file )
	{
		this.file = file;
	}
	
	
	
}
