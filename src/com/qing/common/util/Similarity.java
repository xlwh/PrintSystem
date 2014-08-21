package com.qing.common.util;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * 比较两个字符串的相似度 
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        , 2014年8月12日
 */
public class Similarity {

	/**
	 * 测试方法
	 * (一句话功能简述)
	 * (功能详细描述)
	 * @author       张洪斌
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        , 2014年8月12日
	 * @param args
	 */
	public static void main(String[] args) {

		String strA = "礼仪/模特";

		String strB = "模特/礼仪";

		double result = SimilarDegree(strA, strB);
		if (result >= 0.5) {

			System.out.println("相似度很高！" + similarityResult(result) + result);

		} else {

			System.out.println("相似度不高" + similarityResult(result) + result);

		}

		System.out.println();

	}

	/**
	 * 相似度转百分比 
	 * (一句话功能简述)
	 * (功能详细描述)
	 * @author       张洪斌
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        , 2014年8月12日
	 * @param resule
	 * @return
	 */
	public static String similarityResult(double resule) {

		return NumberFormat.getPercentInstance(new Locale("en ", "US ")).format(resule);

	}

	/**
	 * 相似度比较 
	 * (一句话功能简述)
	 * (功能详细描述)
	 * @author       张洪斌
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        , 2014年8月12日
	 * @param strA
	 * @param strB
	 * @return
	 */
	public static double SimilarDegree(String strA, String strB) {

		String newStrA = removeSign(strA);

		String newStrB = removeSign(strB);

		int temp = Math.max(newStrA.length(), newStrB.length());

		int temp2 = longestCommonSubstring(newStrA, newStrB).length();

		return temp2 * 1.0 / temp;

	}

	/**
	 * 将字符串转成char类型
	 * (一句话功能简述)
	 * (功能详细描述)
	 * @author       张洪斌
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        , 2014年8月12日
	 * @param str
	 * @return
	 */
	private static String removeSign(String str) {

		StringBuffer sb = new StringBuffer();

		for (char item : str.toCharArray())

			if (charReg(item)) {
				sb.append(item);
			}

		return sb.toString();
	}

	/**
	 * 判断是否在汉子和拼音字符范围内
	 * (一句话功能简述)
	 * (功能详细描述)
	 * @author       张洪斌
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        , 2014年8月12日
	 * @param charValue
	 * @return
	 */
	private static boolean charReg(char charValue) {

		return (charValue >= 0x4E00 && charValue <= 0X9FA5)

		|| (charValue >= 'a' && charValue <= 'z')

		|| (charValue >= 'A' && charValue <= 'Z')

		|| (charValue >= '0' && charValue <= '9');

	}

	/**
	 * 具体切割实现
	 * (一句话功能简述)
	 * (功能详细描述)
	 * @author       张洪斌
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        , 2014年8月12日
	 * @param strA
	 * @param strB
	 * @return
	 */
	private static String longestCommonSubstring(String strA, String strB) {

		char[] chars_strA = strA.toCharArray();

		char[] chars_strB = strB.toCharArray();

		int m = chars_strA.length;

		int n = chars_strB.length;

		int[][] matrix = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {

			for (int j = 1; j <= n; j++) {

				if (chars_strA[i - 1] == chars_strB[j - 1])

					matrix[i][j] = matrix[i - 1][j - 1] + 1;

				else

					matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);

			}

		}

		char[] result = new char[matrix[m][n]];

		int currentIndex = result.length - 1;

		while (matrix[m][n] != 0) {

			if (matrix[n] == matrix[n - 1])

				n--;

			else if (matrix[m][n] == matrix[m - 1][n])

				m--;

			else {

				result[currentIndex] = chars_strA[m - 1];

				currentIndex--;

				n--;

				m--;

			}
		}

		return new String(result);

	}

}