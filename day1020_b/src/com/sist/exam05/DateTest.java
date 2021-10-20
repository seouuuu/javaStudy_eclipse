package com.sist.exam05;

import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		
		Date today = new Date();
		int year = today.getYear() + 1900;
		int month = today.getMonth() +1;
		int date = today.getDate();
		int hours = today.getHours();
		int minutes = today.getMinutes();
		int seconds = today.getSeconds();
		int day = today.getDay();
		//코드에 취소선이 그어지는 것은 Calendar나 GregorianCalendar 사용 권장
		
		String []arr = {"일","월","화","수","목","금","토"};
		String data = arr[day];
		
		
		/*
		String str = "";
		switch(day) {
		case 0: str = "일";break;
		case 1: str = "월";break;
		case 2: str = "화";break;
		case 3: str = "수";break;
		case 4: str = "목";break;
		case 5: str = "금";break;
		case 6: str = "토";break;
		}
		*/
		
		System.out.println(day);
		System.out.printf("현재는 %d년 %d월 %d일(%s요일) %d시 %d분 %d초입니다.\n",year,month,date,data,hours,minutes,seconds);
		
		System.out.println("-------------------------------------");
		//특정날짜의 요일 구하기
		int birthYear = 1995;
		int birthMonth = 7;
		int birthDate = 29;
		Date Date2 = new Date(birthYear-1900, birthMonth-1,birthDate);   //연도-1900/month인덱스 0부터이기때문에 -1
		int birthday = Date2.getDay();
		System.out.print(arr[birthday]);
		
		
		
	}
}
