package com.sist.exam04;

public class StringTestSubstring {

	public static void main(String[] args) {
		String data = "abcdefghijklmn";
		String data2 = data.substring(3,8);   //defgh
		String data3 = data.substring(8);     //ijklmn
		System.out.println(data2);
		System.out.println(data3);
		
		String url = "https://docs.oracle.com/javase/8/docs/api/index.html";
		//url로부터 문서명 "index.html" 출력
		System.out.println(url.substring(url.lastIndexOf("index.html")));
		System.out.println(url.substring(url.lastIndexOf("/")+1));
	}
}
