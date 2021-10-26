package com.sist.exam10;

public class Exam extends Thread {
	public void run() {
		for(int i=20;i>=1;i--) {
			System.out.printf("%d초 전입니다.\n",i);
			
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
			}
		}
		
	}
}
