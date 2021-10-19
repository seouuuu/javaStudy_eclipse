package com.sist.exam04;

public class StringTestTrim {

	public static void main(String[] args) {
		String data = "   java   ";
		int n = data.length();
		System.out.println(n);      //10
		String data2 = data.trim();
		int n2 = data2.length();
		System.out.println(n2);     //4
		System.out.println("|"+data+"|");    //|   java   |
		System.out.println("|"+data2+"|");   //|java|
		
		data = data.trim();
		System.out.println("|"+data+"|");    //|java|
	}
}
