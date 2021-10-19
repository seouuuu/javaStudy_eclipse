package com.sist.exam04;

public class StringTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String data = new String("안녕하세요");
		String data2 = "안녕하세요";
		System.out.println(data);
		System.out.println(data2);
		
		byte[]arr = data.getBytes();
		for(byte b : arr) {
			System.out.println(b);
		}
		
		String result = new String(arr);
		System.out.println(result);
		// 네트워크 통신이나 파일로 자료를 저장할때 문자열데이터를 byte형으로 전환하여 전송
		// 전송받은 byte형의 배열을 다시 String으로 만들기 위해 
		//byte 배열을 매개변수로 가지는 String 생성자 이용
		//String 데이터를 byte으로 변환하기 위해 getByte()이용
	}
}
