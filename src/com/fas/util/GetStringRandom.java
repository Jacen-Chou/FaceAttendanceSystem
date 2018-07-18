package com.fas.util;

import java.util.Random;

public class GetStringRandom {

	/**
	 * 
	 * @Title: getStringRandom 
	 * @Description: 生成length长度的字母数字随机串
	 * @param length
	 * @return      
	 */
	public static String getStringRandom(int length) {

		String value = "";
		Random random = new Random();

		//参数length，表示生成几位随机数
		for (int i = 0; i < length; i++) {

			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			//输出字母还是数字
			if ("char".equalsIgnoreCase(charOrNum)) {
				//输出是大写字母还是小写字母
				int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
				value += (char) (random.nextInt(26) + temp);
			} else if ("num".equalsIgnoreCase(charOrNum)) {
				value += String.valueOf(random.nextInt(10));
			}
		}
		return value;
	}
	
}
