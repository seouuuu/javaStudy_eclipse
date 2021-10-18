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
	
		//m.speedUp();     불가능
		//m.TurnLeft();    불가능
		//Car c = m;       불가능 
		//Car c = (Car)m;   불가능
		//Car c = new Car();  불가능
		//Movable m = c;       불가능
		//Movable m = (Movable)c; 불가능
		
	}

}
