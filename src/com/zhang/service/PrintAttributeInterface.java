/*
 * Title:        在线打印系统2014年8月12日
 * Description:  用户的打印属性相关接口
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月12日
 */
package com.zhang.service;

import com.zhang.domain.PrintAttribute;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌
 * @see          
 * @since        在线打印系统, 2014年8月12日
 */
public interface PrintAttributeInterface
{
	/*
	 * 用户增加一个新的打印属性
	 * @param PrintAttribute attribute   要添加的新的打印属性
	 * @return boolean                   属性设置结果
	 */
	public boolean add(PrintAttribute attribute);
	
	/*
	 * 用户修改一个打印属性
	 * @param  PrintAttribute attribute    设置好的新的打印属性
	 * @return boolean                     设置结果，是否成功
	 */
	
	public boolean update(PrintAttribute attribute);
	
}
