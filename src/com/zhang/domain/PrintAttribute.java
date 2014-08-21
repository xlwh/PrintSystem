/*
 * Title:        在线打印系统2014年8月11日
 * Description:  打印文件属性的抽象类封装
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月11日
 */
package com.zhang.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 打印文件属性的抽象类封装
 * 
 * @author       张洪斌
 * @see         
 * @since        在线打印系统, 2014年8月11日
 */

@Entity
@Table(name="printattribute")
public class PrintAttribute
{
	private int id;                //主键
	private boolean isDouble;      //是否打印双面
	private int num;               //打印份数
	private int pagenum;           //每页板数
	private Users users;           //所属用户
	
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
	public boolean isDouble()
	{
		return isDouble;
	}
	public void setDouble( boolean isDouble )
	{
		this.isDouble = isDouble;
	}
	public int getNum()
	{
		return num;
	}
	public void setNum( int num )
	{
		this.num = num;
	}
	public int getPagenum()
	{
		return pagenum;
	}
	public void setPagenum( int pagenum )
	{
		this.pagenum = pagenum;
	}
	
	@OneToOne
	@JoinColumn(name="uid")
	public Users getUsers()
	{
		return users;
	}
	public void setUsers( Users users )
	{
		this.users = users;
	}
	
	
}
