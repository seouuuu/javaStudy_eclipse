package com.sist.exam13;

public interface Movable {
	public void speedUp(int amount);
	public void speedDown(int amount);
	
	final int speed = 100;
	/*
	public void printSpeed() {
		
	}
	*/

}


//1. �޼ҵ带 ������ �� abstract �����Ͽ��� �Ǵ��� ���� - ����
//2. int speed �����߰� - �ʱ�ȭ �� �� ����
//3. int speed = 100; - ����
//   final int speed = 100; - ����
//4. printSpeed() �޼ҵ� �߰� - public void printSpeed(); ����
/*
 public void printSpeed() {
		System.out.println(speed);
	}
	�Ұ���
	*/ 
