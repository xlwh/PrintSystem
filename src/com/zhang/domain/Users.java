/*
 * Title:        在线打印系统2014年8月11日
 * Description:  用户的抽象对象，用户封装普通用户对象
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月11日
 */
package com.zhang.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * 
 * @author       张洪斌
 * @see        
 * @since        在线打印系统, 2014年8月11日
 */

@Entity
@Table(name="users")
public class Users
{
	private int id;             	//主键
	private String name;        	//账号
	private String pwd;         	//密码
	private String phone;       	//电话
	private String alipay;      	//支付宝账号
    private String email;       	//邮箱
    private Date registertime;  	//注册时间
    
    private Set<Task> tasks = new HashSet<Task>();                  //发布的打印任务
    private Set<PrintFile> printfiles = new HashSet<PrintFile>();    //用户所拥有的文件
	
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
	
	@Column(length = 30)
	public String getPhone()
	{
		return phone;
	}
	public void setPhone( String phone )
	{
		this.phone = phone;
	}
	
	@Column(length = 30)
	public String getAlipay()
	{
		return alipay;
	}
	public void setAlipay( String alipay )
	{
		this.alipay = alipay;
	}
	
	@Column(length = 30)
	public String getEmail()
	{
		return email;
	}
	public void setEmail( String email )
	{
		this.email = email;
	}
	
	@Basic(optional=true)
	@Temporal(TemporalType.TIMESTAMP) 
	public Date getRegistertime()
	{
		return registertime;
	}
	public void setRegistertime( Date registertime )
	{
		this.registertime = registertime;
	}
	
	@OneToMany
	@JoinColumn(name="uid")
	public Set<Task> getTasks()
	{
		return tasks;
	}
	public void setTasks( Set<Task> tasks )
	{
		this.tasks = tasks;
	}
	
	@OneToMany
	@JoinColumn(name="uid")
	public Set<PrintFile> getPrintfiles()
	{
		return printfiles;
	}
	public void setPrintfiles( Set<PrintFile> printfiles )
	{
		this.printfiles = printfiles;
	}
	
	@Override
	public boolean equals( Object obj )
	{
		if(!(obj==null))
		{
			Users users = (Users)obj;
			return this.getName().equals( users.getName() )
					&&this.getPwd().equals( users.getPwd() );
		}
		return false;
	}
	
	@Override
	public int hashCode()
	{
		
		return this.getName().hashCode()*17+this.getPwd().hashCode();
	}
  	
	
}
