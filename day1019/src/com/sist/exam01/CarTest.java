package com.sist.exam01;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Car car = new Car("K5", "흰색");
		//car.speedUp(100);
		//car.speedDown(50);
		
		Movable m = new Car();
		//인터페이스도 클래스와 마찬가지로 자료형의 개념
		//인터페이스와 인터페이스를 구현한 클래스는 상속관계에 있음
		//상위인터페이스의 참조변수가 자식클래스의 객체를 참조할 수 있음
		
		m.speedUp(100);
		m.speedDown(50);
		//상속관계에 있는 부모의 참조변수가 자식클래스의 객체를 참조할 때
		//부모클래스에 원래 있는 메소드 호출가능,자식클래스에서 오버라이딩한 메소드 동작
		
		//m.turnLeft();
		//상속관계에 있는 부모의 참조변수가 자식클래스의 객체를 참조할 때
		//자식클래스에 새롭게 추가된 메소드 호출 불가
		//자식클래스로 형변환하여 호출 가능
		
		((Car)m).turnLeft();
		((Car)m).turnRight();
		
		//Car c = m; 
		//불가능
		
		//Car c =(Car)m; 
		//가능
		//상속관계에 있는 부모의 참조변수가 자식클래스의 객체를 참조하고 있는 경우
		//자식클래스로 형변환하여 자식클래스의 참조변수에 대입가능
		
		Car c = new Car();
		//가능
		
		Movable m2 = c;
		//가능
		//상속관계에 있을때 부모의 참조변수가 자식클래스의 객체를 참조가능
		
		Movable m3 = (Movable)c;
		//가능
		//상속관계에 있을때 자식클래스의 객체를 부모의 자료형으로 형변환 가능
		
		
	}

}
