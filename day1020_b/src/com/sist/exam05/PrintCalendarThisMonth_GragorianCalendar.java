package com.sist.exam05;

import java.util.GregorianCalendar;
//GregorianCalendar �̿�
public class PrintCalendarThisMonth_GragorianCalendar {

	public static void main(String[] args) {
		GregorianCalendar today = new GregorianCalendar();
		int year = today.get(GregorianCalendar.YEAR);           //����
		int month  = today.get(GregorianCalendar.MONTH);        //��
		
		GregorianCalendar startDate = new GregorianCalendar(year,month,1); //1�� ����
		int day = startDate.get(GregorianCalendar.DAY_OF_WEEK);        //day-1 �ؾ���
		
		System.out.printf("%d�� %d��\n",year,month+1);
		
		//�������
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
		
		//���� 1���� ���ϸ�ŭ ��ĭ ���
		for(int i=1;i<day;i++) {             //day-1�̴� ��ȣ����
			System.out.print("\t");
		}
		
		int []lastDate = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		for(int i=1; i<=lastDate[month];i++) { 
			System.out.print(i+"\t");
			if( (i+day-1) % 7 == 0 ) {       //day-1
				System.out.println();
			}
		}
	}
}
