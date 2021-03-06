package com.sist.exam02;

import java.util.ArrayList;

class Person{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void sayHello() {
		System.out.println(name + "님, 안녕하세요!");
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
public class ArrayListTest02 {

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		list.add(true);
		list.add(new Person("홍길동",20));   //a
		list.add(new Person("이순신",40));   //b
		list.add(26.7);
		list.add(new Person("유관순",30));   //c
		list.add("안녕 자바");
		list.add(2021);
		
		//list 데이터가 있는 만큼 반복실행하면서 데이터를 하나씩 꺼내 sayHello 호출
		for(int i=0; i<list.size() ;i++) {
			Object obj = list.get(i);
			System.out.println(obj);
			if(obj instanceof Person) {
				((Person)obj).sayHello();
			}
			
			
			//Person p = (Person)list.get(i);
			//p.sayHello();    //a,b,c만 있을때 가능
		}
		
		

	}

}
