package com.sist.exam05;

import java.util.GregorianCalendar;
import java.util.Scanner;
public class PrintCalendarExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �Է��ϼ���==>");
		int year = sc.nextInt();
		System.out.print("���� �Է��ϼ���==>");
		int month = sc.nextInt();
		
		GregorianCalendar user = new GregorianCalendar(year,month-1,1); //month-1
		int day = user.get(GregorianCalendar.DAY_OF_WEEK);
		
		System.out.printf("%d�� %d��\n",year,month);          //month�� 1 ���ϸ� �ȵ�
		
		//�������
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
		
		//���� 1���� ���ϸ�ŭ ��ĭ ���
		for(int i=1;i<day;i++) {                          //day-1�̴� ��ȣ����
			System.out.print("\t");
		}
		
		int []lastDate = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		for(int i=1; i<=lastDate[month-1];i++) {         //month-1
			System.out.print(i+"\t");
			if( (i+day-1) % 7 == 0 ) {                   //day-1
				System.out.println();
			}
		}
	}
}
