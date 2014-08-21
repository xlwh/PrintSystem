/*
 * Title:        在线打印系统2014年8月12日
 * Description:  和打印任务相关的业务逻辑接口
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月12日
 */
package com.zhang.service;

import java.util.List;

import com.zhang.domain.PrintFile;
import com.zhang.domain.Task;

/**
 * 
 * 打印任务业务逻辑相关接口，描述了打印任务的相关操作接口
 * @author       张洪斌
 * @see          
 * @since        在线打印系统, 2014年8月12日
 */
public interface TaskInterface
{
	/*
	 * 用户发布打印任务
	 * @param  Task task     要发布大打印任务
	 * @return boolean       任务发布结果
	 * 
	 */
	
	public boolean add(Task task,PrintFile printfile);
	
	/*
	 * 当文件打印完毕后，更新打印状态
	 * @parame            要更新的打印任务
	 * @return            更新操作执行是否成功
	 */
	
	public boolean updateTask(Task task);
	
	/*
	 * 用户查看自己已经打印好，但是还没有取的打印任务
	 *@parame  uid    用户的id
	 *@return         打印任务 
	 * 
	 */
	
	public List<Task> viewOready(int uid);
	
	
	
	
}
