/*
 * Title:        在线打印系统2014年8月14日
 * Description:  打印文件属性相关的业务逻辑实现类
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月14日
 */
package com.zhang.service.imp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhang.dao.PrintAttributeDao;
import com.zhang.domain.PrintAttribute;

/**
 * 
 * 打印文件属性相关的业务逻辑实现类
 * 负责实现接口定义的一些相关的打印文件属性的操作接口
 * 
 * @author       张洪斌
 * @see          
 * @since        在线打印系统, 2014年8月14日
 */
public class PrintAttributeService
{
	/*
	 * 增加打印属性
	 * @parame attribute    要增加的打印文件的打印属性
	 * @return               操作的结果是否成功
	 * 
	 */
	
	public boolean add(PrintAttribute attribute)
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		PrintAttributeDao printattributedao = (PrintAttributeDao)ctx.getBean( "printattributedao" );
		printattributedao.add( attribute );
		return true;
	}
	
	
	/*
	 * 更新打印属性设置
	 * @parame attribute     要设置的新的打印属性
	 * @return               设置是否成功
	 */
	public boolean update(PrintAttribute attribute)
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		PrintAttributeDao printattributedao = (PrintAttributeDao)ctx.getBean( "printattributedao" );
		printattributedao.update( attribute );
		return true;
	}
	
}
