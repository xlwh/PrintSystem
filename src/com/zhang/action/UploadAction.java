package com.zhang.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zhang.domain.PrintFile;
import com.zhang.domain.Task;
import com.zhang.service.imp.TaskService;

/**
 * 获取Android端上传过来的信息
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class UploadAction extends ActionSupport {
    // 上传文件域
    private File image;
    // 上传文件类型
    private String imageContentType;
    // 封装上传文件名
    private String imageFileName;
    // 接受依赖注入的属性
    private String savePath;

    private Map<String,String> result = new HashMap<String,String>();
    @Override
    public String execute() {
        HttpServletRequest request=ServletActionContext.getRequest();
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            System.out.println("获取Android端传过来的普通信息：");
            System.out.println("用户名："+request.getParameter("username"));
            System.out.println("密码："+request.getParameter("pwd"));
           /* System.out.println("年龄："+request.getParameter("age"));*/
            String name = request.getParameter("fileName");
            System.out.println("文件名："+name);
            System.out.println("获取Android端传过来的文件信息：");
/*            System.out.println("文件存放目录: "+getSavePath());*/
            System.out.println("文件名称: "+imageFileName);
           /* System.out.println("文件大小: "+image.length());*/
            System.out.println("文件类型: "+imageContentType);
            
            Task task = new Task();
            PrintFile printfile = new PrintFile();
            printfile.setName(name);
            printfile.setCreatetime(new Date());
            printfile.setFormat(imageContentType);
            printfile.setState(0);
            
            printfile.setContent("D:\\upload"+ "/" + name);
          
            task.setState(0);
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
            TaskService tsk = (TaskService)ctx.getBean("taskservice");
            tsk.add(task, printfile);
            
            
            fos = new FileOutputStream("D:\\upload"+ "/" + name);
            fis = new FileInputStream(getImage());
            System.out.println("大小："+fis.available());
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            System.out.println("文件上传成功");
            result.put( "state", "1" );
        } catch (Exception e) {
        	  result.put( "state", "-1" );
            e.printStackTrace();
        } finally {
            close(fos, fis);
        }
      
		 this.setResult( result );
		 return SUCCESS;
      
    }

    /**
     * 文件存放目录
     * 
     * @return
     */
    public String getSavePath() throws Exception{
        return ServletActionContext.getServletContext().getRealPath(savePath); 
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    private void close(FileOutputStream fos, FileInputStream fis) {
        if (fis != null) {
            try {
                fis.close();
                fis=null;
            } catch (IOException e) {
                System.out.println("FileInputStream关闭失败");
                e.printStackTrace();
            }
        }
        if (fos != null) {
            try {
                fos.close();
                fis=null;
            } catch (IOException e) {
                System.out.println("FileOutputStream关闭失败");
                e.printStackTrace();
            }
        }
    }

	
	public Map<String, String> getResult() {
		return result;
	}

	
	public void setResult(Map<String, String> result) {
		this.result = result;
	}
    
    
    

}