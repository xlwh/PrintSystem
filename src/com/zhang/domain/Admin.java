/*
 * Title:        在线打印系统2014年8月11日
 * Description:  管理员对象的抽象和封装
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月11日
 */
package com.zhang.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 管理员对象的抽象和封装
 * 
 * @author       张洪斌
 * @see          
 * @since        在线打印系统, 2014年8月11日
 */

@Entity
@Table(name="admin")
public class Admin
{
	private int id;
	private String name;
	private String pwd;
	
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
	public String getPwd()
	{
		return pwd;
	}
	public void setPwd( String pwd )
	{
		this.pwd = pwd;
	}
	
	
}
