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
		System.out.println(name + "��, �ȳ��ϼ���!");
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
		list.add(new Person("ȫ�浿",20));   //a
		list.add(new Person("�̼���",40));   //b
		list.add(26.7);
		list.add(new Person("������",30));   //c
		list.add("�ȳ� �ڹ�");
		list.add(2021);
		
		//list �����Ͱ� �ִ� ��ŭ �ݺ������ϸ鼭 �����͸� �ϳ��� ���� sayHello ȣ��
		for(int i=0; i<list.size() ;i++) {
			Object obj = list.get(i);
			System.out.println(obj);
			if(obj instanceof Person) {
				((Person)obj).sayHello();
			}
			
			
			//Person p = (Person)list.get(i);
			//p.sayHello();    //a,b,c�� ������ ����
		}
		
		

	}

}
