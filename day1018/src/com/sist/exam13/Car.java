package com.sist.exam13;

public class Car implements Movable{

	public void speedUp(int amount) {
		System.out.println("�ӵ��� "+amount+"�� �ø�����");
	}
	public void speedDown(int amount) {
		System.out.println("�ӵ��� "+amount+"�� ��������");
	}
	
	public void printSpeed() {
		System.out.println(speed);
	}
	//5. �ݵ�� �����Ͽ��� �ϴ� �޼ҵ�
	boolean flag;
	
	public void TurnLeft(boolean flag) {
		if(flag) {
			System.out.println("�������� ���ϼ���");
		}else 
			System.out.println("�����ϼ���");
	}
	public void TurnRight(boolean flag) {
		if(flag) {
			System.out.println("���������� ���ϼ���");
		}else 
			System.out.println("�����ϼ���");
	}
	
	
}
