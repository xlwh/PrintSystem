/*
 * Title:        清清网系统 2014年8月20日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2014
 * Company:      清清网
 * @author       huangqingjian
 * @version      2.0  2014年8月20日
 */
package com.zhang.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.Action;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       huangqingjian/0050
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        清清网系统, 2014年8月20日
 */
public class FileUpload implements Action{

	private String json;          //用户上传文件的json格式封装
	private Map<String,String> result;    //返回数据的封装
	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.opensymphony.xwork2.Action#execute()
	 * @author       huangqingjian/0050
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        清清网系统, 2014年8月20日
	 * @return
	 * @throws Exception
	 */
	@Override
	public String execute() throws Exception {
		 result = new HashMap<String,String>();
		// String url = ConfigReader.getTempDir();
		 String json = this.getJson();
		 
		 System.out.println("收到的数据："+json);
		/* List<PrintFile> lst = FileUtil.parseFile( json );
		 ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		 TaskService td = (TaskService)ctx.getBean( "taskservice" );
		 for(int i=0;i<lst.size();i++)
		 {
			 PrintFile printfile = lst.get( i );
			 String filename = printfile.getName();
			 String format = printfile.getFormat();
			 String content = printfile.getContent();
			 
			 String path = url+"//"+filename+"."+format;
			 File file = new File(path);
			 try
			{
				FileOutputStream fout = new FileOutputStream(file);
				BufferedOutputStream out = new BufferedOutputStream(fout);
		       try
				{
					out.write( content.getBytes() );
					out.flush();
					out.close();
					
					printfile.setContent( path );
					Task task = (Task)ctx.getBean( "task" );
					task.setFile( printfile );
					task.setState( 0 );
					
					td.add( task, printfile );
					
					result.put( "state", "1" );
				}
				catch( IOException e )
				{
					e.printStackTrace();
					System.out.println("文件写出失败！");
					result.put( "state", "-1" );
				}
			}
			catch( FileNotFoundException e )
			{
				e.printStackTrace();
				System.out.println("无法保存上传文件："+path);
			}
			 
			 
		 }*/
		 
		 result.put( "state", "1" );
		  this.setResult( result );
		  return SUCCESS;
	}
	/**
	 * @return Returns the json.
	 */
	public String getJson() {
		return json;
	}
	/**
	 * @param json The json to set.
	 */
	public void setJson(String json) {
		this.json = json;
	}
	/**
	 * @return Returns the result.
	 */
	public Map<String, String> getResult() {
		return result;
	}
	/**
	 * @param result The result to set.
	 */
	public void setResult(Map<String, String> result) {
		this.result = result;
	}
	
	
	

}
