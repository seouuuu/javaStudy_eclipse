package com.sist.exam13;

public class CountDown extends Thread {
	public void run() {
		for(int i=20; i>0;i--) {
			System.out.println(i+"�� ���Դϴ�.");
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
			}
		}
		System.out.println("�߻�!!");
	}
}

