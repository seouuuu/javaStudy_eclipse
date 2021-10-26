package com.sist.exam11;

public class CountDownTest {

	public static void main(String[] args) {
		CountDown c = new CountDown();
		new Thread(c).start();
		
	}

}
