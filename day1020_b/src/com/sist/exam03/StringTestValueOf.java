package com.sist.exam03;

public class StringTestValueOf {
	public static void pro(String str) {
		System.out.println(str);
	} // String을 매개변수로 가지는 메소드

	public static void main(String[] args) {
		int data = 2021;
		//pro(data); data는 정수형이기 때문에 pro 호출시 String으로 변환해야함 
		pro(String.valueOf(data));
		pro(data+"");
	}
}
