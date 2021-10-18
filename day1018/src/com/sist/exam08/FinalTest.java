package com.sist.exam08;

class Person{
	public String name ="홍길동";
	public static final String addr = "서울시 마포구 서교동";
}

public class FinalTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person father = new Person();
		Person son = new Person();
		System.out.println(Person.addr);
		
		father.name = "홍길동";
		son.name = "홍지동";
		
		System.out.println(father.name+","+father.addr);
		System.out.println(son.name+","+son.addr);
		
	}
}
