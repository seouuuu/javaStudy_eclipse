package com.sist.exam02;

public class StringBufferExam {

	public static void print(String s) {
		System.out.println("처리하는 문자열은 "+s+"입니다.");
	}
	
	public static void main(String[] args) {
		StringBuffer data = new StringBuffer("hello");
		data.append("java");
		
		System.out.println(data);
		
		//String r = new String(data);
		//print(r);
		print(new String (data));
	}

}
