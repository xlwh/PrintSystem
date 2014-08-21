/*
 * Title:        在线打印系统2014年8月12日
 * Description:  打印任务的业务逻辑接口实现类
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月12日
 */
package com.zhang.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhang.dao.TaskDao;
import com.zhang.domain.PrintFile;
import com.zhang.domain.Task;
import com.zhang.service.TaskInterface;

/**
 * 打印任务的业务逻辑的接口实现
 * 
 * @author       张洪斌
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        在线打印系统, 2014年8月12日
 */
public class TaskService implements TaskInterface
{

	/**
	 * 实现方法
	 * 用户新增一个打印任务
	 * @see com.zhang.service.TaskInterface#add(com.zhang.domain.Task)
	 * @author       张洪斌
	 * @see          
	 * @since        在线打印系统, 2014年8月12日
	 * @param task   要添加的打印任务
	 * @param printfile   打印文件
	 * @return       添加结果
	 */

	public boolean add( Task task ,PrintFile printfile)
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		TaskDao tsk = (TaskDao)ctx.getBean( "taskdao" );
		task.setFile(printfile);
		tsk.save(task);
		return true;
	}

	/**
	 * 实现方法
	 * (功能详细描述)
	 * @see com.zhang.service.TaskInterface#updateTask(com.zhang.domain.Task)
	 * @author       张洪斌
	 * @see          
	 * @since        在线打印系统, 2014年8月12日
	 * @param task
	 * @return
	 */

	public boolean updateTask( Task task )
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		TaskDao tsk = (TaskDao)ctx.getBean( "taskdao" );
		tsk.update( task );
		return true;
	}

	/**
	 * 实现方法
	 * 用户浏览自己已经打印好，但是还没有取得打印任务
	 * @see com.zhang.service.TaskInterface#viewOready(int)
	 * @author       张洪斌
	 * @see          com.zhang.dao.TaskDao
	 * @since        在线打印系统, 2014年8月14日
	 * @param uid
	 * @return
	 */
	@Override
	public List<Task> viewOready( int uid )
	{
		List<Task> list = new ArrayList<Task>();
		
		return list;
	}
	
	/*
	 * 获取所有等待打印的任务
	 */
	
	public List<?> getTaskToPrint(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		TaskDao dao = (TaskDao)ctx.getBean( "taskdao" );
		List<?> lst = new ArrayList<Object>();
		lst = dao.findAll();
		return lst;
	}
	

}
