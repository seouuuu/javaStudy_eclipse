package com.sist.exam01;

public class SetPriorityTest {

	public static void main(String[] args) {
				
		Person kim = new Person("김유신");
		Person hong = new Person("홍길동");
		Person lee = new Person("이순신");
		//lee.setPriority(10);  가능
		lee.setPriority(Thread.MAX_PRIORITY);
		//최고우선순위를 설정하였다고 반드시 일이 가장 먼저 끝나는 것이 보장 되지 않음
		//가급적 일을 빨리 끝내라고 "응급성"을 설정하는 것 뿐

		kim.start();
		hong.start();
		lee.start();
		
		//kim,hong,lee 스레드가 모두 끝날때까지 대기
		try {
			kim.join();
			hong.join();
			lee.join();
		}catch (Exception e) {
		}
		
		System.out.println("김유신의 우선순위:"+ kim.getPriority());		//5
		System.out.println("홍길동의 우선순위:"+ hong.getPriority());	//5
		System.out.println("이순신의 우선순위:"+ lee.getPriority());		//10
	}

}
