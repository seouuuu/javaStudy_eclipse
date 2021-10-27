package com.sist.ars;

public class TVArsTest {

	public static void main(String[] args) {
		//모금액 계좌 생성
		Account account = new Account();
		
		//5명의 기부자 객체 생성, 위의 계좌 전달
		Donor d1 = new Donor("홍길동",account);
		Donor d2 = new Donor("이순신",account);
		Donor d3 = new Donor("강감찬",account);
		Donor d4 = new Donor("김유신",account);
		Donor d5 = new Donor("유관순",account);
		
		//5명의 기부자들이 공평하게 입금하도록 스레드 가동
		d1.start();
		d2.start();
		d3.start();
		d4.start();
		d5.start();
		
		//스레드 작업 완료까지 대기하기 위해 join메소드 호출
		try {
			d1.join();
			d2.join();
			d3.join();
			d4.join();
			d5.join();
		}catch(Exception e) {
		}
		
		System.out.println("전체모금액: "+account.getBalance());
	}
}
