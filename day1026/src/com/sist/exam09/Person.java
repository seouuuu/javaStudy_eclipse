package com.sist.exam09;

public class Person implements Runnable {
	
	private String name;
	public Person(String name) {
			this.name = name;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1; i<=10; i++) {
			System.out.println("�ȳ�,"+name+"==>"+i);
			
			try {
				Thread.sleep(100);
			}catch(Exception e) {
				
			}
			
		}
	}

}
