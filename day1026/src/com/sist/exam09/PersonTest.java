package com.sist.exam09;

public class PersonTest {

	public static void main(String[] args) {
		
		Person p = new Person("ȫ�浿");
		Person p2 = new Person("�̼���");
		
		//p.start();
		//Runnable �������̽����� start�޼ҵ尡 ����
		//Thread ��ü�� �����ؼ� start()�� ȣ��
		
		/*
		Thread t = new Thread(p);
		Thread t2 = new Thread(p2);
		t.start();
		t2.start();
		*/
		
		new Thread(p).start();
		new Thread(p2).start();
	}

}
