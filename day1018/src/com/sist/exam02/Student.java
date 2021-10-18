package com.sist.exam02;

import com.sist.exam01.Human;

public class Student extends Human {
	String major;

	public Student(String name, int age, String major) {
		super(name, age);
		System.out.println("Student�� ������ ������.");
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "Student [major=" + major + ", name=" + name + ", age=" + age + "]";
	}
	
	public static void main(String[] args) {
		Student student = new Student("����", 21, "��ǻ��");
		Student student2 = new Student("����", 22, "�濵");
		Student student3 = new Student("����", 24, "����");
		
		System.out.println(student);
		System.out.println(student2);
		System.out.println(student3);
		
		System.out.println(student.getProfession());
		System.out.println(student2.getProfession());
		System.out.println(student3.getProfession());
	}

	@Override
	public String getProfession() {
		// TODO Auto-generated method stub
		return "�л�";
	}

	
	

}
