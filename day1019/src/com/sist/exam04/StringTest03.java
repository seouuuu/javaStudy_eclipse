package com.sist.exam04;

public class StringTest03 {

	public static void main(String[] args) {
		
		String data = new String("hello");    //A
		data = data + "korea";                //B
		
		System.out.println(data);
		
		//A에서 data가 참조하는 객체와
		//B에서 data가 참조하는 객체는 다름
		//String에 내용을 변경시키면 새로운 메모리를 잡음
		//String에 데이터를 변경시킬때마다 기비지가 생성됨
		//변하는 문자열 처리에는 StringBuffer나 StringBuilder를 이용함
		
	}
}
