package com.fas.util;

import java.util.Random;

public class GetStringRandom {

	/**
	 * 
	 * @Title: getStringRandom 
	 * @Description: ����length���ȵ���ĸ���������
	 * @param length
	 * @return      
	 */
	public static String getStringRandom(int length) {

		String value = "";
		Random random = new Random();

		//����length����ʾ���ɼ�λ�����
		for (int i = 0; i < length; i++) {

			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			//�����ĸ��������
			if ("char".equalsIgnoreCase(charOrNum)) {
				//����Ǵ�д��ĸ����Сд��ĸ
				int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
				value += (char) (random.nextInt(26) + temp);
			} else if ("num".equalsIgnoreCase(charOrNum)) {
				value += String.valueOf(random.nextInt(10));
			}
		}
		return value;
	}
	
}
