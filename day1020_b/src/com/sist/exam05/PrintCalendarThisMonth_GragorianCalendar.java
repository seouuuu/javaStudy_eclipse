package com.sist.exam05;

import java.util.GregorianCalendar;
//GregorianCalendar 이용
public class PrintCalendarThisMonth_GragorianCalendar {

	public static void main(String[] args) {
		GregorianCalendar today = new GregorianCalendar();
		int year = today.get(GregorianCalendar.YEAR);           //연도
		int month  = today.get(GregorianCalendar.MONTH);        //월
		
		GregorianCalendar startDate = new GregorianCalendar(year,month,1); //1일 설정
		int day = startDate.get(GregorianCalendar.DAY_OF_WEEK);        //day-1 해야함
		
		System.out.printf("%d년 %d월\n",year,month+1);
		
		//요일출력
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		//달의 1일의 요일만큼 빈칸 출력
		for(int i=1;i<day;i++) {             //day-1이니 등호제외
			System.out.print("\t");
		}
		
		int []lastDate = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		for(int i=1; i<=lastDate[month];i++) { 
			System.out.print(i+"\t");
			if( (i+day-1) % 7 == 0 ) {       //day-1
				System.out.println();
			}
		}
	}
}
