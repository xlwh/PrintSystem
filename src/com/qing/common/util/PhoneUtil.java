package com.qing.common.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class PhoneUtil {
    /**
     * 手机号码归属地
     * 
     * @param tel
     *            手机号码
     * @return Map,Map两个键province,city 湖北，武汉
     * @throws Exception
     * @author JIA-G-Y
     */
    public static Map<String, String> getMobileLocation(String tel) throws Exception {
	Pattern pattern = Pattern.compile("1\\d{10}");
	Matcher matcher = pattern.matcher(tel);
	if (matcher.matches()) {
	    String url = "http://life.tenpay.com/cgi-bin/mobile/MobileQueryAttribution.cgi?chgmobile=" + tel;
	    String result = callUrlByGet(url, "GBK");
	    StringReader stringReader = new StringReader(result);
	    InputSource inputSource = new InputSource(stringReader);
	    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
	    Document document = documentBuilder.parse(inputSource);
	    String retmsg = document.getElementsByTagName("retmsg").item(0).getFirstChild().getNodeValue();
	    if (retmsg.equals("OK")) {
		String province = document.getElementsByTagName("province").item(0).getFirstChild().getNodeValue().trim() + "省";
		String city = document.getElementsByTagName("city").item(0).getFirstChild().getNodeValue().trim() + "市";
		Map<String, String> map = new HashMap<String, String>();
		map.put("province", province);
		map.put("city", city);
		return map;
	    } else {
		return null;
	    }
	} else {
	    return null;
	}
    }

    /**
     * 获取URL返回的字符串
     * 
     * @param callurl
     * @param charset
     * @return
     */
    private static String callUrlByGet(String callurl, String charset) {
	String result = "";
	try {
	    URL url = new URL(callurl);
	    URLConnection connection = url.openConnection();
	    connection.connect();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset));
	    String line;
	    while ((line = reader.readLine()) != null) {
		result += line;
		result += "\n";
	    }
	} catch (Exception e) {

	    return "";
	}
	return result;
    }

}
