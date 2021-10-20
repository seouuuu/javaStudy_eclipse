package com.sist.exam05;

import java.util.GregorianCalendar;
import java.util.Scanner;
public class PrintCalendarExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("연도를 입력하세요==>");
		int year = sc.nextInt();
		System.out.print("월을 입력하세요==>");
		int month = sc.nextInt();
		
		GregorianCalendar user = new GregorianCalendar(year,month-1,1); //month-1
		int day = user.get(GregorianCalendar.DAY_OF_WEEK);
		
		System.out.printf("%d년 %d월\n",year,month);          //month에 1 더하면 안됨
		
		//요일출력
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		//달의 1일의 요일만큼 빈칸 출력
		for(int i=1;i<day;i++) {                          //day-1이니 등호제외
			System.out.print("\t");
		}
		
		int []lastDate = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		for(int i=1; i<=lastDate[month-1];i++) {         //month-1
			System.out.print(i+"\t");
			if( (i+day-1) % 7 == 0 ) {                   //day-1
				System.out.println();
			}
		}
	}
}
