package com.sist.exam11;

public class Exam implements Runnable {

	@Override
	public void run() {
		for(int i=20;i>=1;i--) {
			System.out.printf("%d�� ���Դϴ�.\n",i);
			
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
			}
		}
		
	}

}
