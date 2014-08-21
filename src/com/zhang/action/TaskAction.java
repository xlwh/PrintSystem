
package com.zhang.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.Action;
import com.zhang.dao.PrintAttributeDao;
import com.zhang.domain.PrintAttribute;
import com.zhang.domain.Task;
import com.zhang.service.imp.TaskService;
import com.zhang.utils.ConfigReader;

public class TaskAction extends Task implements Action{

	/*
	 * 普通用户发起一个打印任务
	 * 当一个用户发起一个打印任务时，需要进行以下几个业务逻辑
	 * 1.用户先选择要打印的文件，当用户选择好文件后，采用异步上传机制将文件提前缓存到服务器文件缓冲区（用户可以选择多个文件进行上传）
	 * 2.用户选择或者设置打印属性
	 * 3.待用户提交打印请求后服务器接收用户的打印属性设置，取出放在缓冲区中的文件存储到待打印文件区，删除缓冲区中的文件
	 * 4.把任务提交到数据库中保存
	 * 
	 * @see com.opensymphony.xwork2.Action#execute()
	 */
	
	
	/*
	 * 异步上传文件（采用json格式进行封装）
	 * 处理过程：接收用户上传的文件，进行文件解析
	 * 
	 * @see com.opensymphony.xwork2.Action#execute()
	 */
	
	private String json;          //用户上传文件的json格式封装
	private Map<String,String> result;    //返回数据的封装
	private Map<String,Object>    objresult;
	private int uid;                      //用户Id
	/*
	 * 取得用户上传文件的json格式封装数据
	 * @return 用户上传的json格式封装数据
	 */
	public String getJson()
	{
		return json;
	}

	/*
	 * 把从请求里面接收到的上传文件解析出来
	 * @parame json    用户要上传的多个对象的json格式封装
	 */
	public void setJson( String json )
	{
		this.json = json;
	}

	/*
	 * (1)解析JSON格式的传输过来的数据
	 * (2)保存文件
	 * (3)把打印任务信息保存到数据库
	 * 
	 * 
	 */
	 public String uploadByJson()
	 {
		 result = new HashMap<String,String>();
		 @SuppressWarnings("unused")
		String url = ConfigReader.getTempDir();
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
	 
	 /*
	  * 用户设置打印属性设置
	  * 打印属性的提交方式：使用json进行数据提交
	  *  数据提交格式规定如下：
	  *  {"num":"[打印页数]","pagenum":"[每页打印版数]"}
	  * 
	  * 
	  */
	 
	 public String setAttribute()
	 {
		 result = new HashMap<String,String>();
		 String json = this.getJson();
		 JSONObject obj = JSONObject.fromObject( json );
		 if(!obj.isEmpty())
		 {
			 int num = obj.getInt( "num" );
			 int pagenum = obj.getInt( "pagenum" );
			 
			 ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			 PrintAttribute attribute = (PrintAttribute)ctx.getBean( "printattribute" );
			 
			 attribute.setNum( num );
			 attribute.setPagenum( pagenum );
			 
			 //保存打印属性
			 PrintAttributeDao printattributedao = (PrintAttributeDao)ctx.getBean( "PrintAttributeDao" );
			 printattributedao.add( attribute );
			 
			 result.put( "state", "1" );
			 
		 }
		 this.setResult( result );
		 return SUCCESS;
	 }
	 
	 
	 
	 /*
	  * 用户设置打印属性修改
	  * 打印属性的提交方式：使用json进行数据提交
	  *  数据提交格式规定如下：
	  *  {"num":"[打印页数]","pagenum":"[每页打印版数]"}
	  * 
	  * 
	  */
	 
	 public String updateAttribute()
	 {
		 System.out.println("文件上传");
		 result = new HashMap<String,String>();
		 String json = this.getJson();
		 JSONObject obj = JSONObject.fromObject( json );
		 if(!obj.isEmpty())
		 {
			 int num = obj.getInt( "num" );
			 int pagenum = obj.getInt( "pagenum" );
			 
			 ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			 PrintAttribute attribute = (PrintAttribute)ctx.getBean( "printattribute" );
			 
			 attribute.setNum( num );
			 attribute.setPagenum( pagenum );
			 
			 //保存打印属性
			 PrintAttributeDao printattributedao = (PrintAttributeDao)ctx.getBean( "PrintAttributeDao" );
			 printattributedao.update( attribute );
			 
			 result.put( "state", "1" );
			 
		 }
		 this.setResult( result );
		 return SUCCESS;
	 }
	 
	 /*
	  * 
	  * 用户查看自己已经打印好的文件
	  * @parame  uid        用户id
	  * @return             json格式封装好的用户正在打印的打印任务
	  * 
	  */
	 
	 public String viewOready()
	 {
		 result = new HashMap<String,String>();
		 
		 
		 this.setResult( result );
		 return SUCCESS;
	 }
	 
	 /*
	  * 获取所有等待打印的任务
	  * 
	  */
	 
	 public String getAll(){
		 ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		 TaskService tsk = (TaskService)ctx.getBean( "taskservice" );
		 JSONObject obj = new JSONObject();
		 JSONArray array = new JSONArray();
		 objresult = new HashMap<String,Object>();
		List<?> lst = tsk.getTaskToPrint();
		 for(int i=0;i<lst.size();i++)
		 {
			 Task task = (Task)lst.get( i );
			 JSONObject ts = new JSONObject();
			 ts.put("file", task.getFile());
			 array.add(ts);
			
		 }
		 obj.put("data", array);
		 objresult.put("json", obj);
		 this.setObjresult( objresult );
		 return SUCCESS;
	 }
	 

	public Map<String, String> getResult()
	{
		return result;
	}

	public void setResult( Map<String, String> result )
	{
		this.result = result;
	}

	public String execute() throws Exception 
	{
		
		return null;
	}

	public int getUid()
	{
		return uid;
	}

	public void setUid( int uid )
	{
		this.uid = uid;
	}

	public Map<String, Object> getObjresult() {
		return objresult;
	}

	public void setObjresult( Map<String, Object> objresult ) {
		this.objresult = objresult;
	}
	
	
	
	

}
