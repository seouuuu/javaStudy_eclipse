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
			System.out.print("�кλ��̸� 1,���п����̸� 2�� �Է��ϼ���==>");
			data = sc.nextInt();
		}while(data!=1 && data!=2);
		
		System.out.print("�л��� �̸��� �Է��ϼ���==>");
		name = sc.next();
		System.out.print("�л��� �й��� �Է��ϼ���==>");
		number = sc.next();
		System.out.print("�л��� ������ �Է��ϼ���==>");
		major = sc.next();
		System.out.print("�л��� �г��� �Է��ϼ���==>");
		grade = sc.nextInt();
		System.out.print("�л��� �̼������� �Է��ϼ���==>");
		credits = sc.nextDouble();
		
		switch(data){
		case 1:
			String club;
			System.out.print("���Ƹ��� �Է��ϼ���==>");
			club = sc.next();
			s = new UnderGraduate(name,number,major,grade,credits,club);
			break;
		default:
			String type;
			double rate;
			System.out.print("���������� �Է��ϼ���(����/����)==>");
			type = sc.next();
			System.out.print("���б� ������ �Է��ϼ���==>");
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
		UnderGraduate underGraduate = new UnderGraduate("ȫ�浿", "20211234", "��ǻ�Ͱ���", 1, 24.0, "��۴�");
		Graduate graduate = new Graduate("�̼���", "20211111", "�ΰ�����", 2, 15, "��������", 1);
		System.out.println(underGraduate);
		System.out.println(graduate);
		*/
				
	}

}
