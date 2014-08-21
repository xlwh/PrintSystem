package com.zhang.utils;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class WordAndXmlService {
	public void word2xml(String inFile, String otFile) {
		ComThread.InitSTA();
		ActiveXComponent app = new ActiveXComponent("Word.Application");//启动word
		boolean flag = false;
		try {
			app.setProperty("Visible", new Variant(false));//设置word不可见
			Dispatch docs = app.getProperty("Documents").toDispatch();
			Dispatch doc = Dispatch.invoke(docs, "Open", Dispatch.Method,
					new Object[] { inFile, new Variant(false), new Variant(true), new Variant(false) }, new int[1])
					.toDispatch();//打开word文件
			Dispatch content = Dispatch.get(doc, "Content").toDispatch();
			Dispatch.call(content, "Information", new Variant(4)).toInt();
			Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] { otFile, new Variant(11) }, new int[1]);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			app.invoke("Quit", new Variant[] {});
		}
		ComThread.Release();
	}

	private static Document read(File xmlFile) throws DocumentException {
		SAXReader saxReader = new SAXReader();
		return saxReader.read(xmlFile);
	}

	public static String getDocPageSize(File file) {
		String pages = null;
		try {
			Document doc = read(file);
			@SuppressWarnings("unchecked")
			List<Node> nodes = doc.selectNodes("//o:Pages");
			if (nodes != null && nodes.size() > 0) {
				pages = nodes.get(0).getText();
				System.out.println("/////////////////");
				System.out.println("该word文档的页数为：" + Integer.parseInt(pages));
				System.out.println("/////////////////");
			} else {
				System.out.println("*********");
				System.out.println("页面转换错误");
				System.out.println("*********");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return pages;
	}
}