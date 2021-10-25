package com.sist.exam08;

public class MyDateTest {

	public static void main(String[] args) {
		try {
			MyDate date = new MyDate();
			date.mydate("2021/10/25");
			
			
			
		}catch(IllegalArgumentException i) {
			System.out.println("예외발생: "+i.getMessage());
			
		}
		
	}

}
