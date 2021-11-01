package com.sist.net;

import java.io.InputStream;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) {
		
		try {
			//인터넷상의 문서객체 생성
			URL url = new URL("https://www.hanbit.co.kr/store/books/new_book_list.html");
			
			//문서의 내용을 읽어오기 위해 스트림 생성
			InputStream is =  url.openStream();
			
			//한꺼번에 읽어들일 byte형의 배열을 만들기
			byte []data = new byte[100];
			
			//스트림을 통해 읽어온 문자열을 다 모아놓을 변수를 만들기
			String str = "";
			
			//스트림의 끝이 아닐때까지 100바이트씩 읽어들임
			while( is.read(data) != -1 ) {
				
				//읽어들인 byte배열의 데이터를 문자열로 만들어 누적
				str += new String(data,"utf-8");
			}
			
			//전체 누적된 문자열 변수를 출력
			System.out.println(str);
			
			//스트림 닫기
			is.close();
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}

}
