package com.sist.exam01;

import java.util.Date;
import java.util.Scanner;

public class PrintCalendarThisMonth {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("연도를 입력하세요==>");
		int year = sc.nextInt()-1900;
		System.out.println("월을 입력하세요==>");
		int month = sc.nextInt()-1;
		
		
		Date startDate = new Date(year,month,1);  
		int day = startDate.getDay();
		
		System.out.printf("%d년 %d월\n",year+1900,month+1);

		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		for(int i=1;i<=day;i++) {
			System.out.print("\t");
		}
		
		int []lastDate = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		for(int i=1; i<=lastDate[month];i++) {
			System.out.print(i+"\t");
			if( (i+day) % 7 == 0 ) {
				System.out.println();
			}
		
		}
	}
}
		
		


