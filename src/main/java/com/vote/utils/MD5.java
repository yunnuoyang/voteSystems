package com.vote.utils;

import org.apache.tomcat.util.security.MD5Encoder;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5 {
	public static void main(String[] args) {
		String string="111111";
		String string2 =MD5Encoder.encode(string.getBytes());
		// ������32λ
		System.out.println(string2+" len >>> "+string2.length());
		

		String string3 ="123";
		String encodingStr=encoding(string3);
		System.out.println("���ġ�����"+ encodingStr.length()+" "+encoding(string3));
	}
	
	// �Լ�дһ��,ʹ��md5�Ļ��ƶ��ַ������м���	
	public static String encoding(String string){
//		String string ="h";
		try {
				MessageDigest messageDigest = MessageDigest.getInstance("md5");
				byte[] md5  = messageDigest.digest(string.getBytes());//�����㷨   ��Ȼ����// һ���ֽ�  ת������
				BigInteger bigInteger = new BigInteger(1, md5);
				String md5_str = bigInteger.toString(16);
//				System.out.println(md5_str);
				return md5_str;
			} catch (Exception e) {
					e.printStackTrace();
					System.out.println("û��MD5�㷨");
			}
		return null;
	}
}
