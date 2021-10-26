package com.sist.exam14;

import java.util.Date;

public class TimeHello extends Thread {
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("안녕하세요");
			Date t = new Date();
			int hours = t.getHours();
			int minutes = t.getMinutes();
			int seconds = t.getSeconds();
		
			System.out.printf("현재시간은 %d시 %d분 %d초 입니다.\n",hours,minutes,seconds);
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
			}
		}
	}

}
