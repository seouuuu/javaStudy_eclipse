package com.sist.exam05;

import java.util.Date;

public class PrintCalendarThisMonth {

	public static void main(String[] args) {
		Date today = new Date();
		int year = today.getYear();
		int month = today.getMonth();
		
		Date startDate = new Date(year,month,1);  //요일 구해야하니 year,month 그대로
		int day = startDate.getDay();
		
		System.out.printf("%d년 %d월\n",year+1900,month+1);
		
		//요일출력
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		//달의 1일의 요일만큼 빈칸 출력
		for(int i=1;i<=day;i++) {
			System.out.print("\t");
		}
		
		int []lastDate = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		for(int i=1; i<=lastDate[month];i++) {
			System.out.print(i+"\t");
			if( (i+day) % 7 == 0 ) {
				System.out.println();
			}
		
		/*
		if(month ==0|| month ==2|| month ==4|| month ==6|| month == 7 || month ==9|| month == 11) {
			for(int i=1; i<=31;i++) {
				System.out.print(i+"\t");
				if( (i+day) % 7 == 0 ) {
					System.out.println();
				}
			}
		}else if(month ==3|| month ==5|| month ==8|| month ==10) {
			for(int i=1; i<=30;i++) {
				System.out.print(i+"\t");
				if( (i+day) % 7 == 0 ) {
					System.out.println();
				}
			}
		}else if (month ==1) {
			for(int i=1; i<=28;i++) {
				System.out.print(i+"\t");
				if( (i+day) % 7 == 0 ) {
					System.out.println();
				}
			}
		}
		*/
		}
	}
}
		
		


