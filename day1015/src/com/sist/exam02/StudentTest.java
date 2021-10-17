package com.sist.exam02;
import java.util.Scanner;
public class StudentTest {

	public static void main(String[] args) {
		Student s;
		Scanner sc = new Scanner(System.in);
		int data;
		String name,number,major;
		int grade;
		double credits;
		
		do {
			System.out.print("학부생이면 1,대학원생이면 2를 입력하세요==>");
			data = sc.nextInt();
		}while(data!=1 && data!=2);
		
		System.out.print("학생의 이름을 입력하세요==>");
		name = sc.next();
		System.out.print("학생의 학번을 입력하세요==>");
		number = sc.next();
		System.out.print("학생의 전공을 입력하세요==>");
		major = sc.next();
		System.out.print("학생의 학년을 입력하세요==>");
		grade = sc.nextInt();
		System.out.print("학생의 이수학점을 입력하세요==>");
		credits = sc.nextDouble();
		
		switch(data){
		case 1:
			String club;
			System.out.print("동아리를 입력하세요==>");
			club = sc.next();
			s = new UnderGraduate(name,number,major,grade,credits,club);
			break;
		default:
			String type;
			double rate;
			System.out.print("조교유형을 입력하세요(교육/연구)==>");
			type = sc.next();
			System.out.print("장학금 비율을 입력하세요==>");
			rate = sc.nextDouble();
			s = new Graduate(name,number,major,grade,credits,type,rate);	
		}
		System.out.println(s);
		
		String []n = new [2];
		String []n2 = new [2];
		String []m = new [2];
		int []g = new [2];
		double []c = new[2];
		
		
		
		
		
		
		
		/*
		UnderGraduate underGraduate = new UnderGraduate("홍길동", "20211234", "컴퓨터공학", 1, 24.0, "방송댄스");
		Graduate graduate = new Graduate("이순신", "20211111", "인공지능", 2, 15, "연구조교", 1);
		System.out.println(underGraduate);
		System.out.println(graduate);
		*/
				
	}

}
