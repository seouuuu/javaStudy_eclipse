package com.sist.exam08;

public class MyDateTest {

	public static void main(String[] args) {
		try {
			String data =null;
			MyDate date = new MyDate(data);
			
			
			
			
		}catch(IllegalArgumentException i) {
			System.out.println("예외발생: "+i.getMessage());
			
		}
		
	}

}
