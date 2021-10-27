package com.sist.product2;

//생산자를 위한 클래스
public class Producer extends Thread {
	
	//제품을 위한 클래스를 맴버변수로 선언
	private Product product;

	//생산자 객체 생성시 제품객체를 매개변수로 전달받아 맴버변수 제품 초기화
	public Producer(Product product) {
		this.product = product;
	}
	
	//생산자 클래스는 계속하여 새로운 제품을 생성하기 위한 메소드를 호출시키기 위해 
	//스레드가 해야하는 일을 run메소드를 오버라이딩 하여 작성
	public void run() {
		//10개의 새로운 제품을 생산
		for(int i=1; i<=10; i++) {
			product.makeNumber();//새로운 제품(정수)을 생산하기 위해 제품 객체의 makeNumber메소드 호출
			try {
				Thread.sleep(200);
			}catch(Exception e) {	
			}
		}
	}
}
