/**
 *  Copyright (c) 2011, Eryptogram.java TAIHEIOT and/or its affiliates. All rights reserved.
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

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Title: 日期时间处理工具类<br>
 * Description: 日期时间处理工具类<br>
 * CreateTime: 2014-08-06 16:39<br>
 * Copyright: Copyright (c) 2012 taiheiot.com<br>
 * 
 * @author 张洪斌
 * @since 1.0
 */
public class DateTimeUtils {

	/**
	 * 将java.util.Date类型日期转化为“yyyy-MM-dd”格式的String类型日期
	 * 
	 * @param date
	 *            java.util.Date类型日期
	 * @return String类型日期
	 */
	public static String getDate(java.util.Date date) {
		return formatDateYMD(date);
	}

	/**
	 * 返回字符型时间("HH:mm:ss")
	 * 
	 * @param date
	 *            java.util.Date类型日期
	 * @return 返回字符型时间
	 */
	public static String getTime(java.util.Date date) {
		return formatDateHMS(date);
	}

	/**
	 * 返回字符型日期时间("yyyy-MM-dd HH:mm:ss")
	 * 
	 * @param date
	 *            java.util.Date类型日期
	 * @return 返回字符型日期时间
	 */
	public static String getDateTime(java.util.Date date) {
		return formatDateYMDHMS(date);
	}

	/**
	 * 返回当前的时间
	 * 
	 * @return 返回当前时间的毫秒数
	 * 
	 */
	public static long getCurrentTime() {
		return (new Date()).getTime();
	}

	/**
	 * 返回当前日期的timestamp格式
	 * 
	 * @return
	 * 
	 */
	public static Timestamp getCurrentTimestamp() {
		return new Timestamp((new Date()).getTime());
	}

