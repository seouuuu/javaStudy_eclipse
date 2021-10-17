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
		return super.toString()+", 전공:"+major+", 현재직업:"+profession;
	}
	public String getProfession() {
		return super.getProfession()
	}
	public static void main(String[] args) 
	{
		Student s1 = new Student("명진",21,"컴퓨터");
		Student s2 = new Student("미현",22,"경영");
		Student s3 = new Student("용준",24,"경제");

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}

}
