package com.sist.exam12;

public class CountDown extends Thread {
	public void run() {
		for(int i=20; i>0;i--) {
			System.out.println(i+"초 전입니다.");
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				
			}
		}
	}
}

