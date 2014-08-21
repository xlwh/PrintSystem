/**
 *  Copyright (c) 2011, StringUtil.java TAIHEIOT and/or its affiliates. All rights reserved.
 *
 *  Licensed under the TAIHEIOT License, Version 1.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.qing.common.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Title: StringUtil<br>
 * Description: StringUtil<br>
 * CreateTime: 2014-08-07 16:39<br>
 * Copyright: Copyright (c) 2012 taiheiot.com<br>
 * 
 * @字符处理
 * @author 张洪斌
 * @since 1.0
 */
public class StringUtil implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 判断是否是有效的字符串，空串为无效串
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isValidStr(String str) {
		return str != null && str.trim().length() > 0;
	}

	/**
	 * 将字符串的换行替换成HTML的换行符号
	 * 
	 * @param str
	 * @return
	 */
	public static String formatHtmlString(String str) {

		return str.replaceAll("\r\n", "<BR/>");
	}

	public static int getIntValue(String str, int defaultValue) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	public static BigDecimal getBigDecimal(String param) {
		if (StringUtil.isValidStr(param)) {
			try {
				return new BigDecimal(param);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}

		return new BigDecimal(-1);
	}

	public static String describe(Object[] values) {
		StringBuffer buff = new StringBuffer();

		for (int m = 0; m < values.length; m++) {
			buff.append(values[m]).append(", ");
		}

		return buff.toString();
	}

	public static long getStrTolong(String value) {
		long result = 0;
		if (value == null || (value != null && value.equals("") || "null".equals(value)))
			return result;

		try {
			result = Long.parseLong(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static double getStrTodouble(String value) {
		double result = 0;
		if (value == null || (value != null && value.equals("")))
			return result;
		try {
			result = Double.parseDouble(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 比较两个字符串是否相等
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean StringEquals(String str1, String str2) {
		if ((str1 == null || str1.length() == 0) && (str2 == null || str2.length() == 0)) {
			return true;
		}
		return (str1 != null && str2 != null && str1.equals(str2));
	}

	/**
	 * 比较两个字符串是否相等
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean StringEquals1(String str1, String str2) {
		if ((str1 == null || str1.length() == 0) && (str2 != null && str2.length() > 0)
				|| (str1 != null && str1.length() > 0) && (str2 == null || str2.length() == 0)) {
			return false;
		}
		if (str1 == null && str2 == null) {
			return true;
		}
		return (str1.equals(str2));
	}

	/**
	 * 比较两个日期是否相等
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean DateEquals1(Date date1, Date date2) {
		if ((date1 == null) && (date2 != null) || (date1 != null) && (date2 == null)) {
			return false;
		}
		if (date1 == null && date2 == null) {
			return true;
		}

		return (date1.compareTo(date2) == 0);
	}

	/**
	 * 比较两个字符串是否相等
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean StringEquals2(String str1, String str2) {
		if (str1 == null && str2 == null) {
			return false;
		}
		return StringEquals(str1, str2);
	}

	/**
	 * 除去最后一位字符
	 * 
	 * @param str
	 * @return
	 */
	public static String subString(String str) {
		return str.substring(0, str.length() - 1);
	}

	/**
	 * 除去倒数几位字符
	 * 
	 * @param str
	 * @param offSet
	 *            : 倒数几位
	 * @return
	 */
	public static String subString(String str, int offSet) {
		return str.substring(0, str.length() - offSet);
	}

	public static String[] find(String toCode, List<String> fromCodes) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < fromCodes.size(); i++) {
			list.add(fromCodes.get(i));
		}
		if (list.contains(toCode))
			list.remove(toCode);
		return list.toArray(new String[0]);
	}

	/**
	 * 
	 * 生成UUID
	 * 
	 * @author huangqingjian/0050
	 * @see 相关函数,对于重要的函数建议注释
	 * @since 深烟智能物流管理平台, 2013-3-19
	 * @Company: Tai woo. Co., Ltd
	 * @return
	 */
	public static final String GenerateUUID() {
		final UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	public static String objToString(Object obj) {
		String temp = String.valueOf(obj);
		if (null == temp || "null".equals(temp)) {
			return "";
		}
		return temp;

	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param string
	 * @return boolean 返回类型
	 */
	public static boolean isNullOrEmpty(String string) {
		if (string == null)
			return true;
		else if (string.trim().isEmpty())
			return true;
		return false;
	}

	/**
	 * MD5 加密
	 * 
	 * @param text
	 * @return
	 */
	public static String md5(String text) {
		if (isNullOrEmpty(text))
			return "";
		StringBuffer hexString = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(text.getBytes());
			byte[] digest = md.digest();
			for (int i = 0; i < digest.length; i++) {
				text = Integer.toHexString(0xFF & digest[i]);
				if (text.length() < 2) {
					text = "0" + text;
				}
				hexString.append(text);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hexString.toString();
	}

	/**
	 * 
	 * 
	 * Description:object转int
	 * 
	 * @param obj
	 * @return
	 */
	public static int objToNum(Object obj) {

		return null == obj || "null".equals(obj.toString()) ? 0 : Integer.parseInt(obj.toString());

	}

	public static Long objToLong(Object obj) {

		return null == obj || "null".equals(obj.toString()) ? 0 : Long.parseLong(obj.toString());

	}

	/**
	 * 
	 * 
	 * Description:object转double
	 * 
	 * @param obj
	 * @return
	 */
	public static Double objToDouble(Object obj) {

		return null == obj || "null".equals(obj.toString()) ? 0 : Double.parseDouble(obj.toString());

	}

	/**
	 * 
	 * 
	 * Description:验证字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String checkStr(String str) {

		return null == str || "null".equals(str) ? "" : str;

	}

	/**
	 * 增加like查询符号
	 * (一句话功能简述)
	 * (功能详细描述)
	 * @author       huangqingjian/0050
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        清清网系统, 2014年7月25日
	 * @param con
	 * @return
	 */
	public static String addLikeSymbol(String con) {
		StringBuilder builder = new StringBuilder();
		builder.append("%");
		builder.append(con);
		builder.append("%");
		return builder.toString();
	}
}
