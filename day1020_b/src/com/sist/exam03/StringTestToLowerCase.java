package com.sist.exam03;

public class StringTestToLowerCase {

	public static void main(String[] args) {
		String data = "Converts all of the characters in this String to lower case using the rules of the default locale.";
		String data2 = data.toLowerCase();
		String data3 = data.toUpperCase();
		System.out.println(data);  //data는 변동 없음
		System.out.println(data2);
		System.out.println(data3);
	}

}
