package com.sist.exam04;

public class StringTestEquals {

	public static void main(String[] args) {
		String data1 = new String("홍길동");
		String data2 = new String("홍길동");
		/*
		if(data1==data2) {  //참조자료형에서 ==는 같은 메모리를 바라보는지 판별
			System.out.println("서로 같아요");
		}else
			System.out.println("서로 달라요");
	   //서로 달라요 출력
	*/
		if(data1.equals(data2)) {  //참조자료형에서 ==는 같은 메모리를 바라보는지 판별
			System.out.println("서로 같아요");
		}else
			System.out.println("서로 달라요");
		 // 서로 같아요 출력
		
		System.out.println("------------------------------");
		
		String name1 = new String("tiger");
		String name2 = new String("Tiger");
		
		if(name1.equals(name2)) {
			System.out.println("이름이 tiger로 같아요");
		} else
			System.out.println("이름이 같지 않아요");
		
System.out.println("------------------------------");
		
		String name3 = new String("tiger");
		String name4 = new String("Tiger");
		
		if(name4.equalsIgnoreCase(name4)) {
			System.out.println("이름이 tiger로 같아요");
		} else
			System.out.println("이름이 같지 않아요");
		
	}
}
