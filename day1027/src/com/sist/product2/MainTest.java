package com.sist.product2;

public class MainTest {

	public static void main(String[] args) {
		//제품 객체 생성
		Product product = new Product();
		
		//생산자 스레드 객체 생성
		Producer producer = new Producer(product);
		
		//소비자 스레드 객체 생성
		Consumer consumer = new Consumer(product);
		
		//생산자와 소비자 가동
		producer.start();
		consumer.start();
	}
}
