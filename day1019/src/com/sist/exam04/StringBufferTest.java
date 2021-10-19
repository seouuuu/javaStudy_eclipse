package com.sist.exam04;

public class StringBufferTest {
	public static void pro(String str) {
		System.out.println("처리하는 문자열은 "+str+"입니다.");
	}
	
	public static void main(String[] args) {
		StringBuffer data = new StringBuffer("hello");  //A
		data.append("korea");                           //B
		
		System.out.println(data);
		
		pro(new String(data));
		//또는
		String r = new String(data);
		pro(r);
		
	//pro(data);
	//pro메소드는 String을 매개변수로 갖기 때문에 StringBuffer를 전달할수 없음
	}
	//A의 data와 B의 data는 같은 메모리를 참조
	//StringBuffer의 내용을 변경해도 새로운 메모리를 만들지 않고 기존 객체내용이 변경됨
	//변하는 문자열 처리에는 StringBuffer 혹은 StringBuilder 사용
		
	//StringBuffer를 매개변수로 전달하여 어떤 메소드를 사용할때는
	//다시 String으로 변환해야하는 경우가 많음
	//문자열을 매개변수로 받아 처리하는 대부분의 메소드는 String을 받도록 하는 것이 일반적
	
	//String 생성자 중 StringBuffer를 매개변수로 갖는 생성자 이용
}
