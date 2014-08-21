/*
 * Title:        在线打印系统2014年8月12日
 * Description:  打印文件的相关业务逻辑接口
 * Copyright:    Copyright (c) 2014
 * Company:      个人项目
 * @author       张洪斌
 * @version      1.0  2014年8月12日
 */
package com.zhang.service;

import java.io.File;
import java.util.List;

import com.zhang.domain.PrintFile;
import com.zhang.domain.Task;

/**
 * 描述打印文件的相关的业务逻辑接口
 * 定义一个有关于打印文件的公共接口规范
 * 
 * @author       张洪斌
 * @see          
 * @since        在线打印系统, 2014年8月12日
 */
public interface PrintFileInterface
{
	/*
	 * 文件上传：
	 *    收到表现层发出文件上传请求以及上传文件的数据时，要执行以下业务逻辑：
	 *    （可以有两种文件上传方式：1.使用HTML表单上传方式  2.使用JSON封装上传文件对象方式）
	 *    1.解析上传的数据
	 *       （1）对于表单上传的文件，直接用Apache Commons io组件经行数据解析
	 *        (2)对于使用JSON形式提交的数据，使用JSON组件经行解析
	 *    2.数据解析完毕后，把文件存储到服务器磁盘中
	 *    3.获取到文件名，文件格式，上传时间，文件大小，文件路径，所属用户，封装成PrintFile对象，存储到数据库中
	 * 
	 * ******注意：对于用户JSON形式上传文件的数据有如下格式约定*********
	 *    
	 *     {
     *		"data": [
     *   				{
     *       				"name": "[文件名]",
     *       				"format": "[文件格式]",
     *       				"size": "[文件大小]",
     *       				"content": "[文件内容]",
     *       				"uid": "[文件所属用户的id]"
     *   				}
     *				]
	 *		}
	 *    
	 *    
	 *    
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
	/*
	 * 解析JSON上传的文件数据
	 * @param String str          以JSON格式提交的数据
	 * @return PrintFile          返回包装好的打印文件对象
	 * 
	 */
	
	public List<PrintFile> parseJson(String str);
	
	
	/*
	 * 保存文件到服务器磁盘
	 * @param File file       要保存的文件
	 * @return boolean        保存是否成功
	 * 
	 */
	
	public boolean saveFile(File file);
	
	
	/*
	 * 保存打印文件信息到数据库中
	 * @param PrintFile printfile   要保存的打印文件信息
	 * @return boolean              保存结果
	 * 
	 */
	
	public boolean saveToDB(PrintFile printfile,Task task);
	
	
	/*
	 * 更新文件的状态（已经打印好，或者用户已取，或者还没有打印）
	 * @param PrintFile printfile   要更新状态的文件
	 * @return                      更新是否成功
	 * 
	 */
	
	public boolean uodateState(PrintFile printfile);
	
	
	/*
	 * 用户要浏览自己所有的历史文件
	 * @parame int uid         用户id
	 * @return List<?>         用户所有的历史文件
	 * 
	 */
	
	public List<?> viewAll(int uid);
	
	
	/*
	 * 用户浏览自己的正在等待打印的文件
	 * @parame int uid        用户id
	 * @return List<?>        用户所属的所有正在等待打印的文件
	 */
	
	public List<?> viewWaitPrint(int uid);
	
	
	/*
	 * 用户浏览自己的已经打印的文件
	 * @parame int uid        用户id
	 * @return List<?>        用户所属的所已经打印好的文件
	 */
	
	public List<?> viewWaitPrinted(int uid);
	
	
	/*
	 * 用户浏览自己的已经取到的文件
	 * @parame int uid        用户id
	 * @return List<?>        用户所属的所有已经取过的文件
	 */
	
	public List<?> viewGeted(int uid);
	
	 /*
	  * 管理员下载所有等待打印的文件进行打印
	  * @return String           正在等待打印的文件信息(JSON形式)
	  * 
	  *  说明：本地管理客户端在获取到正在等待打印的文件的信息后，通过文件链接，自动构建文件下载（需要解析JSON格式数据）
	  * 
	  */
	
	public String download();
	
	
	
}
