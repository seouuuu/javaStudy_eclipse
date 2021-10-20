package com.sist.exam05;

import java.util.Date;

public class System_CurrentTime {

	public static void main(String[] args) {
		long data = System.currentTimeMillis();
		// 현재날짜와 시간의 정보를 밀리세컨으로 읽어옴
		
		System.out.println(data); 
		//1634715388545
		//1634715423806
		//난수만드는 용도로도 사용
		
		Date today = new Date(data);
		
		//long data2 = 1634715388545;
		//자바는 정수형 값이 오면 무조건 int 취급
		//int형의 범위를 넘어서 오류
		//정수형값에 long을 표시하기 위해 값뒤에 접미사 l을 붙임
		
		long data2 = 1634715388545l; 
		Date date = new Date(data2);
		
		System.out.printf("지금시간:%d시%d분%d초",today.getHours(),today.getMinutes(),today.getSeconds());
		System.out.printf(", 이전시간:%d시%d분%d초",date.getHours(),date.getMinutes(),date.getSeconds());
	}
}
