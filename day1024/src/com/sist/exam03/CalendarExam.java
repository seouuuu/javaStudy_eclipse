package com.sist.exam03;

import java.util.GregorianCalendar;

public class CalendarExam {

	public static void main(String[] args) {
		
		GregorianCalendar today = new GregorianCalendar();
		int year = today.get(GregorianCalendar.YEAR);
		int month = today.get(GregorianCalendar.MONTH);
		
		GregorianCalendar startdate = new GregorianCalendar(year,month,1);
		int day = startdate.get(GregorianCalendar.DAY_OF_WEEK);
		
		System.out.printf("%d�� %d��\n",year,month+1);
		
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
		
		for(int i=1;i<day;i++) {
			System.out.print("\t");
		}
		
		int []lastdate = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		for(int i=1; i<=lastdate[month];i++ ) {
			System.out.print(i +"\t");
			if((i+day-1)%7 == 0 ) {
				System.out.println();
			}
		}

	}

}
