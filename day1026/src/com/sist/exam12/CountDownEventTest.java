package com.sist.exam12;

import com.sist.exam10.CountDown;

public class CountDownEventTest {

	public static void main(String[] args) {
		
		CountDown c = new CountDown();
		c.start();
		CountDownEvent e = new CountDownEvent(3, "������ġ�и�");
		e.start();
		CountDownEvent e2 = new CountDownEvent(20, "�߻�!!");
		e2.start();
		
	}
}
