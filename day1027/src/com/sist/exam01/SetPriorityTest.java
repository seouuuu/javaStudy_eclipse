package com.sist.exam01;

public class SetPriorityTest {

	public static void main(String[] args) {
				
		Person kim = new Person("������");
		Person hong = new Person("ȫ�浿");
		Person lee = new Person("�̼���");
		//lee.setPriority(10);  ����
		lee.setPriority(Thread.MAX_PRIORITY);
		//�ְ�켱������ �����Ͽ��ٰ� �ݵ�� ���� ���� ���� ������ ���� ���� ���� ����
		//������ ���� ���� ������� "���޼�"�� �����ϴ� �� ��

		kim.start();
		hong.start();
		lee.start();
		
		//kim,hong,lee �����尡 ��� ���������� ���
		try {
			kim.join();
			hong.join();
			lee.join();
		}catch (Exception e) {
		}
		
		System.out.println("�������� �켱����:"+ kim.getPriority());		//5
		System.out.println("ȫ�浿�� �켱����:"+ hong.getPriority());	//5
		System.out.println("�̼����� �켱����:"+ lee.getPriority());		//10
	}

}
