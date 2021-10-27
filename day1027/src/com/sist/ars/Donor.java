package com.sist.ars;

//기부자를 위한 클래스를 스레드를 상속받아 구현
public class Donor extends Thread {
	private Account tvArs;		//기부자의 이름을 위한 맴버변수
	private String name;		//기부자들의 모금액을 공유하기 위해 맴버변수로 선언
	
	//기부자 객체 생성시 기부자의 이름과 공유할 모금액 객체를 매개변수로 전달받아 맴버변수에 설정
	public Donor(String name, Account tvArs) {
		this.tvArs = tvArs;
		this.name = name;
	}
	
	//스레드가 해야할 일을 run을 오버라이딩 하여 작성
	public void run() {
		for(int i=1; ;i++){			//계속 반복
			
			//입금하기 전 모금액이 100만원이 넘으면 반복문을 탈출하도록 함
			if(tvArs.getBalance() >= 1000000) {
				break;
			}
			
			tvArs.deposit(10000);	//모금액 객체에 10000원씩 입금
			System.out.println(name + "이(가) "+i +"번째 입금하였습니다.");	//입금 순서 출력
			try {
				Thread.sleep(200);		//0.2초 대기
			}catch(Exception e) {
			}
		}
	}
}
