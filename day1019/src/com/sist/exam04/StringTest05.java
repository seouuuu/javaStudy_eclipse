package com.sist.exam04;

public class StringTest05 {
	public static void main(String[] args) {
		String data = new String("hello");
		String data2 = data.concat("korea");

		System.out.println(data);		//hello
		System.out.println(data2);		//hellokorea
	}
}
