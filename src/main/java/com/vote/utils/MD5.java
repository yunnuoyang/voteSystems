package com.vote.utils;

import org.apache.tomcat.util.security.MD5Encoder;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5 {
	public static void main(String[] args) {
		String string="111111";
		String string2 =MD5Encoder.encode(string.getBytes());
		// 输出结果32位
		System.out.println(string2+" len >>> "+string2.length());
		
		//对密码123加密
		String string3 ="123";
		String encodingStr=encoding(string3);
		System.out.println("密文》》》"+ encodingStr.length()+" "+encoding(string3));
	}
	
	// 自己写一个,使用md5的机制对字符串进行加密	
	public static String encoding(String string){
//		String string ="h";
		try {
				MessageDigest messageDigest = MessageDigest.getInstance("md5");
				byte[] md5  = messageDigest.digest(string.getBytes());//核心算法   不然看的// 一个字节  转成整数
				BigInteger bigInteger = new BigInteger(1, md5);
				String md5_str = bigInteger.toString(16);
//				System.out.println(md5_str);
				return md5_str;
			} catch (Exception e) {
					e.printStackTrace();
					System.out.println("没有MD5算法");
			}
		return null;
	}
}
