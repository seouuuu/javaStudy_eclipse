package com.sist.exam14;

import java.util.Date;

public class TimeHello extends Thread {
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("�ȳ��ϼ���");
			Date t = new Date();
			int hours = t.getHours();
			int minutes = t.getMinutes();
			int seconds = t.getSeconds();
		
			System.out.printf("����ð��� %d�� %d�� %d�� �Դϴ�.\n",hours,minutes,seconds);
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
			}
		}
	}

}
