package com.sist.exam01;

public class Person extends Thread {
	private String name;
	public Person(String name) {
		this.name = name;
	}
	
	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.println("�ȳ�, "+ name + "==>" + i);
			
			try {
				Thread.sleep(200);
			}catch(Exception e) {
			}
		}
	}
}
