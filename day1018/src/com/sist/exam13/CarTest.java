package com.sist.exam13;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car();
		car.speedUp(200);
		car.speedDown(100);
		car.TurnLeft(false);
		car.TurnRight(true);
		car.printSpeed();
		
		Movable m = new Car();
		//m.printSpeed();
	
		//m.speedUp();     �Ұ���
		//m.TurnLeft();    �Ұ���
		//Car c = m;       �Ұ��� 
		//Car c = (Car)m;   �Ұ���
		//Car c = new Car();  �Ұ���
		//Movable m = c;       �Ұ���
		//Movable m = (Movable)c; �Ұ���
		
	}

}
