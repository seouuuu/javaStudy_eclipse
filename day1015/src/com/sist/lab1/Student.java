package com.sist.lab1;

public class Student extends Human {
	public String major;

	public Student(String name,int age, String major){
		super(name,age);
		this.major = major;
	}
	public void setMajor(String major){
		this.major = major;
	}
	public String getMajor(){
		return major;
	}
	public String toString(){
		return super.toString()+", ����:"+major+", ��������:"+profession;
	}
	public String getProfession() {
		return super.getProfession()
	}
	public static void main(String[] args) 
	{
		Student s1 = new Student("����",21,"��ǻ��");
		Student s2 = new Student("����",22,"�濵");
		Student s3 = new Student("����",24,"����");

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}

}