	/**
	 * 将java.util.Date类型日期转化为指定格式的String yyyy-MM-dd类型日期
	 * 
	 * @param date
	 *            java.util.Date类型日期
	 * @param format
	 *            指定的日期格式
	 * @return String类型日期
	 */
	public static String formatDateY_M_D(java.util.Date date) {
		SimpleDateFormat dateFomater;
		String result = "";
		if (date != null) {
			try {
				dateFomater = new SimpleDateFormat("yyyy-MM-dd");
				result = dateFomater.format(date);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 将java.util.Date类型日期转化为指定格式的String yyyyMMdd类型日期
	 * 
	 * @param date
	 *            java.util.Date类型日期
	 * @param format
	 *            指定的日期格式
	 * @return String类型日期
	 */
	public static String formatDateYMD(java.util.Date date) {
		String result = "";
		if (date != null) {
			try {
				SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMMdd");
				result = dateFormater.format(date);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 将java.util.Date类型日期转化为指定格式的String yyyy-MM-dd类型日期
	 * 
	 * @param date
	 *            java.util.Date类型日期
	 * @param format
	 *            指定的日期格式
	 * @return String类型日期
	 */
	public static String formatDateYYYYMMDDHHMMSS(java.util.Date date) {
		String result = "";
		if (date != null) {
			try {
				SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMMddHHMMSS");
				result = dateFormater.format(date);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 将java.util.Date类型日期转化为指定格式String HH:MM:SS类型日期
	 * 
	 * @param date
	 *            java.util.Date类型日期
	 * @param format
	 *            指定的日期格式
	 * @return String类型日期
	 */
	public static String formatDateHMS(java.util.Date date) {
		String result = "";
		if (date != null) {
			try {
				SimpleDateFormat dateFormater = new SimpleDateFormat("HH:mm:ss");
				result = dateFormater.format(date);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 将java.util.Date类型日期转化为指定格式的String yyyy-MM-dd HH:MM:SS类型日期
	 * 
	 * @param date
	 *            java.util.Date类型日期
	 * @param format
	 *            指定的日期格式
	 * @return String类型日期
	 */
	public static String formatDateYMDHMS(java.util.Date date) {
		String result = "";
		if (date != null) {
			try {
				SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				result = dateFormater.format(date);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 将java.util.Date类型日期转化为指定格式的String yyyy-MM-dd HH:MM类型日期
	 * 
	 * @param date
	 *            java.util.Date类型日期
	 * @param format
	 *            指定的日期格式
	 * @return String类型日期
	 */
	public static String formatDateYMDHM(java.util.Date date) {
		String result = "";
		if (date != null) {
			try {
				SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				result = dateFormater.format(date);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 将String类型日期转化为指定格式的java.util.Date yyyy-MM-dd类型日期
	 * 
	 * @param dateStr
	 *            String类型日期
	 * @param format
	 *            格式
	 * @return java.util.Date类型日期
	 */
	public static java.util.Date parseDateYMD(String dateStr) {
		java.util.Date date = null;
		try {
			SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
			date = dateFormater.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("日期解析错误:" + dateStr);
		}
		return date;
	}

	/**
	 * 将String类型日期转化为指定格式的java.util.Date yyyy-MM-dd类型日期
	 * 
	 * @param dateStr
	 *            String类型日期
	 * @param format
	 *            格式
	 * @return java.util.Date类型日期
	 */
	public static java.util.Date parseDateYMDHMS(String dateStr) {
		java.util.Date date = null;
		try {
			SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			date = dateFormater.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("日期解析错误:" + dateStr);
		}
		return date;
	}

	/**
	 * 去掉秒的時間
	 * (一句话功能简述)
	 * (功能详细描述)
	 * @author       huangqingjian/0050
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        清清网系统, 2014年8月2日
	 * @param dateStr
	 * @return
	 */
	public static java.util.Date parseDateYMDHM(String dateStr) {
		java.util.Date date = null;
		try {
			SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			date = dateFormater.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("日期解析错误:" + dateStr);
		}
		return date;
	}

	/**
	 * 将String类型日期转化为“yyyy-MM-dd”格式的java.util.Date类型日期
	 * 
	 * @param dateStr
	 *            String类型日期
	 * @return java.util.Date类型日期
	 */
	public static java.util.Date parseDate(String dateStr) {
		return parseDateYMD(dateStr);
	}

	/**
	 * 将java.sql.Date类型日期转化为java.util.Date类型日期
	 * 
	 * @param date
	 *            java.sql.Date类型日期
	 * @return java.util.Date类型日期
	 */
	public static java.util.Date parseDate(java.sql.Date date) {
		return date;
	}

	/**
	 * 将java.util.Date类型日期转化为java.sql.Date类型日期
	 * 
	 * @param date
	 *            java.util.Date类型日期
	 * @return java.sql.Date类型日期
	 */
	public static java.sql.Date parseSqlDate(java.util.Date date) {
		if (date != null)
			return new java.sql.Date(date.getTime());
		else
			return null;
	}

	/**
	 * 将String类型日期转化为指定格式的java.sql.Date类型日期
	 * 
	 * @param dateStr
	 *            String类型日期
	 * @param format
	 *            指定格式
	 * @return java.sql.Date类型日期
	 */
	public static java.sql.Date parseSqlDate(String dateStr, String format) {
		java.util.Date date = parseDateYMD(dateStr);
		return parseSqlDate(date);
	}

	/**
	 * 将String类型日期转化为"yyyy-MM-dd"格式的java.sql.Date类型日期
	 * 
	 * @param dateStr
	 *            String类型日期
	 * @return java.sql.Date类型日期
	 */
	public static java.sql.Date parseSqlDate(String dateStr) {
		return parseSqlDate(dateStr, "yyyy-MM-dd");
	}

	/**
	 * 将String类型日期转化为指定格式的java.sql.Timestamp类型日期
	 * 
	 * @param dateStr
	 *            String类型日期
	 * @param format
	 *            指定格式
	 * @return java.sql.Timestamp类型日期
	 */
	public static java.sql.Timestamp parseTimestampYMDHMS(String dateStr) {
		java.util.Date date = parseDateYMDHMS(dateStr);
		if (date != null) {
			long t = date.getTime();
			return new java.sql.Timestamp(t);
		} else
			return null;
	}

	/**
	 * 将String类型日期转化为"yyyy-MM-dd HH:mm:ss"格式的java.sql.Timestamp类型日期
	 * 
	 * @param dateStr
	 *            String类型日期
	 * @return java.sql.Timestamp类型日期
	 */
	public static java.sql.Timestamp parseTimestamp(String dateStr) {
		return parseTimestampYMDHMS(dateStr);
	}

	/**
	 * 返回年份
	 * 
	 * @param date
	 *            java.util.Date类型日期
	 * @return 返回年份
	 */
	public static int getYear(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.YEAR);
	}

	/**
	 * 返回月份
	 * 
	 * @param date
	 *            java.util.Date类型日期
	 * @return 返回月份
	 */
	public static int getMonth(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.MONTH) + 1;
	}

	/**
	 * 返回日
	 * 
	 * @param date
	 *            java.util.Date类型日期
	 * @return 返回日份
	 */
	public static int getDay(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.DAY_OF_MONTH);
	}

	/**
	 * 返回小时
	 * 
	 * @param date
	 *            java.util.Date类型日期
	 * @return 返回小时
	 */
	public static int getHour(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.HOUR_OF_DAY);
	}

	/**
	 * 返回分钟
	 * 
	 * @param date
	 *            java.util.Date类型日期
	 * @return 返回分钟
	 */
	public static int getMinute(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.MINUTE);
	}

	/**
	 * 返回秒钟
	 * 
	 * @param date
	 *            java.util.Date类型日期
	 * @return 返回秒钟
	 */
	public static int getSecond(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.SECOND);
	}

	/**
	 * 返回毫秒
	 * 
	 * @param date
	 *            java.util.Date类型日期
	 * @return 返回毫秒
	 */
	public static long getMillis(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	/**
	 * 日期相加
	 * 
	 * @param date
	 *            java.util.Date类型日期
	 * @param day
	 *            天数
	 * @return 返回相加后的日期
	 */
	public static java.util.Date addDate(java.util.Date date, int day) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTimeInMillis(getMillis(date) + ((long) day) * 24 * 3600 * 1000);
		return c.getTime();
	}
	
	/**
	 * 
	 * @author       Sandy Wong
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        清清网系统, 2014年8月18日
	 * @param date 参考时间
	 * @param field  单位，可以是Calendar.DAY_OF_MONTH|Calendar.MINUTE|Calendar.SECOND等
	 * @param amount 增加的数量
	 * @return
	 */
	public static java.util.Date addDateTime(java.util.Date date, int field, int amount) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		c.add(field, amount);
		return c.getTime();
	}

	/**
	 * 日期相减
	 * 
	 * @param date
	 *            java.util.Date类型日期
	 * @param date1
	 *            日期
	 * @return 返回相减后的日期
	 */
	public static int diffDate(java.util.Date date, java.util.Date date1) {
		return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));
	}

	/**
	 * 获得月初 格式：yyyy-MM-dd
	 * 
	 */
	public static String getMonthFirstDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		return formatDateY_M_D(calendar.getTime());
	}

	/**
	 * 获得月末 格式：yyyy-MM-dd
	 * 
	 */
	public static String getMonthLastDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return formatDateY_M_D(calendar.getTime());
	}

}
