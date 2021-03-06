package com.sist.product2;
//wait, notify 없을때
import java.util.Random;

//생산자와 소비자가 공유할 제품 클래스
public class Product {
	
	//생산되는 제품을 임의의 정수로 함
	int number;
	
	//제품을 새로 생산하였는지 소비하였는지 판별하기 위한 변수
	//생산자가 새로운 제품을 생산하면 true 설정
	//소비자가 제품을 소비하면 false 설정
	public boolean isNew = false;
	
	//생산자가 사용할 새로운 제품을 생성하는 메소드 정의
	//생산자가 제품을 생산하고 있는 동안 소비자가 접근할 수 없도록 하기 위해 임계영역으로 설정
	public synchronized void makeNumber() {
		
		//새로운 제품(정수)은 난수로 만들기
		Random r = new Random();
		number = r.nextInt(100);	//새로운 제품 생산
		System.out.println("생산자가 새로운 제품 생성 ==>" + number);
					
	}
	
	//소비자가 사용할 제품을 소비하기 위한 메소드 정의
	public synchronized int getNumber() {
		
		System.out.println("소비자가 제품 소비==>"+ number);	//소비자가 제품을 소비
		
		return number;
	}
}
