package com.sist.exam02;

public class MyDateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//String data = "2022/3/11";
			String data = null;
			MyDate lastdate = new MyDate(data);
			int year = lastdate.getYear();
			int month = lastdate.getMonth();
			int date = lastdate.getDate();
			System.out.printf("수료일은 %d년 %d월 %d일입니다.\n",year,month,date);
			
		}catch(IlleagalArgumentException e) {
			//System.out.println("예외발생:"+e.getMessage());
			e.printStackTrace();
		}

	}

}
